package org.itstep.vinokurov.web.action.workspace.cableCategory;

import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.web.action.Action;

public abstract class BaseCableCategoryAction implements Action{
	private CableCategoryService cableCategoryService;

	protected CableCategoryService getCableCategoryService() {
		return cableCategoryService;
	}

	public void setCableCategoryService(CableCategoryService cableCategoryService) {
		this.cableCategoryService = cableCategoryService;
	}
}
