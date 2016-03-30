package org.catais.ai.dao;

import static org.catais.ai.dao.DAOUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.catais.ai.model.Canton;
import org.catais.ai.model.Model;


public class ModelDAOJDBC implements ModelDAO {
	
	// Constants ----------------------------------------------------------------------------------

	private static final String DB_TABLE = 
			"ai_rest_api.model";
	private static final String SQL_LIST_ALL_MODELS_BY_CANTON =
			"SELECT ogc_fid, canton, aname, schema_language, version, publishing_date, repository FROM " + DB_TABLE + " "
					+ "WHERE canton = ? ORDER BY aname";

	// Vars ---------------------------------------------------------------------------------------

	private DAOFactory daoFactory;

	// Constructors -------------------------------------------------------------------------------

	/**
	 * Construct an Model DAO for the given DAOFactory. Package private so that it can be constructed
	 * inside the DAO package only.
	 * @param daoFactory The DAOFactory to construct this Model DAO for.
	 */
	ModelDAOJDBC(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	// Actions ------------------------------------------------------------------------------------

	@Override
	public List<Model> listModels(String cantonCode) {
		
		Object[] values = {
				cantonCode
		};
		
		List<Model> models = new ArrayList<>();

		try (
				Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, SQL_LIST_ALL_MODELS_BY_CANTON, false, values);
				ResultSet resultSet = statement.executeQuery();
			) 
		{
			while (resultSet.next()) {
				models.add(map(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return models;	
	}

	// Helpers ------------------------------------------------------------------------------------

	/**
	 * Map the current row of the given ResultSet to a Model.
	 * @param resultSet The ResultSet of which the current row is to be mapped to a Model.
	 * @return The mapped Model from the current row of the given ResultSet.
	 * @throws SQLException If something fails at database level.
	 */
	private static Model map(ResultSet resultSet) throws SQLException {
		Model model = new Model();
		model.setId(resultSet.getInt("ogc_fid"));
		model.setName(resultSet.getString("aname"));
		model.setSchemaLanguage(resultSet.getString("schema_language"));
		model.setVersion(resultSet.getString("version"));
		model.setPublishingDate(resultSet.getDate("publishing_date"));
		model.setRepository(resultSet.getString("repository"));
		return model;
	}
}
