package org.itstep.vinokurov.web.action.workspace;

import org.itstep.vinokurov.domain.Brands;
import org.itstep.vinokurov.domain.NominalCrossSection;
import org.itstep.vinokurov.domain.NumberOfConductor;
import org.itstep.vinokurov.domain.RatedVoltage;
import org.itstep.vinokurov.domain.TypeConductor;
import org.itstep.vinokurov.logic.BrandsService;
import org.itstep.vinokurov.logic.CableCategoryService;
import org.itstep.vinokurov.logic.NominalCrossSectionService;
import org.itstep.vinokurov.logic.NumberOfConductorService;
import org.itstep.vinokurov.logic.RatedVoltageService;
import org.itstep.vinokurov.logic.TnlaService;
import org.itstep.vinokurov.logic.TypeConductorService;
import org.itstep.vinokurov.web.action.Action;

public abstract class BaseWorkspaceAction implements Action{
	private CableCategoryService cableCategoryService;
	private TnlaService tnlaService;
	private BrandsService<Brands, Long> brandsService;
	private NumberOfConductorService<NumberOfConductor, Long> numberOfConductorService;
	private NominalCrossSectionService<NominalCrossSection, Long> nominalCrossSectionService;
	private TypeConductorService<TypeConductor, Long> typeConductorService;
	private RatedVoltageService<RatedVoltage, Long> ratedVoltageService;

	protected CableCategoryService getCableCategoryService() {
		return cableCategoryService;
	}

	public void setCableCategoryService(CableCategoryService cableCategoryService) {
		this.cableCategoryService = cableCategoryService;
	}
	

	protected TnlaService getTnlaService() {
		return tnlaService;
	}

	public void setTnlaService(TnlaService tnlaService) {
		this.tnlaService = tnlaService;
	}
	
	protected BrandsService<Brands, Long> getBrandsService() {
		return brandsService;
	}

	public void setBrandsService(BrandsService<Brands, Long> brandsService) {
		this.brandsService = brandsService;
	}
	
	protected NumberOfConductorService<NumberOfConductor, Long> getNumberOfConductorService() {
		return numberOfConductorService;
	}

	public void setNumberOfConductorService(NumberOfConductorService<NumberOfConductor, Long> numberOfConductorService) {
		this.numberOfConductorService = numberOfConductorService;
	}
	
	protected NominalCrossSectionService<NominalCrossSection, Long> getNominalCrossSectionService() {
		return nominalCrossSectionService;
	}

	public void setNominalCrossSectionService(NominalCrossSectionService<NominalCrossSection, Long> nominalCrossSectionService) {
		this.nominalCrossSectionService = nominalCrossSectionService;
	}
	
	protected TypeConductorService<TypeConductor, Long> getTypeConductorService() {
		return typeConductorService;
	}

	public void setTypeConductorService(TypeConductorService<TypeConductor, Long> typeConductorService) {
		this.typeConductorService = typeConductorService;
	}
	
	protected RatedVoltageService<RatedVoltage, Long> getRatedVoltageService() {
		return ratedVoltageService;
	}

	public void setRatedVoltageService(RatedVoltageService<RatedVoltage, Long> ratedVoltageService) {
		this.ratedVoltageService = ratedVoltageService;
	}
}
