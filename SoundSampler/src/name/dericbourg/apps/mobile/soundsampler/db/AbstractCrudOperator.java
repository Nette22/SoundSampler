package name.dericbourg.apps.mobile.soundsampler.db;

import java.sql.SQLException;
import java.util.Collection;

import name.dericbourg.apps.mobile.soundsampler.ApplicationProperties;
import name.dericbourg.apps.mobile.soundsampler.core.exception.SystemException;
import name.dericbourg.apps.mobile.soundsampler.core.model.AbstractObject;
import name.dericbourg.apps.mobile.soundsampler.core.persitence.CrudOperator;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;

/**
 * Abstract class for DAO.
 * 
 * @author adericbourg
 * @param <T> DAO handled type.
 * @param <K> Type of <T>'s primary key.
 */
abstract class AbstractCrudOperator<T extends AbstractObject<?>, K extends Object> extends OrmLiteSqliteOpenHelper
		implements CrudOperator<T, K> {

	/**
	 * Constructor.
	 * 
	 * @param context Context.
	 */
	AbstractCrudOperator(final Context context) {
		super(context, ApplicationProperties.DATABASE_NAME.getStringValue(), null,
				ApplicationProperties.DATABASE_VERSION.getIntValue());
	}

	/** {@inheritDoc} */
	public final void delete(final K key) throws SystemException {
		if (key == null) {
			throw new SystemException();
		}
		try {
			getDao().deleteById(key);
		} catch (final SQLException e) {
			throw new SystemException(e);
		}
	}

	/** {@inheritDoc} */
	public final T get(final K key) throws SystemException {
		if (key == null) {
			throw new SystemException();
		}
		try {
			if (!getDao().idExists(key)) {
				throw new SystemException("id");
			}
			return getDao().queryForId(key);
		} catch (final SQLException e) {
			throw new SystemException(e);
		}
	}

	/** {@inheritDoc} */
	public final K save(final T obj) throws SystemException {
		if (obj == null) {
			throw new SystemException("obj is null");
		}
		try {
			final K key = getDao().extractId(obj);
			if (key == null) {
				// New object.
				if (getDao().create(obj) != 1) {
					throw new SystemException("creation failed");
				}
			} else {
				// Update.
				if (!getDao().idExists(key)) {
					throw new SystemException("obj does not exist for that id");
				}
				getDao().update(obj);
			}
			return checkKey(obj.getId());
		} catch (final SQLException e) {
			throw new SystemException(e);
		}
	}

	/** {@inheritDoc} */
	public final Collection<T> getAll() throws SystemException {
		try {
			return getDao().queryForAll();
		} catch (final SQLException e) {
			throw new SystemException(e);
		}
	}

	/**
	 * Get DAO.
	 * 
	 * @return DAO.
	 * @throws SystemException System exception.
	 */
	protected abstract Dao<T, K> getDao() throws SystemException;

	/**
	 * Check key and returns types value.
	 * 
	 * @param key Raw key.
	 * @return Typed key.
	 */
	protected abstract K checkKey(Object key);

	@Override
	public final void onCreate(final SQLiteDatabase database, final ConnectionSource connectionSource) {
		DatabaseHelper.onCreate(database, connectionSource);
	}

	@Override
	public final void onUpgrade(final SQLiteDatabase database, final ConnectionSource connectionSource,
			final int oldVersion, final int newVersion) {
		DatabaseHelper.onUpgrade(database, connectionSource, oldVersion, newVersion);
	}
}
