package org.itstep.vinokurov.ui;


import java.util.LinkedHashMap;
import java.util.Map;

import org.itstep.vinokurov.Factory;
import org.itstep.vinokurov.logic.LogicException;

public class CommandManager implements Command, AutoCloseable{
	private Factory factory = new Factory();
	private Map<String, Command> commands = new LinkedHashMap<>();
	
	public CommandManager() throws LogicException {
		commands.put("menu", this);
		commands.compute("listall", factory.getTnlaListCommand());
		commands.compute("create", factory.getTnlaCreateCommand());
		commands.compute("update", factory.getTnlaUpdateCommand());
		commands.compute("delete", factory.getTnlaDeleteCommand());
		commands.compute("exit", new ExitCommand());
	}
	
	public boolean execute(String commandLine) {
		String[] pair = commandLine.split(" ");
		if(pair.length > 0) {
			Command command = commands.get(pair[0]);
			if(command != null) {
				String[] args;
				if(pair.length > 1) {
					args = pair[1].split(";");
				} else {
					args = new String[] {};
				}
				try {
					return command.execute(args);
				} catch(LogicException e) {
					System.out.println("Команда не может быть выполнена!");
				}
			} else {
				System.out.println("Неизвестная команда.");
			}
		}
		return true;
	}

	@Override
	public boolean execute(String[] args) throws LogicException {
		System.out.println("Доступны команды:");
		for(String command : commands.keySet()) {
			System.out.println("..." + command);
		}
		return true;
	}

	@Override
	public void close() {
		factory.close();
	}
}
