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
	
	
	
//	commands.compute("create", factory.getTnlaCreateCommand());
//	commands.compute("update", factory.getTnlaUpdateCommand());
//	commands.compute("delete", factory.getTnlaDeleteCommand());
	
	@Override
	public void close() throws Exception {
				
	}
	
}
