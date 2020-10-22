package org.itstep.vinokurov.web.action.workspace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.domain.Brands;
import org.itstep.vinokurov.domain.CableBrand;
import org.itstep.vinokurov.logic.CableBrandService;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.TnlaService;
import org.itstep.vinokurov.web.action.Action;
import org.itstep.vinokurov.web.action.ActionException;
import org.itstep.vinokurov.web.action.Action.Result;

public class WorkspaceCableBrandsSaveAction implements Action{
	private CableBrandService<CableBrand, Long> cableBrandService;
	
	public void setCableBrandService(CableBrandService<CableBrand, Long> cableBrandService) {
		this.cableBrandService = cableBrandService;
	}

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		Long idNumberOfConductorFrom = Long.parseLong(req.getParameter("idNumberOfConductorFrom"));
		Long idNumberOfConductorBefore = Long.parseLong(req.getParameter("idNumberOfConductorBefore"));
		if(idNumberOfConductorFrom != null && idNumberOfConductorFrom != null && idNumberOfConductorFrom >= idNumberOfConductorFrom) {
			Long idNominalCrossSectionsFrom = Long.parseLong(req.getParameter("idNominalCrossSectionsFrom"));
			Long idNominalCrossSectionsBefore = Long.parseLong(req.getParameter("idNominalCrossSectionsBefore"));
			if(idNominalCrossSectionsFrom != null && idNominalCrossSectionsBefore != null && idNominalCrossSectionsBefore >= idNominalCrossSectionsFrom) {
				Long idTnla = Long.parseLong(req.getParameter("idTnla"));
				Long idCableCategory = Long.parseLong(req.getParameter("idCableCategory"));
				Long idTypeProduct = Long.parseLong(req.getParameter("idTypeProduct"));
				Long idBrand = Long.parseLong(req.getParameter("idBrand"));
				Long idTypeConductor = Long.parseLong(req.getParameter("idTypeConductor"));
				Long idRatedVoltage = Long.parseLong(req.getParameter("idRatedVoltage"));
				for(Long i = idNumberOfConductorFrom; i <= idNumberOfConductorBefore; i++) {
					for(Long j = idNominalCrossSectionsFrom; j <= idNominalCrossSectionsBefore; j++) {
						cableBrandService.saveByIdes(idTnla, idCableCategory, idTypeProduct, idBrand, i, j, idTypeConductor, idRatedVoltage);
					}
				}
			}
		}
		return new Result("/workspace");
	}
}
