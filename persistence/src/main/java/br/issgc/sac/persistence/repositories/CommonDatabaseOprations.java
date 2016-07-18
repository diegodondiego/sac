/**
 *
 */
package br.issgc.sac.persistence.repositories;

import static java.lang.String.format;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.issgc.sac.persistence.entities.DatabaseEntity;

/**
 * Common methods for the common operations to the repository access to the database
 *
 * @author dinhego
 *
 */
public abstract class CommonDatabaseOprations<T extends DatabaseEntity> implements Repositories<T> {

	/**
	 * database access
	 */
	@PersistenceContext(name = "sac")
	protected EntityManager entityManager;

	/**
	 * the entity that will be handled by the repository. just to help the common methods.
	 */
	protected Class<T> entityClass;

	/*
	 * (non-Javadoc)
	 *
	 * @see br.issgc.sac.persistence.repositories.Repositories#findASampleOfEntities(int)
	 */
	@Override
	public List<T> findASampleOfEntities(int maxNumberOfSamples) {

		final CriteriaQuery<T> sampleQuery = this.entityManager.getCriteriaBuilder().createQuery(this.entityClass);

		final Root<T> entityRoot = sampleQuery.from(this.entityClass);
		sampleQuery.select(entityRoot);

		return this.entityManager.createQuery(sampleQuery).setMaxResults(maxNumberOfSamples).getResultList();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see br.issgc.sac.persistence.repositories.Repositories#findById(java.io.Serializable)
	 */
	@Override
	public T findById(Serializable id) {
		if (id == null) {
			throw new IllegalArgumentException(format("Impossible to find a entity of type [%s] using an null id.", this.entityClass));
		}

		return this.entityManager.find(this.entityClass, id);
	}

	@Override
	public T saveOrUpdate(T entity) {

		if (entity == null) {
			throw new IllegalArgumentException("Cannot save or update a null entity!");
		}

		if (entity.getId() == null) {
			this.entityManager.persist(entity);
		}
		else {
			this.entityManager.merge(entity);
		}

		return entity;
	}

	@Override
	public void delete(T entity) {

		if (entity == null) {
			throw new IllegalArgumentException("Cannot delete entities based on a null entity!");
		}

		this.entityManager.remove(entity);
	}

}
