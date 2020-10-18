package org.itstep.vinokurov.web.action.workspace.brands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.domain.Brands;
import org.itstep.vinokurov.logic.BrandsService;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.web.action.Action;

public class BrandsSaveAction implements Action{
	private BrandsService<Brands, Long> brandsService;
	
	public void setBrandsService(BrandsService<Brands, Long> brandsService) {
		this.brandsService = brandsService;
	}

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		String id = req.getParameter("id");
		
		String name = req.getParameter("name");
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException();
		}

		Brands brands = new Brands();
		if(id != null) {
			brands.setId(Long.parseLong(id));
		}
		brands.setName(name);
	
		brandsService.save(brands);
		return new Result("/workspace/brands");
	}
}
