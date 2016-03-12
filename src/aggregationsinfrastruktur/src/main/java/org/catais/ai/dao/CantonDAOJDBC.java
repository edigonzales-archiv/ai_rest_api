package org.catais.ai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.catais.ai.model.Canton;

/**
 * This class represents a concrete JDBC implementation of the {@link CantonDAO} interface.
 *
 * @author BalusC
 * @link http://balusc.blogspot.com/2008/07/dao-tutorial-data-layer.html
 */
public class CantonDAOJDBC implements CantonDAO {

	// Constants ----------------------------------------------------------------------------------

	private static final String SQL_FIND_BY_ID =
			"SELECT id, email, firstname, lastname, birthdate FROM User WHERE id = ?";
	private static final String SQL_FIND_BY_EMAIL_AND_PASSWORD =
			"SELECT id, email, firstname, lastname, birthdate FROM User WHERE email = ? AND password = MD5(?)";
	private static final String SQL_LIST_ORDER_BY_ID =
			"SELECT ogc_fid, fosnr, code, aname FROM ai_rest_api.canton ORDER BY fosnr";
	private static final String SQL_INSERT =
			"INSERT INTO User (email, password, firstname, lastname, birthdate) VALUES (?, MD5(?), ?, ?, ?)";
	private static final String SQL_UPDATE =
			"UPDATE User SET email = ?, firstname = ?, lastname = ?, birthdate = ? WHERE id = ?";
	private static final String SQL_DELETE =
			"DELETE FROM User WHERE id = ?";
	private static final String SQL_EXIST_EMAIL =
			"SELECT id FROM User WHERE email = ?";
	private static final String SQL_CHANGE_PASSWORD =
			"UPDATE User SET password = MD5(?) WHERE id = ?";

	// Vars ---------------------------------------------------------------------------------------

	private DAOFactory daoFactory;

	// Constructors -------------------------------------------------------------------------------

	/**
	 * Construct an User DAO for the given DAOFactory. Package private so that it can be constructed
	 * inside the DAO package only.
	 * @param daoFactory The DAOFactory to construct this User DAO for.
	 */
	CantonDAOJDBC(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	// Actions ------------------------------------------------------------------------------------

	@Override
	public List<Canton> list() {
		List<Canton> cantons = new ArrayList<>();

		try (
				Connection connection = daoFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL_LIST_ORDER_BY_ID);
				ResultSet resultSet = statement.executeQuery();
				) {
			while (resultSet.next()) {
				cantons.add(map(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return cantons;	
	}


	// Helpers ------------------------------------------------------------------------------------

	/**
	 * Map the current row of the given ResultSet to an Canton.
	 * @param resultSet The ResultSet of which the current row is to be mapped to an Canton.
	 * @return The mapped Canton from the current row of the given ResultSet.
	 * @throws SQLException If something fails at database level.
	 */
	private static Canton map(ResultSet resultSet) throws SQLException {
		Canton canton = new Canton();
		canton.setId(resultSet.getInt("ogc_fid"));
		canton.setFosnr(resultSet.getInt("fosnr"));
		canton.setCode(resultSet.getString("code"));
		canton.setName(resultSet.getString("aname"));
		return canton;
	}

}
