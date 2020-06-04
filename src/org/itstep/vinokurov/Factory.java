package org.itstep.vinokurov;

import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.ui.Command;

public class Factory implements AutoCloseable{
	
	private Command tnlaListCommand = null;
	public Command getTnlaListCommand() throws LogicException {
		if (tnlaListCommand == null) {
			//TODO: to be continue!
		}
		return true;
	}
	
	
	
//	commands.put("list", factory.getTnlaListCommand());
//	commands.put("add", factory.getTnlaAddCommand());
//	commands.put("update", factory.getTnlaUpdateCommand());
	
	@Override
	public void close() throws Exception {
				
	}
	
}
