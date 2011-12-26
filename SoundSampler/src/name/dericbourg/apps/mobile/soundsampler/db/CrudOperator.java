package name.dericbourg.apps.mobile.soundsampler.db;

import java.util.Collection;

import name.dericbourg.apps.mobile.soundsampler.exception.SystemException;
import name.dericbourg.apps.mobile.soundsampler.model.AbstractObject;

/**
 * CRUD operator signature.
 * 
 * @author alban
 * @param <T>
 *            Object type handled.
 * @param <K>
 *            Primary key type.
 */
public interface CrudOperator<T extends AbstractObject<?>, K extends Object> {

	/**
	 * Delete object.
	 * 
	 * @param key Object identifier.
	 * @throws SystemException System exception.
	 */
	void delete(K key) throws SystemException;

	/**
	 * Get object.
	 * 
	 * @param key Object's identifier.
	 * @return Cursor on object.
	 * @throws SystemException System exception.
	 */
	T get(K key) throws SystemException;

	/**
	 * Get all objects.
	 * 
	 * @return Cursor on all objects.
	 * @throws SystemException System exception.
	 */
	Collection<T> getAll() throws SystemException;

	/**
	 * Save object.
	 * 
	 * @param obj Object.
	 * @return Database identifier.
	 * @throws SystemException System exception.
	 */
	K save(T obj) throws SystemException;
}
