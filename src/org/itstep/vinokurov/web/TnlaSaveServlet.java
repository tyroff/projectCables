package org.itstep.vinokurov.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		} catch (ParseException e2) {
			// TODO: нужно обработать ошибку преобразования даты?
			e2.printStackTrace();
		}
		Date endDate = null;
		try {
			endDate = dateFormat.parse(dateEnd);
		} catch (ParseException e2) {
			// TODO: нужно обработать ошибку преобразования даты?
			e2.printStackTrace();
		}
		if(startDate.compareTo(endDate) > 0) {
			throw new IllegalArgumentException();
		}
		
		Tnla tnla = new Tnla();
		tnla.setCod(code);
		tnla.setName(name);
		tnla.setDateStart(startDate);
		tnla.setDateEnd(endDate);
		
		while(req.getParameter("cableCategory") != null) {
			String cableCategory = req.getParameter("cableCategory");
			
		}
		try(Factory factory = new Factory()){
			TnlaService service = factory.getTnlaService();
			List<Tnla> tnlas = service.findAll();
			req.setAttribute("tnlas", tnlas);
			req.getRequestDispatcher("/WEB-INF/jsp/workspace/tnla/list.jsp").forward(req, resp);
		} catch (LogicException e) {
			throw new ServletException(e); 
		}
	}
}