/**
 *
 */
package br.issgc.sac.persistence.entities;

import java.io.Serializable;

/**
 * Interface to any entity of the database.
 *
 * @author dinhego
 *
 */
interface DatabaseEntity extends Serializable {

	/**
	 *
	 * @return the unique identifier of a database entity
	 */
	Serializable getId();

}
