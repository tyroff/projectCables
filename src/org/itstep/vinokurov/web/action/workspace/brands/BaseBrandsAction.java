package org.itstep.vinokurov.web.action.workspace.brands;

import org.itstep.vinokurov.domain.Brands;
import org.itstep.vinokurov.logic.BrandsService;
import org.itstep.vinokurov.web.action.Action;

public abstract class BaseBrandsAction implements Action{
	private BrandsService<Brands, Long> brandsService;

	protected BrandsService<Brands, Long> getBrandsService() {
		return brandsService;
	}

	public void setBrandsService(BrandsService<Brands, Long> brandsService) {
		this.brandsService = brandsService;
	}
}
