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

public class TnlaUpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(Factory factory = new Factory()) {
			String id = req.getParameter("id");
			if(id != null) {
				TnlaService tnlaService = factory.getTnlaService();
				Tnla tnla = tnlaService.findById(Long.parseLong(id));
				System.out.println(tnla);
				if(tnla == null) {
					throw new IllegalArgumentException();
				}
				req.setAttribute("tnla", tnla);
			}
			req.getRequestDispatcher("/WEB-INF/jsp/workspace/tnla/update.jsp").forward(req, resp);
		} catch(LogicException e) {
			throw new ServletException(e);
		} catch(IllegalArgumentException e) {
			resp.sendError(404);
		}
	}
}
