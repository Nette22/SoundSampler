package name.dericbourg.apps.mobile.soundsampler.db;

import name.dericbourg.apps.mobile.soundsampler.core.exception.Assertion;
import name.dericbourg.apps.mobile.soundsampler.core.exception.SystemException;
import name.dericbourg.apps.mobile.soundsampler.model.Preset;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class PresetDao extends AbstractCrudOperator<Preset, Long> {

	PresetDao(Context ctx) {
		super(ctx);
	}

	public Long save(Preset obj) throws SystemException {
		if (obj.getPreId() == null) {
			return insert(obj);
		} else {
			update(obj);
			return obj.getPreId();
		}
	}

	private Long insert(Preset obj) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(Preset.Fields.LABEL.name(), obj.getLabel());

		return getDb()
				.insert(Preset.Fields.getTableName(), null, initialValues);
	}

	private void update(Preset obj) throws SystemException {
		ContentValues args = new ContentValues();
		args.put(Preset.Fields.LABEL.name(), obj.getLabel());

		Assertion.invariant(getDb().update(Preset.Fields.getTableName(), args,
				Preset.Fields.PRE_ID.name() + "=" + obj.getPreId(), null) > 0);
	}

	public void delete(Long key) throws SystemException {
		if (key == null) {
			throw new SystemException();
		}
		Assertion.invariant(getDb().delete(Preset.Fields.getTableName(),
				Preset.Fields.PRE_ID + "=" + key.longValue(), null) > 0);
	}

	public Cursor get(Long key) throws SystemException {
		Cursor cursor = getAllByCriterion(Preset.Fields.PRE_ID.name() + "="
				+ key.longValue());
		if (cursor != null) {
			cursor.moveToFirst();
		}
		return cursor;
	}

	public Cursor getAll() {
		return getAllByCriterion(null);
	}

	private Cursor getAllByCriterion(String whereClause) {
		return getDb().query(true, Preset.Fields.getTableName(),
				Preset.Fields.toArray(), null, null, null, null, null, null);

	}
}
