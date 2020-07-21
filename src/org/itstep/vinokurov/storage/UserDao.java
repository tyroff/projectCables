package org.itstep.vinokurov.storage;

import org.itstep.vinokurov.domain.User;

public interface UserDao extends Dao<User> {
	User read(String login, String password) throws DaoException;
}
