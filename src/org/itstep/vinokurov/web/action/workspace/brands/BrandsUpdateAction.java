package org.itstep.vinokurov.web.action.workspace.brands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.domain.Brands;
import org.itstep.vinokurov.domain.CableCategory;
import org.itstep.vinokurov.domain.Tnla;
import org.itstep.vinokurov.logic.BrandsService;
import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.TnlaService;

public class BrandsUpdateAction extends BaseBrandsAction{
	private BrandsService<Brands, Long> brandsService;
	
	public void setBrandsService(BrandsService<Brands, Long> brandsService) {
		this.brandsService = brandsService;
	}

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		String id = req.getParameter("id");
		if(id != null) {
			Brands brands = brandsService.findById(Long.parseLong(id));
			if(brands == null) {
				throw new IllegalArgumentException();
			}
			req.setAttribute("brands", brands);
			return null;
		}
		return null;
	}
}
