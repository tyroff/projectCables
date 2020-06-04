package org.itstep.vinokurov.ui;

import java.text.ParseException;

import org.itstep.vinokurov.domain.Tnla;
import org.itstep.vinokurov.logic.LogicException;

public class TnlaSaveCommand extends TnlaCommand {

	@Override
	public boolean execute(String[] args) throws LogicException {
		if(args.length == 4 || args.length ==5) {
			try {
				Tnla tnla = new Tnla();
				int bias = 0;
				if(args.length ==6) {
					tnla.setId(Long.valueOf(args[0]));
					bias = 1;
				}
				try {
					tnla.setCodTnla(args[bias]);
					try {
						tnla.setNameTnla(args[1 + bias]);
						try {
							tnla.setDateStartTnla(Tnla.FORMAT.parse(args[2 + bias]));
							if(args[3 + bias] == null || args[3 + bias].equals("")) {
								tnla.setDateEndTnla(null);
							} else {
								tnla.setDateEndTnla(Tnla.FORMAT.parse(args[3 + bias]));
							}
						} catch(ParseException e) {
							System.out.println("Дата начала действия ТНПА " + args[2 + bias] + " должна соответствовать формату " + Tnla.FORMAT.toPattern());
						}
					} catch(NullPointerException e) {
						System.out.println("Поле \"Наименование\" не должно быть пустым.");	
					}
				} catch(NullPointerException e) {
					System.out.println("Поле \"Код\" не должно быть пустым.");
				}
			} catch(NumberFormatException e) {
				System.out.println("Идентификатор " + args[0] + " должен быть целым числом");
			}
		} else {
			System.out.println("Неверное количество аргументов.");
		}
		return true;
	}
}
