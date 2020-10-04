package org.itstep.vinokurov.domain;

import java.util.Set;

public class TnlaAndCableCategory extends Entity{
	private Long idTnla;
	private Set<Long> idesOfCableCategory;
	
	public Long getIdTnla() {
		return idTnla;
	}
	
	public void setIdTnla(Long idTnla) {
		this.idTnla = idTnla;
	}
	
	public Set<Long> getIdesOfCableCategory() {
		return idesOfCableCategory;
	}
	
	public void setIdesOfCableCategory(Set<Long> idesCableCategory) {
		this.idesOfCableCategory = idesCableCategory;
	}

	@Override
	public String toString() {
		return "TnlaAndCableCategory [idTnla=" + idTnla + ", idesOfCableCategory=" + idesOfCableCategory + "]";
	}
}
