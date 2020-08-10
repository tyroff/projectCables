package org.itstep.vinokurov.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TnlaDelegateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if ("add".equals(action)) {
			req.getRequestDispatcher("add.html").forward(req, resp);
		} else if ("update".equals(action)) {
			req.getRequestDispatcher("update.html").forward(req, resp);
		} else if ("delete".equals(action)) {
			req.getRequestDispatcher("delete.html").forward(req, resp);
		} else if ("tables".equals(action)) {
		    // Submit button pressed.
		} else if ("categories".equals(action)) {
		    // Submit button pressed.
		} else {
			throw new IllegalArgumentException();
		}
	}
}
