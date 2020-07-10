package org.itstep.vinokurov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.logic.CableCategoryServiceImpl;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.TnlaService;
import org.itstep.vinokurov.logic.TnlaServiceImpl;
import org.itstep.vinokurov.storage.CableCategoryDao;
import org.itstep.vinokurov.storage.TnlaDao;
import org.itstep.vinokurov.storage.postgres.CableCategoryDbDaoImpl;
import org.itstep.vinokurov.storage.postgres.TnlaDbDaoImpl;
import org.itstep.vinokurov.ui.Command;
import org.itstep.vinokurov.ui.TnlaDeleteCommand;
import org.itstep.vinokurov.ui.TnlaListCommand;
import org.itstep.vinokurov.ui.TnlaSaveCommand;

public class Factory implements AutoCloseable{
	
	private Command tnlaDeleteCommand = null;
	public Command getTnlaDeleteCommand() throws LogicException {
		if(tnlaDeleteCommand == null) {
			TnlaDeleteCommand command = new TnlaDeleteCommand();
			tnlaDeleteCommand = command;
			command.setTnlaService(getTnlaService());
		}
		return tnlaDeleteCommand;
	}
	
	private Command tnlaListCommand = null;
	public Command getTnlaListCommand() throws LogicException {
		if (tnlaListCommand == null) {
			TnlaListCommand command = new TnlaListCommand();
			tnlaListCommand = command;
			command.setTnlaService(getTnlaService());
		}
		return tnlaListCommand;
	}
	
	private Command tnlaSaveCommand = null;
	public Command getTnlaSaveCommand() throws LogicException {
		if(tnlaSaveCommand == null) {
			TnlaSaveCommand command = new TnlaSaveCommand();
			tnlaSaveCommand = command;
			command.setTnlaService(getTnlaService());
		}
		return tnlaSaveCommand;
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
	
}
