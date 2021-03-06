package org.itstep.vinokurov.web.action.workspace.tnla;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.domain.Tnla;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.TnlaService;
import org.itstep.vinokurov.web.action.Action;

public class TnlaSaveAction implements Action{
	private TnlaService tnlaService;
	
	public void setTnlaService(TnlaService tnlaService) {
		this.tnlaService = tnlaService;
	}

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		String id = req.getParameter("id");
		
		String code = req.getParameter("code");
		if(code == null || code.isBlank()) {
			throw new IllegalArgumentException();
		}
		
		String name = req.getParameter("name");
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException();
		}
		
		String dateStart = req.getParameter("dateStart");
		if(dateStart == null || dateStart.isBlank()) {
			throw new IllegalArgumentException();
		}
		
		String dateEnd = req.getParameter("dateEnd");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		try {
			startDate = dateFormat.parse(dateStart);
		} catch (ParseException e) {
			throw new IllegalArgumentException();
		}
		Date endDate = null;
		if(!dateEnd.isEmpty()) {
			try {
				endDate = dateFormat.parse(dateEnd);
			} catch (ParseException e) {
				throw new IllegalArgumentException();
			}
			if(startDate.compareTo(endDate) > 0) {
				throw new IllegalArgumentException();
			}
		}
		Tnla tnla = new Tnla();
		if(id != null) {
			tnla.setId(Long.parseLong(id));
		}
		tnla.setCode(code);
		tnla.setName(name);
		tnla.setDateStart(startDate);
		tnla.setDateEnd(endDate);
		
		try {
			tnlaService.save(tnla);
			return new Result("/workspace/tnla");
		} catch (LogicException e) {
			return null;
		}
	}
}
