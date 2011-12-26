package name.dericbourg.apps.mobile.soundsampler.db;

import java.sql.SQLException;

import name.dericbourg.apps.mobile.soundsampler.exception.SystemException;
import name.dericbourg.apps.mobile.soundsampler.model.Preset;
import android.content.Context;

import com.j256.ormlite.dao.Dao;

/**
 * Preset data access object.
 * 
 * @author adericbourg
 */
final class PresetDao extends AbstractCrudOperator<Preset, Long> {

	/**
	 * Constructor.
	 * 
	 * @param context Context.
	 */
	PresetDao(final Context context) {
		super(context);
	}

	/** {@inheritDoc} */
	@Override
	protected Dao<Preset, Long> getDao() throws SystemException {
		try {
			return getDao(Preset.class);
		} catch (final SQLException e) {
			throw new SystemException(e);
		}
	}

	/** {@inheritDoc} */
	@Override
	protected Long checkKey(final Object key) {
		return Long.class.cast(key);
	}
}
