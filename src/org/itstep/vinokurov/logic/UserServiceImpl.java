package org.itstep.vinokurov.logic;

import org.itstep.vinokurov.domain.User;
import org.itstep.vinokurov.storage.DaoException;
import org.itstep.vinokurov.storage.UserDao;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User authentication(String login, String password) throws LogicException {
		try {
			return userDao.read(login, password);
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}
}
