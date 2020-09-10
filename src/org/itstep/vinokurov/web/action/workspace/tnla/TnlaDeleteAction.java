package org.itstep.vinokurov.web.action.workspace.tnla;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.domain.Tnla;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.TnlaService;
import org.itstep.vinokurov.web.action.Action.Result;

public class TnlaDeleteAction extends BaseTnlaAction{
	private TnlaService tnlaService;
	
	public void setTnlaService(TnlaService tnlaService) {
		this.tnlaService = tnlaService;
	}

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		String id = req.getParameter("id");
		if(id != null) {
			Tnla tnla = tnlaService.findById(Long.parseLong(id));
			if(tnla == null) {
				throw new IllegalArgumentException();
			}
			req.setAttribute("tnla", tnla);
			return null;
		}
		return null;
	}
}
