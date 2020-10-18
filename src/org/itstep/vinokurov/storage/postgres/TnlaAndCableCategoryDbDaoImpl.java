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

import org.itstep.vinokurov.domain.TnlaAndCableCategory;
import org.itstep.vinokurov.storage.DaoException;
import org.itstep.vinokurov.storage.TnlaAndCableCategoryDao;

public class TnlaAndCableCategoryDbDaoImpl implements TnlaAndCableCategoryDao<TnlaAndCableCategory, Long>{
	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void delete(Long... id) throws DaoException {
		String sqlRequest = "DELETE FROM \"technical_normative_legal_act_vs_cable_category\" WHERE \"id_technical_normative_legal_act\" = ? AND \"id_cable_category\" = ?";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlRequest);
			statement.setLong(1, id[0]);
			statement.setLong(2, id[1]);
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
	public Set<Long> read(Long... id) throws DaoException {
		Set<Long> idCableCategories = new HashSet<>();
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
	public List<TnlaAndCableCategory> readAll() throws DaoException {
		String sqlRequest = "SELECT \"id_technical_normative_legal_act\", \"id_cable_category\" FROM \"technical_normative_legal_act_vs_cable_category\" ORDER BY \"id_technical_normative_legal_act\"";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(sqlRequest);
			Long bufIdTnla = null;
			TnlaAndCableCategory tnlaAndCableCategory = null;
			Set<Long> idesCableCategory = null;
			List<TnlaAndCableCategory> tnlaAndCableCategories = new ArrayList<>();
			while(result.next()) {
				Long idTnla = result.getLong("id_technical_normative_legal_act");
				if(idTnla != bufIdTnla || bufIdTnla == null) {
					bufIdTnla = idTnla;
					tnlaAndCableCategory = new TnlaAndCableCategory();
					idesCableCategory = new HashSet<>();
					idesCableCategory.add(result.getLong("id_cable_category"));
					tnlaAndCableCategory.setIdTnla(bufIdTnla);
					tnlaAndCableCategory.setIdesOfCableCategory(idesCableCategory);
					tnlaAndCableCategories.add(tnlaAndCableCategory);
				} else if(idTnla == bufIdTnla) {
					Set<Long> bufIdesCableCategory = tnlaAndCableCategory.getIdesOfCableCategory();
					bufIdesCableCategory.add(result.getLong("id_cable_category"));
					tnlaAndCableCategory.setIdesOfCableCategory(bufIdesCableCategory);
				}
			}
			return tnlaAndCableCategories;
		} catch(SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void create(Long... id) throws DaoException {
		String sqlRequest = "INSERT INTO \"technical_normative_legal_act_vs_cable_category\"(\"id_technical_normative_legal_act\", \"id_cable_category\") VALUES(?, ?)";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlRequest);
			statement.setLong(1, id[0]);
			statement.setLong(2, id[1]);
			statement.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {}
		}
	}
}
