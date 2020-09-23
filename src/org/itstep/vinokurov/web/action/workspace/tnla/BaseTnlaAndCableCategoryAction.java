package org.itstep.vinokurov.web.action.workspace.tnla;

import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.logic.TnlaService;
import org.itstep.vinokurov.web.action.Action;

public abstract class BaseTnlaAndCableCategoryAction implements Action{
	private CableCategoryService cableCategoryService;
	private TnlaService tnlaService;

	protected CableCategoryService getCableCategoryService() {
		return cableCategoryService;
	}

	public void setCableCategoryService(CableCategoryService cableCategoryService) {
		this.cableCategoryService = cableCategoryService;
	}
	

	protected TnlaService getTnlaService() {
		return tnlaService;
	}

	public void setTnlaService(TnlaService tnlaService) {
		this.tnlaService = tnlaService;
	}
}
