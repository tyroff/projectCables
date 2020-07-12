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

public class CableCategoryDelegateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if ("add".equals(action)) {
			req.getRequestDispatcher("add.html").forward(req, resp);
		} else if ("update".equals(action)) {
			req.getRequestDispatcher("update.html").forward(req, resp);
		} else if ("delete".equals(action)) {
			req.getRequestDispatcher("delete.html").forward(req, resp);
		} else {
			throw new IllegalArgumentException();
		}
	}
}
