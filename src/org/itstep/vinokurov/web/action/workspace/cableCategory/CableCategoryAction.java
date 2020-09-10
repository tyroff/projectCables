package org.itstep.vinokurov.web.action.workspace.cableCategory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.domain.CableCategory;
import org.itstep.vinokurov.logic.LogicException;

public class CableCategoryAction extends BaseCableCategoryAction{

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
			List<CableCategory> cableCategories = getCableCategoryService().findAll();
			req.setAttribute("cableCategories", cableCategories);
			return null;
	}
}
