package org.itstep.vinokurov.web.action.workspace.tnla;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.logic.LogicException;

public class TnlaDelegateAction extends BaseTnlaAction{

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
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
		return null;
	}

}
