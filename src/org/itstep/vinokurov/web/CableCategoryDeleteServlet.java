package org.itstep.vinokurov.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.util.Factory;
import org.itstep.vinokurov.domain.CableCategory;
import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.logic.LogicException;

public class CableCategoryDeleteServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if(id != null) {
			try(Factory factory = new Factory()) {
				CableCategoryService cableCategoryService = factory.getCableCategoryService();
				CableCategory cableCategory = cableCategoryService.findById(Long.parseLong(id));
				if(cableCategory == null || id == null) {
					throw new IllegalArgumentException();
				}
				req.setAttribute("cableCategory", cableCategory);
				req.getRequestDispatcher("/WEB-INF/jsp/workspace/cableCategory/delete.jsp").forward(req, resp);
			} catch(LogicException e) {
				throw new ServletException(e);
			} catch(IllegalArgumentException e) {
				resp.sendError(404);
			}
		} else {
			resp.sendError(404);
		}
	}
}
