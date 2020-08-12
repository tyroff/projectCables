package org.itstep.vinokurov.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.Factory;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.web.action.Action;
import org.itstep.vinokurov.web.action.Action.Result;
import org.itstep.vinokurov.web.action.Action.ResultType;

public class DispatcherServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		uri = uri.substring(req.getContextPath().length());
		if(uri.endsWith(".html")) {
			uri = uri.substring(0, uri.length() - ".html".length());
		}
		try(Factory factory = new Factory()) {
			Action action = factory.getAction(uri);
			Result result = null;
			if(action != null) {
				result = action.exec(req, resp);
			}
			if(result == null || result.getType() == ResultType.FORWARD) {
				if(result != null) {
					uri = result.getUrl();
				}
				req.getRequestDispatcher("/WEB-INF/jsp" + uri + ".jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + result.getUrl());
			}
		} catch(LogicException e) {
			throw new ServletException();
		}
	}
}
