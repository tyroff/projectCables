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
	
	private Map<Long, CableCategory> mapCableCategory = new HashMap<>();

	@Override
	public Long create(CableCategory cableCategory) throws DaoException {
		String sqlRequest = "INSERT INTO \"cable_category\"(\"name\") VALUES (?)";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sqlRequest, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, cableCategory.getNameCategory());
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			mapCableCategory.clear();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CableCategory entity) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CableCategory> read() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}