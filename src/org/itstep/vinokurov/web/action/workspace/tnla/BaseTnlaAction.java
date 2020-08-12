package org.itstep.vinokurov.web.action.workspace.tnla;

import org.itstep.vinokurov.logic.TnlaService;
import org.itstep.vinokurov.web.action.Action;

public abstract class BaseTnlaAction implements Action{
	private TnlaService tnlaService;

	protected TnlaService getTnlaService() {
		return tnlaService;
	}

	public void setTnlaService(TnlaService tnlaService) {
		this.tnlaService = tnlaService;
	}
}
