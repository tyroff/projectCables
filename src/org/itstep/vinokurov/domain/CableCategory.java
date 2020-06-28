package org.itstep.vinokurov.domain;

public class CableCategory extends Entity {
	
	private String nameCategory;
		
	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	@Override
	public String toString() {
		return  getId() + ". " +  nameCategory;
	}
}
