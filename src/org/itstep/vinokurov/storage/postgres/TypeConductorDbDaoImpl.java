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

import org.itstep.vinokurov.domain.TypeConductor;
import org.itstep.vinokurov.storage.DaoException;
import org.itstep.vinokurov.storage.TypeConductorDao;

public class TypeConductorDbDaoImpl implements TypeConductorDao<TypeConductor, Long>{
	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	private Map<Long, TypeConductor> cache = new HashMap<>();
	
	@Override
	public TypeConductor read(Long... id) throws DaoException {
		String sqlRequest = "SELECT \"name\" FROM \"type_conductor\" WHERE \"id\" = ?";
		TypeConductor entity = cache.get(id[0]);
		if(entity == null) {
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
				preparedStatement = connection.prepareStatement(sqlRequest);
				preparedStatement.setLong(1, id[0]);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					entity = new TypeConductor();
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
	public List<TypeConductor> readAll() throws DaoException {
		String sqlRequest = "SELECT \"id\", \"name\" FROM \"type_conductor\" ORDER BY \"name\"";
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlRequest);
			List<TypeConductor> entityes = new ArrayList<>();
			while(resultSet.next()) {
				TypeConductor entity = new TypeConductor();
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
