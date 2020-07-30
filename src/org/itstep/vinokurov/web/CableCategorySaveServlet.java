package org.itstep.vinokurov.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.Factory;
import org.itstep.vinokurov.domain.CableCategory;
import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.logic.LogicException;

public class CableCategorySaveServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("id");

			String name = req.getParameter("name");
			if(name == null || name.isEmpty()) {
				throw new IllegalArgumentException();
			}
			
			CableCategory cableCategory = new CableCategory();
			if(id != null) {
				cableCategory.setId(Long.parseLong(id));
			}
			cableCategory.setName(name);
			
			try(Factory factory = new Factory()){
				CableCategoryService cableCategoryService = factory.getCableCategoryService();
				cableCategoryService.save(cableCategory);
				resp.sendRedirect(req.getContextPath() + "/workspace/cableCategory.html");
			} catch (LogicException e) {
				throw new ServletException(e); 
			}
		} catch(IllegalArgumentException e) {
			throw new ServletException(e);
		}
	}
}