package org.itstep.vinokurov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.logic.CableCategoryServiceImpl;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.TnlaService;
import org.itstep.vinokurov.logic.TnlaServiceImpl;
import org.itstep.vinokurov.logic.UserService;
import org.itstep.vinokurov.logic.UserServiceImpl;
import org.itstep.vinokurov.storage.CableCategoryDao;
import org.itstep.vinokurov.storage.TnlaDao;
import org.itstep.vinokurov.storage.UserDao;
import org.itstep.vinokurov.storage.postgres.CableCategoryDbDaoImpl;
import org.itstep.vinokurov.storage.postgres.TnlaDbDaoImpl;
import org.itstep.vinokurov.storage.postgres.UserDbDaoImpl;
import org.itstep.vinokurov.web.action.Action;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaAction;

public class Factory implements AutoCloseable{
	
	private Map<String, Action> actions = new HashMap<>();
	public Factory() throws LogicException {
		actions.put("workspace/tnla", getTnlaAction());
	}
	public Action getAction(String url) throws LogicException {
		return null;
		
	}
	
	private Action tnlaAction = null;
	public Action getTnlaAction() throws LogicException {
		if(tnlaAction == null) {
			TnlaAction tnlaActionImpl = new TnlaAction();
			tnlaAction = tnlaActionImpl;
			tnlaActionImpl.setTnlaService(getTnlaService());
		}
		return tnlaAction;
	}
	
	private CableCategoryService cableCategoryService = null;
	public CableCategoryService getCableCategoryService() throws LogicException {
		if(cableCategoryService == null) {
			if(cableCategoryService == null) {
				CableCategoryServiceImpl service = new CableCategoryServiceImpl();
				cableCategoryService = service;
				service.setCableCategoryDao(getCableCategoryDao());
			}
		}
		return cableCategoryService;
	}
	
	private TnlaService tnlaService = null;
	public TnlaService getTnlaService() throws LogicException {
		if(tnlaService == null) {
			if(tnlaService == null) {
				TnlaServiceImpl service = new TnlaServiceImpl();
				tnlaService = service;
				service.setTnlaDao(getTnlaDao());
			}
		}
		return tnlaService;
	}
	
	private UserService userService = null;
	public UserService getUserService() throws LogicException {
		if(userService == null) {
			if(userService == null) {
				UserServiceImpl service = new UserServiceImpl();
				userService = service;
				service.setUserDao(getUserDao());
			}
		}
		return userService;
	}

	private CableCategoryDao cableCategoryDao = null;
	public CableCategoryDao getCableCategoryDao() throws LogicException{
		if(cableCategoryDao == null) {
			CableCategoryDbDaoImpl cableCategoryDbDaoImpl = new CableCategoryDbDaoImpl();
			cableCategoryDao = cableCategoryDbDaoImpl;
			cableCategoryDbDaoImpl.setConnection(getConnection());
		}
		return cableCategoryDao;
	}
	
	private TnlaDao tnlaDao = null;
	public TnlaDao getTnlaDao() throws LogicException{
		if(tnlaDao == null) {
			TnlaDbDaoImpl tnlaDbDaoImpl = new TnlaDbDaoImpl();
			tnlaDao = tnlaDbDaoImpl;
			tnlaDbDaoImpl.setConnection(getConnection());
		}
		return tnlaDao;
	}
	
	private UserDao userDao = null;
	public UserDao getUserDao() throws LogicException{
		if(userDao == null) {
			UserDbDaoImpl userDbDaoImpl = new UserDbDaoImpl();
			userDao = userDbDaoImpl;
			userDbDaoImpl.setConnection(getConnection());
		}
		return userDao;
	}

	private Connection connection = null;
	public Connection getConnection() throws LogicException {
		if(connection == null) {
			try {
				connection = DriverManager.getConnection("jdbc:postgresql://localhost/cables", "root", "hello");
			} catch(SQLException e) {
				throw new LogicException(e);
			}
		}
		return connection;
	}

	@Override
	public void close(){
		try {
			connection.close();
		} catch(Exception e) {}
	}
	
	private static interface ActionFactory {
		Action getInstance() throws LogicException;
	}
	
	private class TnlaActionFactory implements ActionFactory {

		@Override
		public Action getInstance() throws LogicException {
			return getTnlaAction();
		}
		
	}
}
