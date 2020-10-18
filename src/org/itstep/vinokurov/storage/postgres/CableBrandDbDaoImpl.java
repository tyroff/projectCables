package org.itstep.vinokurov.storage.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.itstep.vinokurov.domain.CableBrand;
import org.itstep.vinokurov.domain.TnlaAndCableCategory;
import org.itstep.vinokurov.storage.CableBrandDao;
import org.itstep.vinokurov.storage.DaoException;

public class CableBrandDbDaoImpl implements CableBrandDao<CableBrand, Long> {
	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void delete(Long... id) throws DaoException {
		String sqlRequest = "DELETE FROM \"cable_brands\" WHERE \"id_technical_normative_legal_act\" = ? AND \"id_cable_category\" = ? AND \"type_product\" = ? AND \"id_brands\" = ? AND \"id_number_of_conductors\" BETWEEN = ? AND = ? AND \"id_nominal_cross_section\" BETWEEN = ? AND = ? AND \"id_type_conductor\" = ? AND \"id_rated_voltage\" = ?";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlRequest);
			statement.setLong(1, id[0]);
			statement.setLong(2, id[1]);
			statement.setLong(2, id[2]);
			statement.setLong(2, id[3]);
			statement.setLong(2, id[4]);
			statement.setLong(2, id[5]);
			statement.setLong(2, id[6]);
			statement.setLong(2, id[7]);
			statement.setLong(2, id[8]);
			statement.setLong(2, id[9]);
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
	public List<CableBrand> read(Long...id) throws DaoException {
		Set<Long> idCableCategories = new HashSet<>();
//TODO: created method read
		String sqlRequst = "SELECT \"id_cable_category\" FROM \"technical_normative_legal_act_vs_cable_category\" WHERE \"id_technical_normative_legal_act\" = ?";
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(sqlRequst);
			statement.setLong(1, id[0]);
			result = statement.executeQuery();
			while(result.next()) {
				idCableCategories.add(result.getLong("id_cable_category"));
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			try{
				result.close();
			} catch(Exception e) {}
			try {
				statement.close();
			} catch (Exception e) {}
		}
		return idCableCategories;
	}

	@Override
	public void create(Long... id) throws DaoException {
		// TODO Auto-generated method stub
		
	}


}
