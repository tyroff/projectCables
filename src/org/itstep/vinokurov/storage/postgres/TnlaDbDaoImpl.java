package org.itstep.vinokurov.storage.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		String sql = "INSERN INTO \"technical_normative_legal_act\"(\"code\", \"name\", \"date_start\", \"date_end\") VALUES(?, ?, ?, ?)";
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
		String sql = "SELECT \"code\", \"name\", \"date_start\", \"date_end\" FROM \"technical_normative_legal_act\" WHERE \"id\" = ?";
		PreparedStatement statement= null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(sql);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tnla> read() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
