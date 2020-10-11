package org.itstep.vinokurov.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.itstep.vinokurov.domain.TnlaAndCableCategory;
import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.logic.CableCategoryServiceImpl;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.TnlaAndCableCategoryService;
import org.itstep.vinokurov.logic.TnlaAndCableCategoryServiceImpl;
import org.itstep.vinokurov.logic.TnlaService;
import org.itstep.vinokurov.logic.TnlaServiceImpl;
import org.itstep.vinokurov.logic.UserService;
import org.itstep.vinokurov.logic.UserServiceImpl;
import org.itstep.vinokurov.storage.CableCategoryDao;
import org.itstep.vinokurov.storage.TnlaAndCableCategoryDao;
import org.itstep.vinokurov.storage.TnlaDao;
import org.itstep.vinokurov.storage.UserDao;
import org.itstep.vinokurov.storage.postgres.CableCategoryDbDaoImpl;
import org.itstep.vinokurov.storage.postgres.TnlaAndCableCategoryDbDaoImpl;
import org.itstep.vinokurov.storage.postgres.TnlaDbDaoImpl;
import org.itstep.vinokurov.storage.postgres.UserDbDaoImpl;
import org.itstep.vinokurov.web.action.Action;
import org.itstep.vinokurov.web.action.MainAction;
import org.itstep.vinokurov.web.action.LoginAction;
import org.itstep.vinokurov.web.action.workspace.LogoutAction;
import org.itstep.vinokurov.web.action.workspace.WorkspaceAction;
import org.itstep.vinokurov.web.action.workspace.cableCategory.CableCategoryAction;
import org.itstep.vinokurov.web.action.workspace.cableCategory.CableCategoryAddAction;
import org.itstep.vinokurov.web.action.workspace.cableCategory.CableCategoryDelegateAction;
import org.itstep.vinokurov.web.action.workspace.cableCategory.CableCategoryDeleteAction;
import org.itstep.vinokurov.web.action.workspace.cableCategory.CableCategoryDeleteImplementAction;
import org.itstep.vinokurov.web.action.workspace.cableCategory.CableCategorySaveAction;
import org.itstep.vinokurov.web.action.workspace.cableCategory.CableCategoryUpdateAction;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaAction;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaAddAction;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaAndCableCategoryAction;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaAndCableCategorySaveAction;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaDelegateAction;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaDeleteAction;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaDeleteImplementAction;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaSaveAction;
import org.itstep.vinokurov.web.action.workspace.tnla.TnlaUpdateAction;

public class Factory implements AutoCloseable{
	
	private Map<String, ActionFactory> actions = new HashMap<>();
	{
		ActionFactory mainActionFactory = () -> getMainAction();
		actions.put("/index", mainActionFactory);
		actions.put("/login", () -> getLoginAction());
		actions.put("/logout", () -> getLogoutAction());
		actions.put("/workspace", () -> getWorkspaceAction());
		
		actions.put("/workspace/tnla", () -> getTnlaAction());
		actions.put("/workspace/tnla/delegate", () -> getTnlaDelegateAction());
		actions.put("/workspace/tnla/add", () -> getTnlaAddAction());
		actions.put("/workspace/tnla/save", () -> getTnlaSeveAction());
		actions.put("/workspace/tnla/update", () -> getTnlaUpdateAction());
		actions.put("/workspace/tnla/delete", () -> getTnlaDeleteAction());
		actions.put("/workspace/tnla/deleteImplement", () -> getTnlaDeleteImplementAction());
		actions.put("/workspace/tnla/tnlaAndCableCategory", () -> getTnlaAndCableCategoryAction());
		actions.put("/workspace/tnla/tnlaAndCableCategorySave", () -> getTnlaAndCableCategorySaveAction());		
		
		actions.put("/workspace/cableCategory", () -> getCableCategoryAction());
		actions.put("/workspace/cableCategory/delegate", () -> getCableCategoryDelegateAction());
		actions.put("/workspace/cableCategory/add", () -> getCableCategoryAddAction());
		actions.put("/workspace/cableCategory/save", () -> getCableCategorySeveAction());
		actions.put("/workspace/cableCategory/update", () -> getCableCategoryUpdateAction());
		actions.put("/workspace/cableCategory/delete", () -> getCableCategoryDeleteAction());
		actions.put("/workspace/cableCategory/deleteImplement", () -> getCableCategoryDeleteImplementAction());
	}
	
	public Action getAction(String url) throws LogicException {
		ActionFactory factory = actions.get(url);
		if(factory != null) {
			return factory.getInstance();
		}
		return null;
	}
	
	private Action mainAction = null;
	public Action getMainAction() {
		if(mainAction == null) {
			mainAction = new MainAction();
		}
		return mainAction;
	}
	
