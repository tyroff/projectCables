package org.itstep.vinokurov.domain;

import java.util.Date;

public class Tnla extends Entity {
	public String codTnla;
	public String nameTnla;
	public Date dateStartTnla;
	public Date dateEndTnla;
		
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
		return "Tnla [cod=" + codTnla + ", name=" + nameTnla + ", dateStart=" + dateStartTnla
				+ ", dateEnd=" + dateEndTnla + "]";
	}
}
