package org.itstep.vinokurov.web.action.workspace.brands;

import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.web.action.Action;

public abstract class BaseBrandsAction implements Action{
	private BrandsService brandsyService;

	protected BrandsService getBrandsService() {
		return brandsyService;
	}

	public void setBrandsService(BrandsService brandsService) {
		this.brandsService = brandsService;
	}
}
