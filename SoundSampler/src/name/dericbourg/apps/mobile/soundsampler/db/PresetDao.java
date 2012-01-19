package name.dericbourg.apps.mobile.soundsampler.db;

import name.dericbourg.apps.mobile.soundsampler.model.Preset;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Preset data access object.
 * 
 * @author adericbourg
 */
final class PresetDao {

	private final Context context;

	/**
	 * Constructor.
	 * 
	 * @param context Context.
	 */
	PresetDao(final Context context) {
		this.context = context;
	}

	/**
	 * Save preset.
	 * 
	 * @param preset Preset.
	 * @return Preset id.
	 */
	public Long save(final Preset preset) {
		if (preset.getId() == null) {
			// Insert.
			return insert(preset);
		} else {
			// Update.
			if (update(preset)) {
				return preset.getId();
			}
			return null;
		}
	}

	private Long insert(final Preset preset) {
		final ContentValues initialValues = new ContentValues();
		initialValues.put("LABEL", preset.getLabel());
		return DatabaseHelper.getRwDatabase(context).insert("PRESET", null, initialValues);
	}

	private boolean update(final Preset preset) {
		final ContentValues args = new ContentValues();
		args.put("LABEL", preset.getLabel());
		return DatabaseHelper.getRwDatabase(context).update("PRESET", args,
				"PRE_ID" + "=" + preset.getId().longValue(), null) > 0;
	}

	/**
	 * Delete preset.
	 * 
	 * @param preId Preset id.
	 */
	public void delete(final Long preId) {
		DatabaseHelper.getRwDatabase(context).delete("PRESET", "PRE_ID" + "=" + preId.longValue(), null);
	}

	/**
	 * Fetch all preset rows.
	 * 
	 * @return All presets.
	 */
	public Cursor getAll() {
		return DatabaseHelper.getRoDatabase(context).query("PRESET", new String[] { "PRE_ID _id", "LABEL" }, null,
				null, null, null, null);
	}

	/**
	 * Get specified preset.
	 * 
	 * @param preId Preset id.
	 * @return Preset.
	 */
	public Cursor get(final Long preId) {
		final Cursor cur = DatabaseHelper.getRoDatabase(context).query(true, "PRESET",
				new String[] { "PRE_ID _id", "LABEL" }, "PRE_ID" + "=" + preId.longValue(), null, null, null, null,
				null);
		if (cur != null) {
			cur.moveToFirst();
		}
		return cur;
	}
}
