package org.itstep.vinokurov.domain;

import java.util.Date;

public class TNLA extends Entity {
	public String codTNLA;
	public String nameTNLA;
	public Date dateStartTNLA;
	public Date dateEndTNLA;
		
	public String getCodTNLA() {
		return codTNLA;
	}
	public void setCodTNLA(String codTNLA) {
		this.codTNLA = codTNLA;
	}

	public String getNameTNLA() {
		return nameTNLA;
	}
	public void setNameTNLA(String nameTNLA) {
		this.nameTNLA = nameTNLA;
	}
	public Date getDateStartTNLA() {
		return dateStartTNLA;
	}
	public void setDateStartTNLA(Date dateStartTNLA) {
		this.dateStartTNLA = dateStartTNLA;
	}
	public Date getDateEndTNLA() {
		return dateEndTNLA;
	}
	public void setDateEndTNLA(Date dateEndTNLA) {
		this.dateEndTNLA = dateEndTNLA;
	}
	
	@Override
	public String toString() {
		return "TNLA [cod=" + codTNLA + ", name=" + nameTNLA + ", dateStart=" + dateStartTNLA
				+ ", dateEnd=" + dateEndTNLA + "]";
	}
}
