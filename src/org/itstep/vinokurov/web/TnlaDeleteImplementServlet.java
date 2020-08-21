package org.itstep.vinokurov.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.util.Factory;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.TnlaService;

public class TnlaDeleteImplementServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("id");
			try(Factory factory = new Factory()){
				TnlaService tnlaService = factory.getTnlaService();
				tnlaService.delete(Long.parseLong(id));
				resp.sendRedirect(req.getContextPath() + "/workspace/tnla.html");
			} catch (LogicException e) {
				throw new ServletException(e); 
			}
		} catch(IllegalArgumentException e) {
			throw new ServletException(e);
		}
	}
}