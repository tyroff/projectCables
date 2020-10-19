package org.itstep.vinokurov.domain;

public class RatedVoltage extends Entity {
	
	private String name;
		
	public String getName() {
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
