package org.itstep.vinokurov.web.action.workspace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.domain.Brands;
import org.itstep.vinokurov.domain.CableBrand;
import org.itstep.vinokurov.domain.CableCategory;
import org.itstep.vinokurov.domain.NominalCrossSection;
import org.itstep.vinokurov.domain.NumberOfConductor;
import org.itstep.vinokurov.domain.RatedVoltage;
import org.itstep.vinokurov.domain.Tnla;
import org.itstep.vinokurov.domain.TnlaAndCableCategory;
import org.itstep.vinokurov.domain.TypeConductor;
import org.itstep.vinokurov.domain.TypeProduct;
import org.itstep.vinokurov.logic.BrandsService;
import org.itstep.vinokurov.logic.CableBrandService;
import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.NominalCrossSectionService;
import org.itstep.vinokurov.logic.NumberOfConductorService;
import org.itstep.vinokurov.logic.RatedVoltageService;
import org.itstep.vinokurov.logic.TnlaAndCableCategoryService;
import org.itstep.vinokurov.logic.TnlaService;
import org.itstep.vinokurov.logic.TypeConductorService;
import org.itstep.vinokurov.web.action.Action;

public class WorkspaceAction implements Action{
	private TnlaService tnlaService;
	private CableCategoryService cableCategoryService;
	private TnlaAndCableCategoryService<TnlaAndCableCategory, Long> tnlaAndCableCategoryService;
	private CableBrandService<CableBrand, Long> cableBrandService;
	private BrandsService<Brands, Long> brandsService;
	private NumberOfConductorService<NumberOfConductor, Long> numberOfConductorService;
	private NominalCrossSectionService<NominalCrossSection, Long> nominalCrossSectionService;
	private TypeConductorService<TypeConductor, Long> typeConductorService;
	private RatedVoltageService<RatedVoltage, Long> ratedVoltageService;
	
	public void setTnlaService(TnlaService tnlaService) {
		this.tnlaService = tnlaService;
	}
	
	public void setCableCategoryService(CableCategoryService cableCategoryService) {
		this.cableCategoryService = cableCategoryService;
	}
	
	public void setTnlaAndCableCategoryService(TnlaAndCableCategoryService<TnlaAndCableCategory, Long> tnlaAndCableCategoryService) {
		this.tnlaAndCableCategoryService = tnlaAndCableCategoryService;
	}
	
	public void setCableBrandService(CableBrandService<CableBrand, Long> cableBrandService) {
		this.cableBrandService = cableBrandService;
	}
	
	public void setBrandsService(BrandsService<Brands, Long> brandsService) {
		this.brandsService = brandsService;
	}
	
	public void setNumberOfConductorService(NumberOfConductorService<NumberOfConductor, Long> numberOfConductorService) {
		this.numberOfConductorService = numberOfConductorService;
	}
	
	public void setNominalCrossSectionService(NominalCrossSectionService<NominalCrossSection, Long> nominalCrossSectionService) {
		this.nominalCrossSectionService = nominalCrossSectionService;
	}
	
	public void setTypeConductorService(TypeConductorService<TypeConductor, Long> typeConductorService) {
		this.typeConductorService = typeConductorService;
	}
	
	public void setRatedVoltageService(RatedVoltageService<RatedVoltage, Long> ratedVoltageService) {
		this.ratedVoltageService = ratedVoltageService;
	}
	
	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		Set<Long> idesCableCategory = null;
		Set<Tnla> tnlases = null;
		CableCategory cableCategory = null;
		List<CableBrand> cableBrands = null;
		List<String> textCableBrands = null;
		Map<Long, List<String>> brandsCategoryTnla = new HashMap<>();

		Map<CableCategory, Set<Tnla>> cableCategoryAndTnlas = new HashMap<>();
		List<TnlaAndCableCategory> tnlaAndCableCategories = tnlaAndCableCategoryService.findAll();
		for(TnlaAndCableCategory tnlaAndCableCategory : tnlaAndCableCategories) {
			Tnla tnla = tnlaService.findById(tnlaAndCableCategory.getIdTnla());
			idesCableCategory = tnlaAndCableCategory.getIdesOfCableCategory();
			if(!idesCableCategory.isEmpty()) {
				for(Long idCableCategory : idesCableCategory) {
					cableCategory = cableCategoryService.findById(idCableCategory);
					if(cableCategoryAndTnlas.get(cableCategory) == null) {
						tnlases = new HashSet<>();
						tnlases.add(tnla);
					} else {
						tnlases = cableCategoryAndTnlas.get(cableCategory);
						tnlases.add(tnla);
					}
					cableCategoryAndTnlas.put(cableCategory, tnlases);
					Long idTnla = tnla.getId();

					cableBrands = cableBrandService.findByIdes(idTnla, idCableCategory);
					
					if(cableBrands != null) {
							String typeProduc = null;
							String brand = null;
							String numberOfConductor = null;
							String nominalCrossSection = null;
							String typeConductor = null;
							String ratedVoltage = null;
							textCableBrands = new ArrayList<String>();
							
							for(CableBrand cableBrand : cableBrands) {
								for(TypeProduct typeProduct : TypeProduct.values()) {
								    if(typeProduct.ordinal() == cableBrand.getIdTypeProduct()) {
								    	typeProduc = typeProduct.name();
								    }
								}
								
								brand = brandsService.findById(cableBrand.getIdBrand()).getName();
								numberOfConductor = numberOfConductorService.findById(cableBrand.getIdNumberСonductors()).getValue();
								nominalCrossSection = nominalCrossSectionService.findById(cableBrand.getIdNominalCrossSection()).getValue();
								typeConductor = typeConductorService.findById(cableBrand.getIdTypeConductor()).getValue();
								ratedVoltage = ratedVoltageService.findById(cableBrand.getIdRatedVoltage()).getValue();
	
								textCableBrands.add(typeProduc + " " + brand + " " + numberOfConductor + "×" + nominalCrossSection + typeConductor + " - " + ratedVoltage);
							}
						Long key = idCableCategory * 1000000 + idTnla;
						brandsCategoryTnla.put(key, textCableBrands);
					}
				}
			}
		}
System.out.println("brandsCategoryTnla = " + brandsCategoryTnla);
		req.setAttribute("cableCategoryAndTnlas", cableCategoryAndTnlas);
		req.setAttribute("brandsCategoryTnla", brandsCategoryTnla);
		return null;
	}
}
