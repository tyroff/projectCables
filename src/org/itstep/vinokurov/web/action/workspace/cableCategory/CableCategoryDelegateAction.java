package org.itstep.vinokurov.web.action.workspace.cableCategory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.web.action.Action;

public class CableCategoryDelegateAction implements Action{

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		String action = req.getParameter("action");
		if ("add".equals(action)) {
			return new Result("/workspace/cableCategory/add");
		} else if ("update".equals(action)) {
			return new Result("/workspace/cableCategory/update").add("id", req.getParameter("id"));
		} else if ("delete".equals(action)) {
			return new Result("/workspace/cableCategory/delete").add("id", req.getParameter("id"));
		} else {
			throw new IllegalArgumentException();
		}
	}
}
