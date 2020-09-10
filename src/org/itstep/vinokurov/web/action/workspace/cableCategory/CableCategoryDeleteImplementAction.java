package org.itstep.vinokurov.web.action.workspace.cableCategory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.logic.LogicException;

public class CableCategoryDeleteImplementAction extends BaseCableCategoryAction{
	private CableCategoryService cableCategoryService;
	
	public void setCableCategoryService(CableCategoryService cableCategoryService) {
		this.cableCategoryService = cableCategoryService;
	}

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		String id = req.getParameter("id");
		if(id != null) {
			cableCategoryService.delete(Long.parseLong(id));
			return new Result("/workspace/cableCategory");
		}
		return null;
	}
}
