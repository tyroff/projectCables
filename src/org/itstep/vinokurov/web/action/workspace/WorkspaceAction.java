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
		Map<CableCategory, Set<Tnla>> cableCategoryAndTnlas = new HashMap<>();
		List<CableCategory> cableCategories = cableCategoryService.findAll();
		List<TnlaAndCableCategory> tnlaAndCableCategories = tnlaAndCableCategory.findAll();
		
		for(CableCategory mapCableCategory : cableCategories) {
			cableCategoryAndTnlas.put(mapCableCategory, null);
		}
		
		Set<Long> cableCategory = new HashSet<>();
		Set<Tnla> tnlas = new HashSet<>();
		for(TnlaAndCableCategory tnlaAndCableCategory : tnlaAndCableCategories) {
			Tnla tnla = tnlaService.findById(tnlaAndCableCategory.getIdTnla());
			cableCategory = tnlaAndCableCategory.getIdesOfCableCategory();
			for(Long idCableCategory : cableCategory) {
				CableCategory key = cableCategoryService.findById(idCableCategory);
				tnlas = cableCategoryAndTnlas.get(key);
				tnlas.add(tnla);
				cableCategoryAndTnlas.put(key, tnlas);
			}
		}
		req.setAttribute("cableCategoryAndTnlas", cableCategoryAndTnlas);
		return null;
	}
}
