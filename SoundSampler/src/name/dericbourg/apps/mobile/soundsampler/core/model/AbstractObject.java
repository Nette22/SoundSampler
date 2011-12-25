package name.dericbourg.apps.mobile.soundsampler.core.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
		List<Method> primaryKeyAccessors = new ArrayList<Method>();
		for (Method method : classInstance.getMethods()) {
			PrimaryKeyAccessor key = method
					.getAnnotation(PrimaryKeyAccessor.class);
			if (key != null) {
				primaryKeyAccessors.add(method);
			}
		}

		// Should have only one primary key.
		if (primaryKeyAccessors.size() == 0) {
			throw new SystemException();
		} else if (primaryKeyAccessors.size() > 1) {
			throw new SystemException();
		}

		// Return value.
		try {
			return primaryKeyAccessors.get(0).invoke(this);
		} catch (InvocationTargetException e) {
			throw new SystemException();
		} catch (IllegalAccessException e) {
			throw new SystemException();
		}
	}
}
