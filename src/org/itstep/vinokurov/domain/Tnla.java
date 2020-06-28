package org.itstep.vinokurov.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tnla extends Entity {
	public static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	
	private String codTnla;
	private String nameTnla;
	private Date dateStartTnla;
	private Date dateEndTnla;
	private CableCategory category; 
		
	public CableCategory getCategory() {
		return category;
	}

	public void setCategory(CableCategory category) {
		this.category = category;
	}

	public String getCodTnla() {
		return codTnla;
	}

	public void setCodTnla(String codTnla) {
		this.codTnla = codTnla;
	}

	public String getNameTnla() {
		return nameTnla;
	}

	public void setNameTnla(String nameTnla) {
		this.nameTnla = nameTnla;
	}

	public Date getDateStartTnla() {
		return dateStartTnla;
	}

	public void setDateStartTnla(Date dateStartTnla) {
		this.dateStartTnla = dateStartTnla;
	}

	public Date getDateEndTnla() {
		return dateEndTnla;
	}

	public void setDateEndTnla(Date dateEndTnla) {
		this.dateEndTnla = dateEndTnla;
	}

	@Override
	public String toString() {
		return  codTnla + "| \"" + nameTnla 
				+ "\" | с " + FORMAT.format(dateStartTnla)
				+ " | по " + FORMAT.format(dateEndTnla)
				+ " " + category;
	}
}
