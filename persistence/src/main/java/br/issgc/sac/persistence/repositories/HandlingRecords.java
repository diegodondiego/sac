/**
 *
 */
package br.issgc.sac.persistence.repositories;

import javax.persistence.EntityManager;

import br.issgc.sac.persistence.entities.Record;

/**
 * Repository for database access for {@link Record} entity.
 *
 * @author dinhego
 *
 */
public class HandlingRecords extends CommonDatabaseOprations<Record> {

	/**
	 * Constructor for tests
	 */
	public HandlingRecords(EntityManager entityManager) {

		this.entityManager = entityManager;
		this.relatedEntityClass = Record.class;
	}

	/**
	 * default constructor and setting of the related entity class for this repostiory
	 */
	public HandlingRecords() {
		this.relatedEntityClass = Record.class;
	}

}