	private Action loginAction = null;
	public Action getLoginAction() throws LogicException{
		if(loginAction == null) {
			LoginAction loginActionImpl = new LoginAction();
			loginAction = loginActionImpl;
			loginActionImpl.setUserService(getUserService());
		}
		return loginAction;
	}
	
	private Action logoutAction = null;
	public Action getLogoutAction() throws LogicException {
		if(logoutAction == null) {
			logoutAction = new LogoutAction();
		}
		return logoutAction;
	}
	
	private Action workspaceAction = null;
	public Action getWorkspaceAction() throws LogicException {
		if(workspaceAction == null) {
			WorkspaceAction workspaceActionImpl = new WorkspaceAction();
			workspaceAction = workspaceActionImpl;
			workspaceActionImpl.setTnlaService(getTnlaService());
			workspaceActionImpl.setCableCategoryService(getCableCategoryService());
			workspaceActionImpl.setTnlaAndCableCategoryService(getTnlaAndCableCategoryService());
		}
		return workspaceAction;
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
	public Action getTnlaDelegateAction() {
		if(tnlaDelegateAction == null) {
			tnlaDelegateAction = new TnlaDelegateAction();
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
	
	private Action tnlaSaveAction = null;
	public Action getTnlaSeveAction() throws LogicException {
		if(tnlaSaveAction == null) {
			TnlaSaveAction tnlaSaveActionImpl = new TnlaSaveAction();
			tnlaSaveAction = tnlaSaveActionImpl;
			tnlaSaveActionImpl.setTnlaService(getTnlaService());
		}
		return tnlaSaveAction;
	}
	
	private Action tnlaUpdateAction = null;
	public Action getTnlaUpdateAction() throws LogicException {
		if(tnlaUpdateAction == null) {
			TnlaUpdateAction tnlaUpdateActionImpl = new TnlaUpdateAction();
			tnlaUpdateAction = tnlaUpdateActionImpl;
			tnlaUpdateActionImpl.setTnlaService(getTnlaService());
		}
		return tnlaUpdateAction;
	}
	
	private Action tnlaDeleteAction = null;
	public Action getTnlaDeleteAction() throws LogicException {
		if(tnlaDeleteAction == null) {
			TnlaDeleteAction tnlaDeleteActionImpl = new TnlaDeleteAction();
			tnlaDeleteAction = tnlaDeleteActionImpl;
			tnlaDeleteActionImpl.setTnlaService(getTnlaService());
		}
		return tnlaDeleteAction;
	}
	
	private Action tnlaDeleteImplementAction = null;
	public Action getTnlaDeleteImplementAction() throws LogicException {
		if(tnlaDeleteImplementAction == null) {
			TnlaDeleteImplementAction tnlaDeleteImplementActionImpl = new TnlaDeleteImplementAction();
			tnlaDeleteImplementAction = tnlaDeleteImplementActionImpl;
			tnlaDeleteImplementActionImpl.setTnlaService(getTnlaService());
		}
		return tnlaDeleteImplementAction;
	}
	
	private Action tnlaAndCableCategoryAction = null;
	public Action getTnlaAndCableCategoryAction() throws LogicException {
		if(tnlaAndCableCategoryAction == null) {
			TnlaAndCableCategoryAction tnlaAndCableCategoryActionImpl = new TnlaAndCableCategoryAction();
			tnlaAndCableCategoryAction = tnlaAndCableCategoryActionImpl;
			tnlaAndCableCategoryActionImpl.setTnlaService(getTnlaService());
			tnlaAndCableCategoryActionImpl.setCableCategoryService(getCableCategoryService());
			tnlaAndCableCategoryActionImpl.setTnlaAndCableCategoryService(getTnlaAndCableCategoryService());
		}
		return tnlaAndCableCategoryAction;
	}
	
	private Action tnlaAndCableCategorySaveAction = null;
	public Action getTnlaAndCableCategorySaveAction() throws LogicException {
		if(tnlaAndCableCategorySaveAction == null) {
			TnlaAndCableCategorySaveAction tnlaAndCableCategorySaveActionImpl = new TnlaAndCableCategorySaveAction();
			tnlaAndCableCategorySaveAction = tnlaAndCableCategorySaveActionImpl;
			tnlaAndCableCategorySaveActionImpl.setTnlaAndCableCategoryService(getTnlaAndCableCategoryService());
		}
		return tnlaAndCableCategorySaveAction;
	}
	
	private Action cableCategoryAction = null;
	public Action getCableCategoryAction() throws LogicException {
		if(cableCategoryAction == null) {
			CableCategoryAction cableCategoryActionImpl = new CableCategoryAction();
			cableCategoryAction = cableCategoryActionImpl;
			cableCategoryActionImpl.setCableCategoryService(getCableCategoryService());
		}
		return cableCategoryAction;
	}	
	
	private Action cableCategoryDelegateAction = null;
	public Action getCableCategoryDelegateAction() {
		if(cableCategoryDelegateAction == null) {
			cableCategoryDelegateAction = new CableCategoryDelegateAction();
		}
		return cableCategoryDelegateAction;
	}

	private Action cableCategoryAddAction = null;
	public Action getCableCategoryAddAction() throws LogicException {
		if(cableCategoryAddAction == null) {
			CableCategoryAddAction cableCategoryAddActionImpl = new CableCategoryAddAction();
			cableCategoryAddAction = cableCategoryAddActionImpl;
		}
		return cableCategoryAddAction;
	}	
	
	private Action cableCategorySaveAction = null;
	public Action getCableCategorySeveAction() throws LogicException {
		if(cableCategorySaveAction == null) {
			CableCategorySaveAction cableCategorySaveActionImpl = new CableCategorySaveAction();
			cableCategorySaveAction = cableCategorySaveActionImpl;
			cableCategorySaveActionImpl.setCableCategoryService(getCableCategoryService());
		}
		return cableCategorySaveAction;
	}
	
	private Action cableCategoryUpdateAction = null;
	public Action getCableCategoryUpdateAction() throws LogicException {
		if(cableCategoryUpdateAction == null) {
			CableCategoryUpdateAction cableCategoryUpdateActionImpl = new CableCategoryUpdateAction();
			cableCategoryUpdateAction = cableCategoryUpdateActionImpl;
			cableCategoryUpdateActionImpl.setCableCategoryService(getCableCategoryService());
		}
		return cableCategoryUpdateAction;
	}
	
	private Action cableCategoryDeleteAction = null;
	public Action getCableCategoryDeleteAction() throws LogicException {
		if(cableCategoryDeleteAction == null) {
			CableCategoryDeleteAction cableCategoryDeleteActionImpl = new CableCategoryDeleteAction();
			cableCategoryDeleteAction = cableCategoryDeleteActionImpl;
			cableCategoryDeleteActionImpl.setCableCategoryService(getCableCategoryService());
		}
		return cableCategoryDeleteAction;
	}
	
	private Action cableCategoryDeleteImplementAction = null;
	public Action getCableCategoryDeleteImplementAction() throws LogicException {
		if(cableCategoryDeleteImplementAction == null) {
			CableCategoryDeleteImplementAction cableCategoryDeleteImplementActionImpl = new CableCategoryDeleteImplementAction();
			cableCategoryDeleteImplementAction = cableCategoryDeleteImplementActionImpl;
			cableCategoryDeleteImplementActionImpl.setCableCategoryService(getCableCategoryService());
		}
		return cableCategoryDeleteImplementAction;
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

	private TnlaAndCableCategoryService<TnlaAndCableCategory, Long> tnlaAndCableCategoryService = null;
	public TnlaAndCableCategoryService<TnlaAndCableCategory, Long> getTnlaAndCableCategoryService() throws LogicException {
		if(tnlaAndCableCategoryService == null) {
			if(tnlaAndCableCategoryService == null) {
				TnlaAndCableCategoryServiceImpl service = new TnlaAndCableCategoryServiceImpl();
				tnlaAndCableCategoryService = service;
				service.setTnlaAndCableCategoryDao(getTnlaAndCableCategoryDao());
			}
		}
		return tnlaAndCableCategoryService;
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
	
	private TnlaDao tnlaDao = null;
	public TnlaDao getTnlaDao() throws LogicException{
		if(tnlaDao == null) {
			TnlaDbDaoImpl tnlaDbDaoImpl = new TnlaDbDaoImpl();
			tnlaDao = tnlaDbDaoImpl;
			tnlaDbDaoImpl.setConnection(getConnection());
		}
		return tnlaDao;
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
	
	private TnlaAndCableCategoryDao<TnlaAndCableCategory, Long> tnlaAndCableCategoryDao = null;
	public TnlaAndCableCategoryDao<TnlaAndCableCategory, Long> getTnlaAndCableCategoryDao() throws LogicException{
		if(tnlaAndCableCategoryDao == null) {
			TnlaAndCableCategoryDbDaoImpl tnlaAndCableCategoryDbDaoImpl = new TnlaAndCableCategoryDbDaoImpl();
			tnlaAndCableCategoryDao = tnlaAndCableCategoryDbDaoImpl;
			tnlaAndCableCategoryDbDaoImpl.setConnection(getConnection());
		}
		return tnlaAndCableCategoryDao;
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
