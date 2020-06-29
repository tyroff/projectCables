package org.itstep.vinokurov.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.Factory;
import org.itstep.vinokurov.domain.CableCategory;
import org.itstep.vinokurov.domain.Tnla;
import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.TnlaService;

public class TnlaAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(Factory factory = new Factory()){
			CableCategoryService service = factory.getCableCategoryService();
			List<CableCategory> cableCategores = service.findAll();
			req.setAttribute("cableCategores", cableCategores);
			req.getRequestDispatcher("/WEB-INF/jsp/workspace/tnla/add.jsp").forward(req, resp);
		} catch (LogicException e) {
			throw new ServletException(e); 
		}
	}
}
