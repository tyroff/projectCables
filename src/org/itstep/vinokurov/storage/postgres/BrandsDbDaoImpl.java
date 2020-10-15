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

import org.itstep.vinokurov.domain.Brands;
import org.itstep.vinokurov.domain.CableCategory;
import org.itstep.vinokurov.storage.BrandsDao;
import org.itstep.vinokurov.storage.CableCategoryDao;
import org.itstep.vinokurov.storage.DaoException;

public class BrandsDbDaoImpl implements BrandsDao<Brands, Long> {
	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	private Map<Long, Brands> cache = new HashMap<>();

	@Override
	public Brands read(Long id) throws DaoException{
		String sqlRequest = "SELECT \"name\" FROM \"brands\" WHERE \"id\" = ?";
		Brands brand = cache.get(id);
		if(brand == null) {
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
				preparedStatement = connection.prepareStatement(sqlRequest);
				preparedStatement.setLong(1, id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					brand = new Brands();
					brand.setId(id);
					brand.setName(resultSet.getString("name"));
					cache.put(id, brand);
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
		return brand;
	}

	@Override
	public List<Brands> readAll() throws DaoException{
		String sqlRequest = "SELECT \"id\", \"name\" FROM \"brands\" ORDER BY \"name\"";
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlRequest);
			List<Brands> brands = new ArrayList<>();
			while(resultSet.next()) {
				Brands brand = new Brands();
				brand.setId(resultSet.getLong("id"));
				brand.setName(resultSet.getString("name"));
				brands.add(brand);
			}
			return brands;
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

	@Override
	public Long create(Brands brand) throws DaoException {
			String sqlRequest = "INSERT INTO \"brands\"(\"name\") VALUES (?)";
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
				preparedStatement = connection.prepareStatement(sqlRequest, PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, brand.getName());
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
	public void delete(Long... id) throws DaoException{
		String sqlRequest = "DELETE FROM \"brands\" WHERE \"id\" = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.setLong(1, id[0]);
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
	public void update(Brands brand) throws DaoException{
		String sqlRequest = "UPDATE \"brands\" SET \"name\" = ? WHERE \"id\" = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.setString(1, brand.getName());
			preparedStatement.setLong(2, brand.getId());
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
}