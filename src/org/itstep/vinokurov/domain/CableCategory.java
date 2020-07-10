package org.itstep.vinokurov.domain;

public class CableCategory extends Entity {
	
	private String name;
		
<<<<<<< HEAD
	public String getNameCategory() {
=======
	public String getName() {
>>>>>>> f5e181a3bab71230e6edf059b6328d0d43015ff1
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return  getId() + ". " +  name;
	}
}
