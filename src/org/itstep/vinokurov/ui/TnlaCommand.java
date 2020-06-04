package org.itstep.vinokurov.ui;

import org.itstep.vinokurov.logic.TnlaService;

public abstract class TnlaCommand implements Command {
	private TnlaService tnlaService;

	public TnlaService getTnlaService() {
		return tnlaService;
	}

	public void setTnlaService(TnlaService tnlaService) {
		this.tnlaService = tnlaService;
	}
	
	
}
