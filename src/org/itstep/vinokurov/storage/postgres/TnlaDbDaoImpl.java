package org.itstep.vinokurov.storage.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.itstep.vinokurov.domain.Tnla;
import org.itstep.vinokurov.storage.DaoException;
import org.itstep.vinokurov.storage.TnlaDao;

public class TnlaDbDaoImpl implements TnlaDao {
	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Long create(Tnla tnla) throws DaoException {
		String sqlRequest = "INSERT INTO \"technical_normative_legal_act\"(\"code\", \"name\", \"date_start\", \"date_end\") VALUES(?, ?, ?, ?)";
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, tnla.getCodTnla());
			statement.setString(2, tnla.getNameTnla());
			statement.setDate(3, new java.sql.Date(tnla.getDateStartTnla().getTime()));
			statement.setDate(4, new java.sql.Date(tnla.getDateEndTnla().getTime()));
			statement.executeUpdate();
			result = statement.getGeneratedKeys();
			result.next();
			return result.getLong(1);
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try {
				statement.close();
			} catch(Exception e) {}
			try {
				result.close();
			} catch(Exception e) {}
		}
	}

	@Override
	public Tnla read(Long id) throws DaoException {
		String sqlRequest = "SELECT \"code\", \"name\", \"date_start\", \"date_end\" FROM \"technical_normative_legal_act\" WHERE \"id\" = ?";
		PreparedStatement statement= null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(sqlRequest);
			statement.setLong(1, id);
			result = statement.executeQuery();
			Tnla tnla = null;
			if (result.next()) {
				tnla = new Tnla();
				tnla.setId(id);
				tnla.setCodTnla(result.getString("code"));
				tnla.setNameTnla(result.getString("name"));
				tnla.setDateEndTnla(new java.util.Date(result.getDate("date_start").getTime()));
				tnla.setDateStartTnla(new java.util.Date(result.getDate("date_end").getTime()));
			}
			return tnla;
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			try {
				result.close();
			} catch(Exception e) {}
			try {
				statement.close();
			} catch(Exception e) {}
		}
	}

	@Override
	public void update(Tnla tnla) throws DaoException {
		String sqlRequest = "UPDATE \"technical_normative_legal_act\" SET \"code\" = ?, \"name\" = ?, \"date_start\" = ?, \"date_end\" = ? WHERE \"id\" = ?";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlRequest);
			statement.setString(1, tnla.getCodTnla());
			statement.setString(2, tnla.getNameTnla());
			statement.setDate(3, new java.sql.Date(tnla.getDateStartTnla().getTime()));
			statement.setDate(4, new java.sql.Date(tnla.getDateEndTnla().getTime()));
			statement.setLong(5, tnla.getId());
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
	public List<Tnla> read() throws DaoException {
		String sqlRequest = "SELECT \"id\", \"code\", \"name\", \"date_start\", \"date_end\" FROM \"technical_normative_legal_act\"";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(sqlRequest);
			List<Tnla> tnlas = new ArrayList<>();
			while(result.next()) {
				Tnla tnla = new Tnla();
				tnla.setId(result.getLong("id"));
				tnla.setCodTnla(result.getString("code"));
				tnla.setNameTnla(result.getString("name"));
				tnla.setDateStartTnla(new java.util.Date(result.getDate("date_start").getTime()));
				tnla.setDateEndTnla(new java.util.Date(result.getDate("date_end").getTime()));
				tnlas.add(tnla);
			}
			return tnlas;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try {
				result.close();
			} catch(Exception e) {}
			try {
				statement.close();
			} catch(Exception e) {}
		}
	}
	
}
