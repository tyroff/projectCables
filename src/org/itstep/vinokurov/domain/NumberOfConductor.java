package org.itstep.vinokurov.domain;

public class NumberOfConductor extends Entity {
	
	private String value;
		
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return  getId() + ". " +  value;
	}
}
