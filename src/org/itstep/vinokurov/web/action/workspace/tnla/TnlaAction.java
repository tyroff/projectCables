package org.itstep.vinokurov.web.action.workspace.tnla;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.domain.Tnla;
import org.itstep.vinokurov.logic.LogicException;

public class TnlaAction extends BaseTnlaAction{

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
			List<Tnla> tnlas = getTnlaService().findAll();
			req.setAttribute("tnlas", tnlas);
			return null;
	}
}
