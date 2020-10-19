package org.itstep.vinokurov.domain;

public class CableBrand{
	
	private Long idTnla;
	private Long idCableCategory;
	private Long idTypeProduct;
	private Long idBrand;
	private Long idNumberСonductors;
	private Long idNominalCrossSection;
	private Long idTypeConductor;
	private Long idRatedVoltage;
	
	public Long getIdTnla() {
		return idTnla;
	}
	public void setIdTnla(Long idTnla) {
		this.idTnla = idTnla;
	}
	public Long getIdCableCategory() {
		return idCableCategory;
	}
	public void setIdCableCategory(Long idCableCategory) {
		this.idCableCategory = idCableCategory;
	}
	public Long getIdTypeProduct() {
		return idTypeProduct;
	}
	public void setIdTypeProduct(Long idTypeProduct) {
		this.idTypeProduct = idTypeProduct;
	}
	public Long getIdBrand() {
		return idBrand;
	}
	public void setIdBrand(Long idBrand) {
		this.idBrand = idBrand;
	}
	public Long getIdNumberСonductors() {
		return idNumberСonductors;
	}
	public void setIdNumberСonductors(Long idNumberСonductors) {
		this.idNumberСonductors = idNumberСonductors;
	}
	public Long getIdNominalCrossSection() {
		return idNominalCrossSection;
	}
	public void setIdNominalCrossSection(Long idNominalCrossSection) {
		this.idNominalCrossSection = idNominalCrossSection;
	}
	public Long getIdTypeConductor() {
		return idTypeConductor;
	}
	public void setIdTypeConductor(Long idTypeConductor) {
		this.idTypeConductor = idTypeConductor;
	}
	public Long getIdRatedVoltage() {
		return idRatedVoltage;
	}
	public void setIdRatedVoltage(Long idRatedVoltage) {
		this.idRatedVoltage = idRatedVoltage;
	}
	@Override
	public String toString() {
		return "CableBrand [idTnla=" + idTnla + ", idCableCategory=" + idCableCategory + ", idTypeProduct="
				+ idTypeProduct + ", idBrand=" + idBrand + ", idNumberСonductors=" + idNumberСonductors
				+ ", idNominalCrossSection=" + idNominalCrossSection + ", idTypeConductor=" + idTypeConductor
				+ ", idRatedVoltage=" + idRatedVoltage + "]";
	}
}
