package org.itstep.vinokurov.web.action.workspace.tnla;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.domain.Tnla;
import org.itstep.vinokurov.domain.TnlaAndCableCategory;
import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.TnlaAndCableCategoryService;
import org.itstep.vinokurov.logic.TnlaService;
import org.itstep.vinokurov.web.action.Action;

public class TnlaAndCableCategorySaveAction implements Action{
	private TnlaAndCableCategoryService<TnlaAndCableCategory, Long> tnlaAndCableCategory;
	
	public void setTnlaAndCableCategoryService(TnlaAndCableCategoryService<TnlaAndCableCategory, Long> tnlaAndCableCategory) {
		this.tnlaAndCableCategory = tnlaAndCableCategory;
	}

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		String idTnla = req.getParameter("idTnla");
		if(idTnla == null || idTnla.isBlank()) {
			throw new IllegalArgumentException();
		}
		Set<Long> idCableCategories = tnlaAndCableCategory.findById(Long.parseLong(idTnla));
		Set<Long> newIdCableCategories = HZ;
		
		try {
			tnlaService.save(tnla);
			return new Result("/workspace/tnla");
		} catch (LogicException e) {
			return null;
		}
	}
}
