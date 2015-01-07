package com.yesway.webnotify.cometd;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.cometd.annotation.Service;
import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.ServerChannel;
import org.cometd.bayeux.server.ServerMessage;
import org.cometd.bayeux.server.ServerSession;
import org.cometd.server.AbstractService;
import org.cometd.server.DefaultSecurityPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yesway.webnotify.cfg.AppConfig;
import com.yesway.webnotify.cfg.Environment;
import com.yesway.webnotify.soap.enterpriseauthenticationservice.EnterpriseAuthenticationServiceLocator;
import com.yesway.webnotify.soap.enterpriseauthenticationservice.ErrorMessage;
import com.yesway.webnotify.soap.enterpriseauthenticationservice.IEnterpriseAuthenticationService;

@Service("cometd")
public class CometdService extends AbstractService {

	private static final Logger log = LoggerFactory
			.getLogger(CometdService.class);

	// 获取企业鉴权接口  
	private IEnterpriseAuthenticationService getAuthenticationService() {
		EnterpriseAuthenticationServiceLocator service = new EnterpriseAuthenticationServiceLocator();
		service.setBasicHttpBinding_IEnterpriseAuthenticationServiceEndpointAddress(AppConfig
				.getParameter(Environment.AUTHENTICATIONSERVICE_ADDRESS));
		try {
			return service
					.getBasicHttpBinding_IEnterpriseAuthenticationService();
		} catch (ServiceException e) {
			log.error("获取企业鉴权接口错误：" + e.getMessage());
			return null;
		}
	}

	public CometdService(BayeuxServer bayeuxServer) {
		// 通过BayeuxServer对象和服务通道名称调用父类构造
		super(bayeuxServer, "cometd");
		// 订阅通道， 并指定消息到达通道时的回调函数
		addService("/service/*", "processCometd");
		// 鉴权
		this.getBayeux().setSecurityPolicy(new DefaultSecurityPolicy() {
			// 握手时进行企业鉴权
			@Override
			public boolean canHandshake(BayeuxServer server,
					ServerSession session, ServerMessage message) {
				boolean canHandshake = enterpriseAuthentication(
						(String) message.get("name"),
						(String) message.get("pwd"));
				log.debug("canHandshake:" + canHandshake);
				return canHandshake;
			}
		});
		this.getBayeux().addListener(new ServerSessionListener());
	}

	public void processCometd(ServerSession remote, Map<String, Object> data) {
		remote.deliver(getServerSession(), "/cometd", data, null);
	}

	public boolean broadcast(String _channel, Object data) {
		boolean result = false;
		ServerChannel channel = getBayeux().getChannel(_channel);
		if (channel != null) {
			channel.publish(getServerSession(), data, null);
			result = true;
		}
		return result;
	}

	public List<ServerChannel> getChannels() {
		return getBayeux().getChannels();
	}

	// 企业鉴权接口
	public boolean enterpriseAuthentication(String name, String pwd) {
		boolean result = false;
		try {
			result = getAuthenticationService().authentication(name, pwd);
		} catch (ErrorMessage e) {
			log.error("企业鉴权失败：" + e.getText());
		} catch (RemoteException e) {
			log.error("企业鉴权失败：" + e.getMessage());
		}
		return result;
	}
}
