package org.itstep.vinokurov.web.action.workspace.brands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.domain.Brands;
import org.itstep.vinokurov.logic.LogicException;

public class BrandsAction extends BaseBrandsAction{

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
			List<Brands> brands = getBrandsService().findAll();
			req.setAttribute("brands", brands);
			return null;
	}
}
