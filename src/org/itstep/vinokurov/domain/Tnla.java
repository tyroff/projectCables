package org.itstep.vinokurov.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tnla extends Entity {
	public static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	
	private String code;
	private String name;
	private Date dateStart;
	private Date dateEnd;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	@Override
	public String toString() {
		return  code + "| \"" + name 
				+ "\" | с " + FORMAT.format(dateStart)
				+ " | по " + FORMAT.format(dateEnd);
	}
}
