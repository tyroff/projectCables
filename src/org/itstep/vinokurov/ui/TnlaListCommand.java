package org.itstep.vinokurov.ui;

import java.util.List;

import org.itstep.vinokurov.domain.Tnla;
import org.itstep.vinokurov.logic.LogicException;


public class TnlaListCommand extends TnlaCommand {

	@Override
	public boolean execute(String[] args) throws LogicException {
		List<Tnla> tnlaList = getTnlaService().findAll();
		if(tnlaList.size() > 0) {
			for(int i = 0; i < tnlaList.size(); i++) {
				System.out.println(tnlaList.get(i));
			}
		} else {
			System.out.println("Список пуст.");
		}
		return true;
	}
}
