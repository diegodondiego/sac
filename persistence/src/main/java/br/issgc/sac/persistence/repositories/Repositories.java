/**
 *
 */
package br.issgc.sac.persistence.repositories;

import java.io.Serializable;
import java.util.List;

import br.issgc.sac.persistence.entities.DatabaseEntity;

/**
 * Contains all the needed methods for a repository access to database entities
 *
 * @author dinhego
 *
 */
public interface Repositories<T extends DatabaseEntity> {

	/**
	 *
	 * @param id
	 *        the unique entity id
	 * @return the unique instance of the entity or <code>null</code> if an entity with this id doesn't exists
	 */
	T findById(Serializable id);

	/**
	 *
	 * @param maxNumberOfSamples
	 *        maximum number of entities in the return
	 * @return a list of <code>T</code> with the maximum size informed as parameter, without any order. an empty list if
	 *         there isn't entities for <code>T</code>
	 */
	List<T> findASampleOfEntities(int maxNumberOfSamples);

	/**
	 *
	 * @param entity
	 *        an detached object - if there is no value for <code>id</code> - for save to be updated - or if the
	 *        <code>id</code> field is setted.
	 * @return a non-detached object
	 */
	T saveOrUpdate(T entity);

	/**
	 *
	 * @param entity
	 *        pattern to be removed
	 */
	void delete(T entity);

}
