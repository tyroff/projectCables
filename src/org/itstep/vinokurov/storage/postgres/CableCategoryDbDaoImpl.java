package org.itstep.vinokurov.storage.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.itstep.vinokurov.domain.CableCategory;
import org.itstep.vinokurov.domain.Tnla;
import org.itstep.vinokurov.storage.CableCategoryDao;
import org.itstep.vinokurov.storage.DaoException;
import org.itstep.vinokurov.storage.TnlaDao;

import com.sun.net.httpserver.Authenticator.Result;

public class CableCategoryDbDaoImpl implements CableCategoryDao {
	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	private Map<Long, CableCategory> cache = new HashMap<>();

	@Override
	public Long create(CableCategory cableCategory) throws DaoException {
		String sqlRequest = "INSERT INTO \"cable_category\"(\"name\") VALUES (?)";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sqlRequest, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, cableCategory.getName());
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			cache.clear();
			return resultSet.getLong(1);
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {}
			try {
				resultSet.close();
			} catch (Exception e) {}
		}
	}

	@Override
	public CableCategory read(Long id) throws DaoException {
		String sqlRequest = "SELECT \"name\" FORM \"cable_category\" WHERE \"id\" = ?";
		CableCategory cableCategory = cache.get(id);
		if(cableCategory == null) {
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
				preparedStatement = connection.prepareStatement(sqlRequest);
				preparedStatement.setLong(1, id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					cableCategory = new CableCategory();
					cableCategory.setId(id);
					cableCategory.setName(resultSet.getString("name"));
					cache.put(id, cableCategory);
				}
			} catch (SQLException e) {
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
		return cableCategory;
	}

	@Override
	public void update(CableCategory cableCategory) throws DaoException {
		String sqlRequest = "UPDATE \"cable_category\" SET \"name\" = ? WHERE \"id\" = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.setString(1, cableCategory.getName());
			preparedStatement.setLong(2, cableCategory.getId());
			preparedStatement.executeUpdate();
			cache.clear();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {}
		}
	}

	@Override
	public void delete(Long id) throws DaoException {
		String sqlRequest = "DELETE FORM \"cable_category\" WHERE \"id\" = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
			cache.clear();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {}
		}
	}

	@Override
	public List<CableCategory> read() throws DaoException {
		String sqlRequest = "SELECT \"id\", \"name\" FORM \"cable_category\"";
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlRequest);
			List<CableCategory> cableCategores = new ArrayList<>();
			while(resultSet.next()) {
				CableCategory cableCategory = new CableCategory();
				cableCategory.setId(resultSet.getLong("id"));
				cableCategory.setName(resultSet.getString("name"));
				cableCategores.add(cableCategory);
			}
			return cableCategores;
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {}
			try {
				statement.close();
			} catch (SQLException e) {}
		}
	}
}