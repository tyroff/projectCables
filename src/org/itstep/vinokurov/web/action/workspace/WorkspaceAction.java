package org.itstep.vinokurov.web.action.workspace;

import java.util.HashMap;
import java.util.HashSet;
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
import org.itstep.vinokurov.web.action.Action;

public class WorkspaceAction implements Action{
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
		Set<Long> idesCableCategory = null;
		Set<Tnla> tnlas = null;
		CableCategory cableCategory = null;

		Map<CableCategory, Set<Tnla>> cableCategoryAndTnlas = new HashMap<>();
		List<TnlaAndCableCategory> tnlaAndCableCategories = tnlaAndCableCategory.findAll();
		for(TnlaAndCableCategory tnlaAndCableCategory : tnlaAndCableCategories) {
			Tnla tnla = tnlaService.findById(tnlaAndCableCategory.getIdTnla());
			idesCableCategory = tnlaAndCableCategory.getIdesOfCableCategory();
			if(!idesCableCategory.isEmpty()) {
				for(Long idCableCategory : idesCableCategory) {
					cableCategory = cableCategoryService.findById(idCableCategory);
					if(cableCategoryAndTnlas.get(cableCategory) == null) {
						tnlas = new HashSet<>();
						tnlas.add(tnla);
					} else {
						tnlas = cableCategoryAndTnlas.get(cableCategory);
						tnlas.add(tnla);
					}
				}
				cableCategoryAndTnlas.put(cableCategory, tnlas);
			}
		}
		
		req.setAttribute("cableCategoryAndTnlas", cableCategoryAndTnlas);
		return null;
	}
}
