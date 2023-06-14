package com.nttdata.training.web.handlers;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.nttdata.dbcon.ConnectionHolder;
import com.nttdata.dbcon.DBConnectionException;

public class MyListenerClass implements ServletContextListener {


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			ConnectionHolder holder = ConnectionHolder.getInstance();

			holder.dispose();
			
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

}
