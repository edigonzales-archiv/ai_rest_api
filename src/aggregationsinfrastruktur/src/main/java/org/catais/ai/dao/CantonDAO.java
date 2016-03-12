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
     * Returns a list of all activated cantons from the database ordered by fosnr. The list is never null and
     * is empty when the database does not contain any canton.
     * @return A list of all activated cantons from the database ordered by fosnr.
     * @throws DAOException If something fails at database level.
     */
	public List<Canton> listActivatedCantons();
}
