package org.itstep.vinokurov.ui;

import org.itstep.vinokurov.logic.LogicException;

public interface Command {
	boolean execute(String[] args) throws LogicException;
}
