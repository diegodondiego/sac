/**
 *
 */
package br.issgc.sac.persistence.tests.jdbc;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import br.issgc.sac.persistence.entities.Record;

/**
 * Loads the br.issgc.sac.persistence.entities definition for our database access
 *
 * @author dinhego
 *
 */
public class CheckConnection {

	protected static EntityManagerFactory entityManagerFactory;

	/**
	 * just check if the database is up
	 */
	@BeforeClass
	public static void throughPersistenceXML() {

		entityManagerFactory = Persistence.createEntityManagerFactory("sac");

		assertTrue(entityManagerFactory != null);
	}

	/**
	 * check if the table {@link Record} is created correctly.
	 */
	@Test
	public void checkTableCreation() {

		final EntityManager entityManager = CheckConnection.entityManagerFactory.createEntityManager();

		final List<Record> result = entityManager.createQuery("select r from Record r", Record.class).getResultList();

		// table exists!
		assertTrue(result != null && result.size() == 6);

	}

}
