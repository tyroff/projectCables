package org.itstep.vinokurov.domain;

import java.util.Set;

public class TnlaAndCableCategory extends Entity{
	private Short idTnla;
	private Set<Short> idesOfCableCategory;
	
	public Short getIdTnla() {
		return idTnla;
	}
	
	public void setIdTnla(Short idTnla) {
		this.idTnla = idTnla;
	}
	
	public Set<Short> getIdesOfCableCategory() {
		return idesOfCableCategory;
	}
	
	public void setIdesOfCableCategory(Set<Short> idesCableCategory) {
		this.idesOfCableCategory = idesCableCategory;
	}

	@Override
	public String toString() {
		return "TnlaAndCableCategory [idTnla=" + idTnla + ", idesOfCableCategory=" + idesOfCableCategory + "]";
	}
}
