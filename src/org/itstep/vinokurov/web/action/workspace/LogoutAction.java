package org.itstep.vinokurov.web.action.workspace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.web.action.Action;

public class LogoutAction implements Action {

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		HttpSession session = req.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		return new Result("/index");
	}

}
