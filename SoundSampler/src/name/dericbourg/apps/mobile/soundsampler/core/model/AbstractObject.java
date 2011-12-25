package name.dericbourg.apps.mobile.soundsampler.core.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import name.dericbourg.apps.mobile.soundsampler.core.exception.SystemException;

public abstract class AbstractObject {
	/**
	 * Returns object's primary key value.
	 * 
	 * @return Object's primary key value.
	 * @throws SystemException
	 *             System exception.
	 */
	public Object getPrimaryKeyValue() throws SystemException {
		Class<?> classInstance = this.getClass();
		List<Field> primaryKeys = new ArrayList<Field>();
		for (Field field : classInstance.getFields()) {
			PrimaryKey key = field.getAnnotation(PrimaryKey.class);
			if (key != null) {
				primaryKeys.add(field);
			}
		}

		// Should have only one primary key.
		if (primaryKeys.size() == 0) {
			throw new SystemException();
		} else if (primaryKeys.size() > 1) {
			throw new SystemException();
		}

		// Return value.
		try {
			return primaryKeys.get(0).get(this);
		} catch (IllegalArgumentException e) {
			throw new SystemException();
		} catch (IllegalAccessException e) {
			throw new SystemException();
		}
	}
}
