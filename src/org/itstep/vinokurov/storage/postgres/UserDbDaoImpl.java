package org.itstep.vinokurov.storage.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.itstep.vinokurov.domain.Role;
import org.itstep.vinokurov.domain.User;
import org.itstep.vinokurov.storage.DaoException;
import org.itstep.vinokurov.storage.UserDao;

public class UserDbDaoImpl implements UserDao {
	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	private Map<Long, User> cache = new HashMap<>();

	@Override
	public Long create(User user) throws DaoException {
		String sqlRequest = "INSERT INTO \"user\"(\"login\", \"password\", \"role\") VALUES(?, ?, ?)";
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, user.getLogin());
			statement.setString(2, user.getPassword());
			statement.setInt(3, user.getRole().ordinal());
			statement.executeUpdate();
			result = statement.getGeneratedKeys();
			result.next();
			cache.clear();
			return result.getLong(1);
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try {
				statement.close();
			} catch(Exception e) {}
			try {
				result.close();
			} catch(Exception e) {}
		}
	}

	@Override
	public User read(Long id) throws DaoException {
		String sqlRequest = "SELECT \"login\", \"password\", \"role\" FROM \"user\" WHERE \"id\" = ?";
		User user = cache.get(id);
		PreparedStatement statement= null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(sqlRequest);
			statement.setLong(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				user = new User();
				user.setId(id);
				user.setLogin(result.getString("login"));
				user.setPassword(result.getString("password"));
				user.setRole(Role.values()[result.getInt("role")]);
				cache.put(id, user);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			try {
				result.close();
			} catch(Exception e) {}
			try {
				statement.close();
			} catch(Exception e) {}
		}
		return user;
	}

	@Override
	public void update(User user) throws DaoException {
		String sqlRequest = "UPDATE \"user\" SET \"login\" = ?, \"password\" = ?, \"role\" = ? WHERE \"id\" = ?";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlRequest);
			statement.setString(1, user.getLogin());
			statement.setString(2, user.getPassword());
			statement.setInt(3, user.getRole().ordinal());
			statement.setLong(4, user.getId());
			statement.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try {
				statement.close();
			} catch(Exception e) {}
		}
	}

	@Override
	public void delete(Long id) throws DaoException {
		String sqlRequest = "DELETE FROM \"user\" WHERE \"id\" = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try {
				preparedStatement.close();
			} catch(Exception e) {}
		}
	}

	@Override
	public User read(String login, String password) throws DaoException {
		String sqlRequest = "SELECT \"id\", \"role\" FROM \"user\" WHERE \"login\" = ? AND \"password\" = ?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			User user = null;
			if(resultSet.next()) {
				user = new User();
				user.setId(resultSet.getLong("id"));
				user.setLogin(login);
				user.setPassword(password);
				user.setRole(Role.values()[resultSet.getInt("role")]);
			}
			return user;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {}
			try {
				preparedStatement.close();
			} catch (SQLException e) {}
		}
	}
}
