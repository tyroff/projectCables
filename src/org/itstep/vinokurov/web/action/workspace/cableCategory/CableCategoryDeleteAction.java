package org.itstep.vinokurov.web.action.workspace.cableCategory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.domain.CableCategory;
import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.logic.LogicException;

public class CableCategoryDeleteAction extends BaseCableCategoryAction{
	private CableCategoryService cableCategoryService;
	
	public void setCableCategoryService(CableCategoryService cableCategoryService) {
		this.cableCategoryService = cableCategoryService;
	}

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		String id = req.getParameter("id");
		if(id != null) {
			CableCategory cableCategory = cableCategoryService.findById(Long.parseLong(id));
			if(cableCategory == null) {
				throw new IllegalArgumentException();
			}
			req.setAttribute("cableCategory", cableCategory);
			return null;
		}
		return null;
	}
}
