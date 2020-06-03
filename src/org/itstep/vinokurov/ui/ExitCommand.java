package org.itstep.vinokurov.ui;

public class ExitCommand implements Command {

	@Override
	public boolean execute(String[] args) {
		System.out.println("Сеанс закончен.");
		return false;
	}
	

}
