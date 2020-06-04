package org.itstep.vinokurov.ui;

import org.itstep.vinokurov.logic.LogicException;

public interface Command {
	//TODO add JavaDOC
	boolean execute(String[] args) throws LogicException;
}
