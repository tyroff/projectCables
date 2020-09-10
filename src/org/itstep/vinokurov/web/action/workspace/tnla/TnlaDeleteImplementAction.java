package org.itstep.vinokurov.web.action.workspace.tnla;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.TnlaService;

public class TnlaDeleteImplementAction extends BaseTnlaAction{
	private TnlaService tnlaService;
	
	public void setTnlaService(TnlaService tnlaService) {
		this.tnlaService = tnlaService;
	}

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		String id = req.getParameter("id");
		if(id != null) {
			tnlaService.delete(Long.parseLong(id));
			return new Result("/workspace/tnla");
		}
		return null;
	}
}
