package org.itstep.vinokurov.web.action.workspace.tnla;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.domain.CableCategory;
import org.itstep.vinokurov.domain.Tnla;
import org.itstep.vinokurov.domain.TnlaAndCableCategory;
import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.TnlaAndCableCategoryService;
import org.itstep.vinokurov.logic.TnlaService;

public class TnlaAndCableCategoryAction extends BaseTnlaAndCableCategoryAction{
	private TnlaService tnlaService;
	private CableCategoryService cableCategoryService;
	private TnlaAndCableCategoryService<TnlaAndCableCategory, Long> tnlaAndCableCategory;
	
	public void setTnlaService(TnlaService tnlaService) {
		this.tnlaService = tnlaService;
	}

	public void setCableCategoryService(CableCategoryService cableCategoryService) {
		this.cableCategoryService = cableCategoryService;
	}
	
	public void setTnlaAndCableCategoryService(TnlaAndCableCategoryService<TnlaAndCableCategory, Long> tnlaAndCableCategory) {
		this.tnlaAndCableCategory = tnlaAndCableCategory;
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
			Set<Long> idCableCategories = tnlaAndCableCategory.findById(Long.parseLong(id));
			if(!idCableCategories.isEmpty()) {
				Map<Long, Boolean> cableCategoryChecked = new HashMap<>();
				for(int i = 0; i < cableCategories.size(); i++) {
					Long idCableCategory = cableCategories.get(i).getId();
					if(idCableCategories.contains(idCableCategory)) {
						cableCategoryChecked.put(idCableCategory, true);
					} else {
						cableCategoryChecked.put(idCableCategory, false);
					}
				}
				req.setAttribute("cableCategoryChecked", cableCategoryChecked);
			} else {
				req.setAttribute("cableCategoryChecked", null);
			}
			req.setAttribute("tnla", tnla);
			req.setAttribute("cableCategories", cableCategories);
			return null;
		}
		return null;
	}
}
