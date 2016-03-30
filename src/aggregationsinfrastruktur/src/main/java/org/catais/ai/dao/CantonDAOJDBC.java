package org.catais.ai.dao;

import static org.catais.ai.dao.DAOUtil.*;

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

	private static final String DB_TABLE = 
			"ai_rest_api.canton";
//	private static final String SQL_FIND_BY_ID =
//			"SELECT id, email, firstname, lastname, birthdate FROM User WHERE id = ?";
//	private static final String SQL_FIND_BY_EMAIL_AND_PASSWORD =
//			"SELECT id, email, firstname, lastname, birthdate FROM User WHERE email = ? AND password = MD5(?)";
	private static final String SQL_LIST_ALL_ORDER_BY_FOSNR =
			"SELECT ogc_fid, fosnr, code, aname, email, activated FROM " + DB_TABLE + " "
					+ "WHERE activated = true ORDER BY fosnr";
	private static final String SQL_LIST_SINGLE =
			"SELECT ogc_fid, fosnr, code, aname, email, activated FROM " + DB_TABLE + " "
					+ "WHERE activated = true AND code =  ?";	
	private static final String SQL_COUNT =
			"SELECT count(*) FROM " + DB_TABLE + " WHERE activated = TRUE";	
//	private static final String SQL_INSERT =
//			"INSERT INTO User (email, password, firstname, lastname, birthdate) VALUES (?, MD5(?), ?, ?, ?)";
	private static final String SQL_UPDATE_ACTIVATE =
			"UPDATE " + DB_TABLE + " SET activated = TRUE, email = ? WHERE code = ?";
	private static final String SQL_UPDATE_CANTON =
			"UPDATE " + DB_TABLE + " SET email = ? WHERE code = ? AND activated = TRUE";
	private static final String SQL_UPDATE_DEACTIVATE =
			"UPDATE " + DB_TABLE + " SET activated = FALSE WHERE code = ?";

//	private static final String SQL_DELETE =
//			"DELETE FROM User WHERE id = ?";
//	private static final String SQL_EXIST_EMAIL =
//			"SELECT id FROM User WHERE email = ?";
//	private static final String SQL_CHANGE_PASSWORD =
//			"UPDATE User SET password = MD5(?) WHERE id = ?";

	// Vars ---------------------------------------------------------------------------------------

	private DAOFactory daoFactory;

	// Constructors -------------------------------------------------------------------------------

	/**
	 * Construct an Canton DAO for the given DAOFactory. Package private so that it can be constructed
	 * inside the DAO package only.
	 * @param daoFactory The DAOFactory to construct this Canton DAO for.
	 */
	CantonDAOJDBC(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	// Actions ------------------------------------------------------------------------------------

	@Override
	public List<Canton> listCantons() {
		List<Canton> cantons = new ArrayList<>();

		try (
				Connection connection = daoFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL_LIST_ALL_ORDER_BY_FOSNR);
				ResultSet resultSet = statement.executeQuery();
			) 
		{
			while (resultSet.next()) {
				cantons.add(map(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return cantons;	
	}
	
	@Override
	public void activateCanton(Canton canton) {
		if (canton.getCode() == null) {
			throw new IllegalArgumentException("Canton is not activated yet, the canton code is null.");
		}

		Object[] values = {
				canton.getEmail(),
				canton.getCode()
		};
		
		try (
				Connection connection = daoFactory.getConnection();
        		PreparedStatement statement = prepareStatement(connection, SQL_UPDATE_ACTIVATE, false, values);
        	) 
        {
        	int affectedRows = statement.executeUpdate();
        	if (affectedRows == 0) {
        		throw new DAOException("Updating canton failed, no rows affected.");
        	}
        } catch (SQLException e) {
        	throw new DAOException(e);
        }
	}
	
	@Override
	public Canton listCanton(String cantonCode) {
		Canton canton = null;
		
		Object[] values = {
				cantonCode
		};
		
		try (
				Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, SQL_LIST_SINGLE, false, values);
				ResultSet resultSet = statement.executeQuery();
			) 
		{
			// Should return only one row.
			while (resultSet.next()) {
				canton = map(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return canton;
	}
	
	@Override
	public void updateCanton(Canton canton) {
		if (canton.getCode() == null) {
			throw new IllegalArgumentException("Canton property is mandatory. Canton cannot be updated.");
		}

		Object[] values = {
				canton.getEmail(),
				canton.getCode()
		};
		
		try (
				Connection connection = daoFactory.getConnection();
        		PreparedStatement statement = prepareStatement(connection, SQL_UPDATE_CANTON, false, values);
        	) 
        {
        	int affectedRows = statement.executeUpdate();
        	if (affectedRows == 0) {
        		throw new DAOException("Updating canton failed, no rows affected.");
        	}
        } catch (SQLException e) {
        	throw new DAOException(e);
        }
	}
	
	@Override
	public void deleteCanton(String cantonCode, boolean recursive) {
		// 1. Does canton exists (and is activated)?
		
		
		// 2. If recursive == false, does canton have corresponding models?
		
		
		// 3. Delete/deactivate canton.
		//    If recursive == true, delete all corresponding models.
		
		// At the moment just deactivate canton:
		if (cantonCode == null) {
			throw new IllegalArgumentException("The canton code is null.");
		}

		Object[] values = {
				cantonCode
		};
		
		try (
				Connection connection = daoFactory.getConnection();
        		PreparedStatement statement = prepareStatement(connection, SQL_UPDATE_DEACTIVATE, false, values);
        	) 
        {
        	int affectedRows = statement.executeUpdate();
        	if (affectedRows == 0) {
        		throw new DAOException("Updating canton failed, no rows affected.");
        	}
        } catch (SQLException e) {
        	throw new DAOException(e);
        }

	}


	// Helpers ------------------------------------------------------------------------------------

	/**
	 * Map the current row of the given ResultSet to a Canton.
	 * @param resultSet The ResultSet of which the current row is to be mapped to a Canton.
	 * @return The mapped Canton from the current row of the given ResultSet.
	 * @throws SQLException If something fails at database level.
	 */
	private static Canton map(ResultSet resultSet) throws SQLException {
		Canton canton = new Canton();
		canton.setId(resultSet.getInt("ogc_fid"));
		canton.setFosnr(resultSet.getInt("fosnr"));
		canton.setCode(resultSet.getString("code"));
		canton.setName(resultSet.getString("aname"));
		canton.setEmail(resultSet.getString("email"));
		//canton.setActivated(resultSet.getBoolean("activated"));
		return canton;
	}

}
