package org.itstep.vinokurov.ui;

import org.itstep.vinokurov.logic.LogicException;

public class TnlaDeleteCommand extends TnlaCommand {

	@Override
	public boolean execute(String[] args) throws LogicException {
		if(args.length == 1) {
			Long id = Long.valueOf(args[0]);
			getTnlaService().delete(id);
			System.out.println("ТНПА успешно удалён");
		} else {
			System.out.println("Неверное количество аргументов");
		}
		return true;
	}
}
