package org.itstep.vinokurov;

import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.TnlaService;
import org.itstep.vinokurov.logic.TnlaServiceImpl;
import org.itstep.vinokurov.storage.TnlaDao;
import org.itstep.vinokurov.ui.Command;
import org.itstep.vinokurov.ui.TnlaListCommand;
import org.itstep.vinokurov.ui.TnlaSaveCommand;

public class Factory implements AutoCloseable{
	
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
	
	private TnlaDao tnlaDao = null;
	public TnlaDao getTnlaDao() {
		// TODO create the TnlaDaoImpl
		return null;
	}

	@Override
	public void close() throws Exception {
				
	}
	
}
