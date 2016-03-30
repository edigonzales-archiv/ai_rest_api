package org.catais.ai.dao;

import java.util.List;

import org.catais.ai.model.Canton;

/**
 * This interface represents a contract for a DAO for the {@link Canton} model.
 * Note that all methods which returns the {@link Canton} from the DB, will not
 * fill the model with the password, due to security reasons.
 *
 * @author BalusC
 * @link http://balusc.blogspot.com/2008/07/dao-tutorial-data-layer.html
 */
public interface CantonDAO {
	
    // Actions ------------------------------------------------------------------------------------
	
    /**
     * Returns a list of all activated cantons from the database ordered by fosnr. 
     * The list is never null and is empty when the database does not contain any canton.
     * @return A list of all activated cantons from the database ordered by fosnr.
     * @throws DAOException If something fails at database level.
     */
	public List<Canton> listCantons();
		
    /**
     * Activate a canton in the database. The canton code must exist, otherwise it will throw
     * IllegalArgumentException.
     * @param canton The canton to activate.
     * @throws IllegalArgumentException If the canton code does not exist.
     * @throws DAOException If something fails at database level.
     */
	public void activateCanton(Canton canton);
	
    /**
     * Returns the requested canton from the database. The canton
     * has to be activated.
     * @param cantonCode The requested canton code.
     * @return The request canton.
     * @throws DAOException If something fails at database level.
     */
	public Canton listCanton(String cantonCode);
	
    /**
     * Updates the requested canton. Only few selected properties can be changed:
     *  - E-mail
     *  - ... 
  	 * The canton has to be activated and the canton code is mandatory.
     * @param canton The properties that has to be updated.
     * @throws DAOException If something fails at database level.
     */
	public void updateCanton(Canton canton);

    /**
     * Deletes the requested canton. A canton will be only deleted 
     * if there is no associated model to it. If you want to delete 
     * (= deactivate) a non empty canton, you have to use the 
     * recursive = true parameter.
     * @param cantonCode The requested canton code.
     * @param recursive Recursive deleting a canton.
     * @throws DAOException If something fails at database level.
     */
	public void deleteCanton(String cantonCode, boolean recursive);

	
}
