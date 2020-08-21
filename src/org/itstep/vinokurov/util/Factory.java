package org.itstep.vinokurov.util;

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
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaAddAction;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaDelegateAction;

public class Factory implements AutoCloseable{
	
	private Map<String, ActionFactory> actions = new HashMap<>();
	{
		ActionFactory mainActionFactory = () -> getMainAction();
		actions.put("/workspace/tnla", () -> getTnlaAction());
		actions.put("/workspace/tnla/delegate", () -> getTnlaDelegateAction());
		actions.put("/workspace/tnla/add", () -> getTnlaAddAction());
		//actions.put("/workspace/tnla/save", () -> getTnlaSeveAction());
	}
	
	public Action getAction(String url) throws LogicException {
		ActionFactory factory = actions.get(url);
		if(factory != null) {
			return factory.getInstance();
		}
		return null;
	}
	
	private Action mainAction = null;
	public Action getMainAction() throws LogicException {
		if(mainAction == null) {
			mainAction = new MainAction();
		}
		return mainAction;
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
	
	private Action tnlaDelegateAction = null;
	public Action getTnlaDelegateAction() throws LogicException {
		if(tnlaDelegateAction == null) {
			TnlaDelegateAction tnlaDelegateActionImpl = new TnlaDelegateAction();
			tnlaDelegateAction = tnlaDelegateActionImpl;
		}
		return tnlaDelegateAction;
	}

	private Action tnlaAddAction = null;
	public Action getTnlaAddAction() throws LogicException {
		if(tnlaAddAction == null) {
			TnlaAddAction tnlaAddActionImpl = new TnlaAddAction();
			tnlaAddAction = tnlaAddActionImpl;
		}
		return tnlaAddAction;
	}	
	
/*	private Action tnlaSaveAction = null;
	public Action getTnlaSaveAction() throws LogicException {
		if(tnlaSaveAction == null) {
			TnlaSaveAction tnlaSaveActionImpl = new TnlaSaveAction();
			tnlaSaveAction = tnlaSaveActionImpl;
			tnlaSaveActionImpl.setTnlaService(getTnlaService());
		}
		return tnlaSaveAction;
	}*/
	
	
	
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
}