package org.itstep.vinokurov.logic;

import org.itstep.vinokurov.domain.User;

public interface UserService {
	User authentication(String login, String password) throws LogicException;
}
