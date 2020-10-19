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

import org.itstep.vinokurov.domain.NumberOfConductor;
import org.itstep.vinokurov.storage.DaoException;
import org.itstep.vinokurov.storage.NumberOfConductorsDao;

public class NumberOfConductorDbDaoImpl implements NumberOfConductorsDao<NumberOfConductor, Long>{
	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	private Map<Long, NumberOfConductor> cache = new HashMap<>();
	
	@Override
	public NumberOfConductor read(Long... id) throws DaoException {
		String sqlRequest = "SELECT \"name\" FROM \"number_of_conductors\" WHERE \"id\" = ?";
		NumberOfConductor numberOfConductor = cache.get(id[0]);
		if(numberOfConductor == null) {
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
				preparedStatement = connection.prepareStatement(sqlRequest);
				preparedStatement.setLong(1, id[0]);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					numberOfConductor = new NumberOfConductor();
					numberOfConductor.setId(id[0]);
					numberOfConductor.setName(resultSet.getString("name"));
					cache.put(id[0], numberOfConductor);
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
		return numberOfConductor;
	}

	@Override
	public List<NumberOfConductor> readAll() throws DaoException {
		String sqlRequest = "SELECT \"id\", \"name\" FROM \"number_of_conductors\" ORDER BY \"name\"";
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlRequest);
			List<NumberOfConductor> numberOfConductores = new ArrayList<>();
			while(resultSet.next()) {
				NumberOfConductor numberOfConductor = new NumberOfConductor();
				numberOfConductor.setId(resultSet.getLong("id"));
				numberOfConductor.setName(resultSet.getString("name"));
				numberOfConductores.add(numberOfConductor);
			}
			return numberOfConductores;
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			try {
				resultSet.close();
			} catch (Exception e) {}
			try {
				statement.close();
			} catch (Exception e) {}
		}
	}
}
