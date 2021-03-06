package org.itstep.vinokurov.web.action.workspace.cableCategory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.domain.CableCategory;
import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.web.action.Action;

public class CableCategorySaveAction implements Action{
	private CableCategoryService cableCategoryService;
	
	public void setCableCategoryService(CableCategoryService cableCategoryService) {
		this.cableCategoryService = cableCategoryService;
	}

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		String id = req.getParameter("id");
		
		String name = req.getParameter("name");
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException();
		}

		CableCategory cableCategory = new CableCategory();
		if(id != null) {
			cableCategory.setId(Long.parseLong(id));
		}
		cableCategory.setName(name);
	
		cableCategoryService.save(cableCategory);
		return new Result("/workspace/cableCategory");
	}
}
