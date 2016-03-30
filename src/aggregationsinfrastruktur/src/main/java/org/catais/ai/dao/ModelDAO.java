package org.catais.ai.dao;

import java.util.List;

import org.catais.ai.model.Model;

public interface ModelDAO {
	
    // Actions ------------------------------------------------------------------------------------
	
    /**
     * Returns a list of all models by a canton from the database. 
     * The list is never null and is empty when the database does not contain any model.
     * @param cantonCode The canton code.
     * @return A list of all models by a canton from the database.
     * @throws DAOException If something fails at database level.
     */
	public List<Model> listModels(String cantonCode);

}
