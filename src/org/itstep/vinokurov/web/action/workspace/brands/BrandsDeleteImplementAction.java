package org.itstep.vinokurov.web.action.workspace.brands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.logic.LogicException;

public class BrandsDeleteImplementAction extends BaseBrandsAction{
	private BrandsService brandsService;
	
	public void setBrandsService(BrandsService brandsService) {
		this.brandsService = brandsService;
	}

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		String id = req.getParameter("id");
		if(id != null) {
			brandsService.delete(Long.parseLong(id));
			return new Result("/workspace/brands");
		}
		return null;
	}
}
