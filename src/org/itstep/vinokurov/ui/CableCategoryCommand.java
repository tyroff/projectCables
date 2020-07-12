package org.itstep.vinokurov.ui;

import org.itstep.vinokurov.logic.TnlaService;

public abstract class CableCategoryCommand implements Command {
	private CableCategoryService cableCategotyService;

	public CableCategoryService getCableCategoryService() {
		return cableCategotyService;
	}

	public void setCableCategoryService(CableCategoryService cableCategotyService) {
		this.cableCategotyService = cableCategotyService;
	}
	
	
}
