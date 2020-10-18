package org.itstep.vinokurov.web.action.workspace.tnla;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.domain.TnlaAndCableCategory;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.TnlaAndCableCategoryService;
import org.itstep.vinokurov.web.action.Action;

public class TnlaAndCableCategorySaveAction implements Action{
	private TnlaAndCableCategoryService<TnlaAndCableCategory, Long> tnlaAndCableCategory;
	
	public void setTnlaAndCableCategoryService(TnlaAndCableCategoryService<TnlaAndCableCategory, Long> tnlaAndCableCategory) {
		this.tnlaAndCableCategory = tnlaAndCableCategory;
	}

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		Long idTnla = Long.parseLong(req.getParameter("idTnla"));
		Set<Long> idCheckedCableCategories = tnlaAndCableCategory.findBySetIdes(idTnla);
		Set<Long> newIdCheckedCableCategories = new HashSet<>();
		Long idChecked = 0L;
		if(req.getParameterValues("idCableCategory") != null) {
			for(String value : req.getParameterValues("idCableCategory")){
				idChecked = Long.parseLong(value);
				newIdCheckedCableCategories.add(idChecked);
				if(!idCheckedCableCategories.contains(idChecked)) {
					tnlaAndCableCategory.save(idTnla, idChecked);
				}
			}
		}
			for(Long idUnchecked : idCheckedCableCategories) {
				if(!newIdCheckedCableCategories.contains(idUnchecked)) {
					tnlaAndCableCategory.delete(idTnla, idUnchecked);
				}
			}
		return new Result("/workspace/tnla");
	}
}
