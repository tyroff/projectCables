package org.itstep.vinokurov.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.itstep.vinokurov.domain.Role;
import org.itstep.vinokurov.domain.User;
import org.itstep.vinokurov.logic.LogicException;

public class MainAction implements Action {

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		HttpSession session = req.getSession(false);
		if(session != null) {
			User user = (User)session.getAttribute("userSession");
			if(user != null) {
				switch(user.getRole()) {
					case ADMIN: return new Result("/workspace");
					case TECHNOLOGIST: return new Result("/workspace");
					default: throw new EnumConstantNotPresentException(Role.class, user.getRole().toString());
				}
			}
		}
		return null;
	}
}
