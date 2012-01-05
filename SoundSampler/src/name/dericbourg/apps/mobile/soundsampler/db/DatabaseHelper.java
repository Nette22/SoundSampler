package name.dericbourg.apps.mobile.soundsampler.db;

import name.dericbourg.apps.mobile.soundsampler.ApplicationProperties;
import name.dericbourg.apps.mobile.soundsampler.exception.NotImplementedException;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Helper for database.
 * 
 * @author adericbourg
 */
final class DatabaseHelper extends SQLiteOpenHelper {

	private static DatabaseHelper instance;

	/**
	 * Create new instance.
	 * 
	 * @param context Context.
	 */
	private DatabaseHelper(final Context context) {
		super(context, ApplicationProperties.DATABASE_NAME.getStringValue(), null,
				ApplicationProperties.DATABASE_VERSION.getIntValue().intValue());
	}

	/**
	 * Get writable database access.
	 * 
	 * @param context Context.
	 * @return Writable database.
	 */
	public static SQLiteDatabase getRwDatabase(final Context context) {
		return get(context).getWritableDatabase();
	}

	/**
	 * Get read-only database access.
	 * 
	 * @param context Context.
	 * @return Read-only database access.
	 */
	public static SQLiteDatabase getRoDatabase(final Context context) {
		return get(context).getReadableDatabase();
	}

	/**
	 * Get.
	 * 
	 * @param context Context.
	 * @return Current instance.
	 */
	public static DatabaseHelper get(final Context context) {
		if (instance == null) {
			instance = new DatabaseHelper(context);
		}
		return instance;
	}

	@Override
	public void onCreate(final SQLiteDatabase db) {
		createTablePreset(db);
		createTableSample(db);
	}

	@Override
	public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
		throw new NotImplementedException();
	}

	private void createTablePreset(final SQLiteDatabase db) {
		if (tableExists(db, "PRESET")) {
			db.execSQL("drop table PRESET;");
		}
		final String query = "create table PRESET (PRE_ID integer primary key autoincrement, LABEL text not null);";
		db.execSQL(query);
	}

	private void createTableSample(final SQLiteDatabase db) {
		if (tableExists(db, "SAMPLE")) {
			db.execSQL("drop table SAMPLE;");
		}
		final String query = "create table SAMPLE (SPL_ID integer primary key autoincrement, LABEL text not null, PRE_ID integer not null, foreign key(PRE_ID) references PRESET(PRE_ID));";
		db.execSQL(query);
	}

	private boolean tableExists(final SQLiteDatabase db, final String tableName) {
		final Cursor cursor = db.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + tableName
				+ "'", null);
		if (cursor != null) {
			if (cursor.getCount() > 0) {
				return true;
			}
		}
		return false;
	}
}
