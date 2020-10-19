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

import org.itstep.vinokurov.domain.NominalCrossSection;
import org.itstep.vinokurov.storage.DaoException;
import org.itstep.vinokurov.storage.NominalCrossSectionDao;

public class NominalCrossSectionDbDaoImpl implements NominalCrossSectionDao<NominalCrossSection, Long>{
	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	private Map<Long, NominalCrossSection> cache = new HashMap<>();
	
	@Override
	public NominalCrossSection read(Long... id) throws DaoException {
		String sqlRequest = "SELECT \"name\" FROM \"nominal_cross_section\" WHERE \"id\" = ?";
		NominalCrossSection entity = cache.get(id[0]);
		if(entity == null) {
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
				preparedStatement = connection.prepareStatement(sqlRequest);
				preparedStatement.setLong(1, id[0]);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					entity = new NominalCrossSection();
					entity.setId(id[0]);
					entity.setName(resultSet.getString("name"));
					cache.put(id[0], entity);
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
		return entity;
	}

	@Override
	public List<NominalCrossSection> readAll() throws DaoException {
		String sqlRequest = "SELECT \"id\", \"name\" FROM \"nominal_cross_section\" ORDER BY \"name\"";
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlRequest);
			List<NominalCrossSection> entityes = new ArrayList<>();
			while(resultSet.next()) {
				NominalCrossSection entity = new NominalCrossSection();
				entity.setId(resultSet.getLong("id"));
				entity.setName(resultSet.getString("name"));
				entityes.add(entity);
			}
			return entityes;
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
