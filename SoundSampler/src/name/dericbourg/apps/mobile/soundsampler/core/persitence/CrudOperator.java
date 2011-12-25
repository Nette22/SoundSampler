package name.dericbourg.apps.mobile.soundsampler.core.persitence;

import java.util.Collection;

import name.dericbourg.apps.mobile.soundsampler.core.exception.SystemException;
import name.dericbourg.apps.mobile.soundsampler.core.model.AbstractObject;

/**
 * CRUD operator signature.
 * 
 * @author alban
 * 
 * @param <T>
 *            Object type handled.
 * @param <K>
 *            Primary key type.
 */
public interface CrudOperator<T extends AbstractObject, K extends Object> {

	K save(T obj) throws SystemException;

	void delete(K key) throws SystemException;

	public T get(K key) throws SystemException;

	public Collection<T> getAll() throws SystemException;
}
