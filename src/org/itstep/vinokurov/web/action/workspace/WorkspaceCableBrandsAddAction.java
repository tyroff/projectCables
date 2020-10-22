package org.itstep.vinokurov.web.action.workspace;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.domain.Brands;
import org.itstep.vinokurov.domain.CableCategory;
import org.itstep.vinokurov.domain.NominalCrossSection;
import org.itstep.vinokurov.domain.NumberOfConductor;
import org.itstep.vinokurov.domain.RatedVoltage;
import org.itstep.vinokurov.domain.Tnla;
import org.itstep.vinokurov.domain.TypeConductor;
import org.itstep.vinokurov.domain.TypeProduct;
import org.itstep.vinokurov.logic.BrandsService;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.NominalCrossSectionService;
import org.itstep.vinokurov.logic.NumberOfConductorService;
import org.itstep.vinokurov.logic.RatedVoltageService;
import org.itstep.vinokurov.web.action.ActionException;

public class WorkspaceCableBrandsAddAction extends BaseWorkspaceAction{
	
	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		try {
			String idCableCategory = req.getParameter("idCableCategory");
			if(idCableCategory != null) {
				CableCategory cableCategory = getCableCategoryService().findById(Long.parseLong(idCableCategory));
				if(cableCategory == null) {
					throw new IllegalArgumentException();
				}
				req.setAttribute("cableCategory", cableCategory);
			}
			
			String idTnla = req.getParameter("idTnla");
			if(idTnla != null) {
				Tnla tnla = getTnlaService().findById(Long.parseLong(idTnla));
				if(tnla == null) {
					throw new IllegalArgumentException();
				}
				req.setAttribute("tnla", tnla);
			}

			List<TypeProduct> typeProducts = new ArrayList<>();
			for(TypeProduct typeProduct : TypeProduct.values()) {
				typeProducts.add(typeProduct);
			}
			req.setAttribute("typeProducts", typeProducts);
			
			List<Brands> brands = getBrandsService().findAll();
			req.setAttribute("brands", brands);
			
			List<NumberOfConductor> numberOfConductors = getNumberOfConductorService().findAll();
			req.setAttribute("numberOfConductors", numberOfConductors);
			
			List<NominalCrossSection> nominalCrossSections = getNominalCrossSectionService().findAll();
			req.setAttribute("nominalCrossSections", nominalCrossSections);
			
			List<TypeConductor> typeConductors = getTypeConductorService().findAll();
			req.setAttribute("typeConductors", typeConductors);
			
			List<RatedVoltage> ratedVoltages = getRatedVoltageService().findAll();
			req.setAttribute("ratedVoltages", ratedVoltages);
			
			return null;
		} catch(IllegalArgumentException e) {
			throw new ActionException(e, 404);
		}
	}
}
