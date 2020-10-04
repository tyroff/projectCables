package org.itstep.vinokurov.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.util.Factory;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.web.action.Action;
import org.itstep.vinokurov.web.action.Action.Result;
import org.itstep.vinokurov.web.action.Action.ResultType;
import org.itstep.vinokurov.web.action.ActionException;

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
System.out.println("PROCESS URI " + uri);//TODO: it is need delete
		uri = uri.substring(req.getContextPath().length());
		if(uri.endsWith(".html")) {
			uri = uri.substring(0, uri.length() - ".html".length());
		}
System.out.println("PROCESSED URI " + uri);//TODO: it is need delete
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
				if(uri.equals("/")) {
					req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
				} else {
					req.getRequestDispatcher("/WEB-INF/jsp" + uri + ".jsp").forward(req, resp);
				}
			} else {
				uri = req.getContextPath() + result.getUrl() + ".html";
				String params = result.getParameters();
				if(!params.isEmpty()) {
					uri += "?" + params;
				}
System.out.println("REDIRECTED URI " + uri);//TODO: it is need delete
				resp.sendRedirect(uri);
			}
		} catch(ActionException e) {
			resp.sendError(e.getCode());
		} catch(LogicException e) {
			throw new ServletException(e);
		}
	}
}
