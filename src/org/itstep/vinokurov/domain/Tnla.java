package org.itstep.vinokurov.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tnla extends Entity {
	public static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	
	private String cod;
	private String name;
	private Date dateStart;
	private Date dateEnd;
	private CableCategory category; 
		
	public CableCategory getCategory() {
		return category;
	}

	public void setCategory(CableCategory category) {
		this.category = category;
	}

	public String getCodTnla() {
		return cod;
	}

	public void setCodTnla(String codTnla) {
		this.cod = codTnla;
	}

	public String getNameTnla() {
		return name;
	}

	public void setNameTnla(String nameTnla) {
		this.name = nameTnla;
	}

	public Date getDateStartTnla() {
		return dateStart;
	}

	public void setDateStartTnla(Date dateStartTnla) {
		this.dateStart = dateStartTnla;
	}

	public Date getDateEndTnla() {
		return dateEnd;
	}

	public void setDateEndTnla(Date dateEndTnla) {
		this.dateEnd = dateEndTnla;
	}

	@Override
	public String toString() {
		return  cod + "| \"" + name 
				+ "\" | с " + FORMAT.format(dateStart)
				+ " | по " + FORMAT.format(dateEnd)
				+ " " + category;
	}
}
