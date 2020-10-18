package org.itstep.vinokurov.domain;

public class CableBrand extends Entity {
	
	private Tnla tnla;
	private CableCategory cableCategory;
	private TypeProduct typeProduct;
	private Brands brand;
	private Byte numberСonductors;
	private String nominalCrossSection;
	private String typeConductor;
	private String ratedVoltage;

	public Tnla getTnla() {
		return tnla;
	}
	
	public void setTnla(Tnla tnla) {
		this.tnla = tnla;
	}
	
	public CableCategory getCableCategory() {
		return cableCategory;
	}
	
	public void setCableCategory(CableCategory cableCategory) {
		this.cableCategory = cableCategory;
	}

	public TypeProduct getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(TypeProduct typeProduct) {
		this.typeProduct = typeProduct;
	}

	public Brands getBrand() {
		return brand;
	}

	public void setBrand(Brands brand) {
		this.brand = brand;
	}

	public Byte getNumberСonductors() {
		return numberСonductors;
	}

	public void setNumberСonductors(Byte numberСonductors) {
		this.numberСonductors = numberСonductors;
	}

	public String getNominalCrossSection() {
		return nominalCrossSection;
	}

	public void setNominalCrossSection(String nominalCrossSection) {
		this.nominalCrossSection = nominalCrossSection;
	}

	public String getTypeConductor() {
		return typeConductor;
	}

	public void setTypeConductor(String typeConductor) {
		this.typeConductor = typeConductor;
	}

	public String getRatedVoltage() {
		return ratedVoltage;
	}

	public void setRatedVoltage(String ratedVoltage) {
		this.ratedVoltage = ratedVoltage;
	}

	@Override
	public String toString() {
		return typeProduct + " " + brand + " " + numberСonductors + "×" + nominalCrossSection + typeConductor
				+ " - " + ratedVoltage + " " + tnla + " / " + cableCategory;
	}



}
