/**
 *
 */
package br.issgc.sac.persistence.tests.jdbc;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

/**
 * Loads the persistence definition for our database access
 *
 * @author dinhego
 *
 */
public class CheckConnection {

	/**
	 * just check if the database is up
	 */
	@Test
	public void throughPersistenceXML() {

		final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sac");

		assertTrue(entityManagerFactory != null);
	}
}
