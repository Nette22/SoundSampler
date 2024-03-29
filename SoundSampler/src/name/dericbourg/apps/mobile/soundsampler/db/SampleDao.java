package name.dericbourg.apps.mobile.soundsampler.db;

import name.dericbourg.apps.mobile.soundsampler.model.Sample;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * DAO for sample.
 * 
 * @author adericbourg
 */
final class SampleDao {

	private final Context context;

	/**
	 * Constructor.
	 * 
	 * @param context Context.
	 */
	SampleDao(final Context context) {
		this.context = context;
	}

	/**
	 * Save Sample.
	 * 
	 * @param sample sample.
	 * @return Sample id.
	 */
	public Long save(final Sample sample) {
		if (sample.getId() == null) {
			// Insert.
			return insert(sample);
		} else {
			// Update.
			if (update(sample)) {
				return sample.getId();
			}
			return null;
		}
	}

	private Long insert(final Sample sample) {
		final ContentValues initialValues = new ContentValues();
		initialValues.put("PRE_ID", sample.getPreId());
		initialValues.put("LABEL", sample.getLabel());
		return DatabaseHelper.getRwDatabase(context).insert("Sample", null, initialValues);
	}

	private boolean update(final Sample sample) {
		final ContentValues args = new ContentValues();
		args.put("PRE_ID", sample.getPreId());
		args.put("LABEL", sample.getLabel());
		return DatabaseHelper.getRwDatabase(context).update("Sample", args,
				"SPL_ID" + "=" + sample.getId().longValue(), null) > 0;
	}

	/**
	 * Delete sample.
	 * 
	 * @param splId Sample id.
	 */
	public void delete(final Long splId) {
		DatabaseHelper.getRwDatabase(context).delete("Sample", "SPL_ID" + "=" + splId.longValue(), null);
	}

	/**
	 * Fetch all sample rows.
	 * 
	 * @param preId Preset id.
	 * @return All samples.
	 */
	public Cursor getAllFromPreset(final Long preId) {
		return DatabaseHelper.getRoDatabase(context).query("Sample", new String[] { "SPL_ID _id", "PRE_ID", "LABEL" },
				"PRE_ID = " + preId, null, null, null, null);
	}

	/**
	 * Get specified sample.
	 * 
	 * @param splId Sample id.
	 * @return Sample.
	 */
	public Cursor get(final Long splId) {
		final Cursor cur = DatabaseHelper.getRoDatabase(context).query(true, "Sample",
				new String[] { "SPL_ID _id", "PRE_ID", "LABEL" }, "SPL_ID" + "=" + splId.longValue(), null, null, null,
				null, null);
		if (cur != null) {
			cur.moveToFirst();
		}
		return cur;
	}
}
