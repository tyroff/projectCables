package org.itstep.vinokurov.web.action.workspace.tnla;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.domain.CableCategory;
import org.itstep.vinokurov.domain.Tnla;
import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.TnlaService;
import org.itstep.vinokurov.web.action.Action;

public class TnlaAndCableCategoryAction extends BaseTnlaAndCableCategoryAction{
	private TnlaService tnlaService;
	private CableCategoryService cableCategoryService;
	
	
	public void setTnlaService(TnlaService tnlaService) {
		this.tnlaService = tnlaService;
	}

	public void setCableCategoryService(CableCategoryService cableCategoryService) {
		this.cableCategoryService = cableCategoryService;
	}

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		String id = req.getParameter("id");
		if(id != null) {
			Tnla tnla = tnlaService.findById(Long.parseLong(id));
			if(tnla == null) {
				throw new IllegalArgumentException();
			}
			List<CableCategory> cableCategories = cableCategoryService.findAll();
			req.setAttribute("tnla", tnla);
			req.setAttribute("cableCategories", cableCategories);
			return null;
		}
		return null;
	}
}
