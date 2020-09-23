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
import org.itstep.vinokurov.storage.DeleteDao;
import org.itstep.vinokurov.storage.ReadAllDao;
import org.itstep.vinokurov.storage.ReadDao;

public class TnlaAndCableCategoryDaoImpl implements DeleteDao<Short>, ReadDao<Set<Short>, Short>, ReadAllDao<TnlaAndCableCategory> {
	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void delete(Short... idTnla) throws DaoException {
		String sqlRequest = "DELETE FROM \"technical_normative_legal_act_vs_cable_category\" WHERE \"id_technical_normative_legal_act\" = ? AND \"id_cable_category\" = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.setShort(1, idTnla[0]);
			preparedStatement.setShort(2, idTnla[1]);
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
	public Set<Short> read(Short... idTnla) throws DaoException {
		Set<Short> idCableCategories = new HashSet<Short>();
		String sqlRequst = "SELECT \"id_cable_category\" FROM \"technical_normative_legal_act_vs_cable_category\" WHERE \"id_technical_normative_legal_act\" = ?";
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(sqlRequst);
			statement.setShort(1, idTnla[0]);
			result = statement.executeQuery();
			while(result.next()) {
				idCableCategories.add(result.getShort("id_cable_category"));
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
			TnlaAndCableCategory tnlaAndCableCategory = null;
			Short bufIdTnla = null;
			List<TnlaAndCableCategory> TnlaAndCableCategories = new ArrayList<>();
			Set<Short> idCableCategoies = new HashSet<>();
			while(result.next()) {
				Short idTnla = result.getShort("id_technical_normative_legal_act");
				if(idTnla == bufIdTnla) {
					idCableCategoies.add(result.getShort("id_cable_category"));
				} else if(tnlaAndCableCategory == null) {
					tnlaAndCableCategory = new TnlaAndCableCategory();
					tnlaAndCableCategory.setIdTnla(idTnla);
					bufIdTnla = idTnla;
					idCableCategoies.add(result.getShort("id_cable_category"));
				} else if(idTnla != bufIdTnla) {
					tnlaAndCableCategory.setIdesOfCableCategory(idCableCategoies);
					TnlaAndCableCategories.add(tnlaAndCableCategory);
					idCableCategoies.clear();
					idCableCategoies.add(result.getShort("id_cable_category"));
					tnlaAndCableCategory = new TnlaAndCableCategory();
					tnlaAndCableCategory.setIdTnla(idTnla);
					bufIdTnla = idTnla;
				} else {
					
				}
			}
			return TnlaAndCableCategories;
		} catch(SQLException e) {
			throw new DaoException(e);
		}
	}
}
