package org.itstep.vinokurov.web.action.workspace.tnla;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.web.action.Action;

public class TnlaDelegateAction implements Action{

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		String action = req.getParameter("action");
		if ("add".equals(action)) {
			return new Result("/workspace/tnla/add");
		} else if ("update".equals(action)) {
			return new Result("/workspace/tnla/update").add("id", req.getParameter("id"));
		} else if ("delete".equals(action)) {
			return new Result("/workspace/tnla/delete").add("id", req.getParameter("id"));
		} else if ("tables".equals(action)) {
		    // Submit button pressed.
		} else if ("tnlaAndCableCategory".equals(action)) {
			return new Result("/workspace/tnla/tnlaAndCableCategory").add("id", req.getParameter("id"));
		} else {
			throw new IllegalArgumentException();
		}
		return new Result("/tnla");
	}
}
