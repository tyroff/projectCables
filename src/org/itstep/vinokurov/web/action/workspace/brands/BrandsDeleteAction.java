package org.itstep.vinokurov.web.action.workspace.brands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.domain.CableCategory;
import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.logic.LogicException;

public class BrandsDeleteAction extends BaseBrandsAction{
	private BrandsService brandsService;
	
	public void setBrandsService(BrandsService brandsService) {
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
