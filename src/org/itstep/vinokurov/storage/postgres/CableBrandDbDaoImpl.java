package org.itstep.vinokurov.storage.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.itstep.vinokurov.domain.CableBrand;
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
		List<CableBrand> entutyes = new ArrayList<>();
		String sqlRequst = "SELECT \"id_brands\", \"id_number_of_conductors\", \"id_nominal_cross_section\", \"id_type_conductor\", \"id_rated_voltage\" FROM \"cable_brands\" WHERE \"id_technical_normative_legal_act\" = ? AND \"id_cable_category = ? AND \"type_product = ?\"\"";
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(sqlRequst);
			statement.setLong(1, id[0]);
			statement.setLong(1, id[1]);
			statement.setLong(1, id[2]);
			result = statement.executeQuery();
			while(result.next()) {
				CableBrand cableBrand = new CableBrand();
				cableBrand.setIdTnla(id[0]);
				cableBrand.setIdCableCategory(id[1]);
				cableBrand.setIdTypeProduct(id[2]);
				cableBrand.setIdBrand(result.getLong("id_brands"));
				cableBrand.setIdNumberСonductors(result.getLong("id_number_of_conductors"));
				cableBrand.setIdNominalCrossSection(result.getLong("id_nominal_cross_section"));
				cableBrand.setIdTypeConductor(result.getLong("id_type_conductor"));
				cableBrand.setIdRatedVoltage(result.getLong("id_rated_voltage"));
				entutyes.add(cableBrand);
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
		return entutyes;
	}

	@Override
	public void create(Long... id) throws DaoException {
		String sqlRequest = "INSERT INTO \"cable_brands\"(\"id_technical_normative_legal_act\", \"id_cable_category\", \"id_type_product\", \"id_brands\", \"id_number_of_conductors\", \"id_nominal_cross_section\", \"id_type_conductor\", \"id_rated_voltage\") VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
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
