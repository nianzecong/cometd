package com.yesway.webnotify.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yesway.webnotify.cfg.AppConfig;

public class InitListener extends HttpServlet implements ServletContextListener {

	public Logger log = LoggerFactory.getLogger(InitListener.class);
	
    public void contextDestroyed(ServletContextEvent arg0) {
    	log.debug("==== 通知中心系统关闭 ====");
    }

    public void contextInitialized(ServletContextEvent arg0) {
    	log.debug("==== 通知中心系统启动 ====");
    	AppConfig.configure(arg0.getServletContext().getRealPath("/")+ "/WEB-INF/appconfig.xml");
    }

}
		