package org.itstep.vinokurov.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.Factory;
import org.itstep.vinokurov.domain.Tnla;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.TnlaService;

public class TnlaSaveServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
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
			if(!dateEnd.isBlank()) {
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
			
			try(Factory factory = new Factory()){
				TnlaService service = factory.getTnlaService();
				service.save(tnla);
				resp.sendRedirect(req.getContextPath() + "/workspace/tnla.html");
			} catch (LogicException e) {
				throw new ServletException(e); 
			}
		} catch(IllegalArgumentException e) {
			throw new ServletException(e);
		}
	}
}