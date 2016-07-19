/**
 *
 */
package br.issgc.sac.persistence.tests.entites;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.issgc.sac.persistence.entities.Record;
import br.issgc.sac.persistence.repositories.HandlingRecords;
import br.issgc.sac.persistence.tests.jdbc.CheckConnection;

/**
 * Testing the access to the {@link Record}s using the repository.
 *
 * @author dinhego
 *
 */
public class FindingRecords extends CheckConnection {

	/**
	 * simple check for the repository creation
	 */
	@Test
	public void checkIfThereIsRecords() {

		final HandlingRecords handlingRecords = new HandlingRecords(entityManagerFactory.createEntityManager());

		// there should be a least 3 because of the import of data.
		final List<Record> sampleOfEntities = handlingRecords.findASampleOfEntities(3);

		assertTrue(sampleOfEntities != null && sampleOfEntities.size() == 3);

	}

	/**
	 * find a {@link Record} by id 1.
	 */
	@Test
	public void byId() {

		final HandlingRecords handlingRecords = new HandlingRecords(entityManagerFactory.createEntityManager());

		final Record foundById = handlingRecords.findById(1L);

		assertTrue(foundById != null);

	}

}
