package org.itstep.vinokurov.domain;

import java.util.Set;

public class TnlaAndCableCategory{
	private Long idTnla;
	private Set<Long> idesCableCategory;
	
	public Long getIdTnla() {
		return idTnla;
	}
	
	public void setIdTnla(Long idTnla) {
		this.idTnla = idTnla;
	}
	
	public Set<Long> getIdesOfCableCategory() {
		return idesCableCategory;
	}
	
	public void setIdesOfCableCategory(Set<Long> idesCableCategory) {
		this.idesCableCategory = idesCableCategory;
	}

	@Override
	public String toString() {
		return "TnlaAndCableCategory [idTnla=" + idTnla + ", idesCableCategory=" + idesCableCategory + "]";
	}
}
