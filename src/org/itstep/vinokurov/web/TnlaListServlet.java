package org.itstep.vinokurov.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.Factory;
import org.itstep.vinokurov.domain.Tnla;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.TnlaService;

public class TnlaListServlet extends HttpServlet{
	

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
