package com.dericbourg.apps.mobile.soundsampler.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Sound sample DB adapter.
 * 
 * @author adericbourg
 * 
 */
public class SampleDbAdapter {
	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAME = "name";
	public static final String KEY_PATH = "path";
	public static final String KEY_CONTENTTYPE = "contenttype";

	private static final String TAG = "SampleDbAdapter";
	private DatabaseHelper mDbHelper;
	private SQLiteDatabase mDb;

	/**
	 * Database creation sql statement.
	 */
	private static final String DATABASE_CREATE = "create table sample ( _id integer primary key autoincrement, name text not null, path text not null, contentype text not null);";

	private static final String DATABASE_NAME = "data";
	private static final String DATABASE_TABLE = "sample";
	private static final int DATABASE_VERSION = 0;

	private final Context mCtx;

	private static class DatabaseHelper extends SQLiteOpenHelper {

		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {

			db.execSQL(DATABASE_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS sample");
			onCreate(db);
		}

	}

	/**
	 * Constructor - takes the context to allow the database to be
	 * opened/created
	 * 
	 * @param ctx
	 *            the Context within which to work
	 */
	public SampleDbAdapter(Context ctx) {
		this.mCtx = ctx;
	}

	/**
	 * Open the sample database. If it cannot be opened, try to create a new
	 * instance of the database. If it cannot be created, throw an exception to
	 * signal the failure
	 * 
	 * @return this (self reference, allowing this to be chained in an
	 *         initialization call)
	 * @throws SQLException
	 *             if the database could be neither opened or created
	 */
	public SampleDbAdapter open() throws SQLException {
		mDbHelper = new DatabaseHelper(mCtx);
		mDb = mDbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		mDbHelper.close();
	}

	/**
	 * Create a new using name, path and content type provided.
	 * 
	 * @param name
	 *            Displayed name of sample.
	 * @param path
	 *            Path of file.
	 * @param contentType
	 *            Content-type.
	 * @return RowId or -1 if failed.
	 */
	public long createSample(String name, String path, String contentType) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_NAME, name);
		initialValues.put(KEY_PATH, path);
		initialValues.put(KEY_CONTENTTYPE, contentType);
		return mDb.insert(DATABASE_TABLE, null, initialValues);
	}

	/**
	 * Delete the sample with the given rowId
	 * 
	 * @param rowId
	 *            id of sample to delete
	 * @return true if deleted, false otherwise
	 */
	public boolean deleteSample(long rowId) {

		return mDb.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}

	/**
	 * Return a Cursor over the list of all samples in the database.
	 * 
	 * @return Cursor over all samples.
	 */
	public Cursor fetchAllSample() {

		return mDb.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_NAME,
				KEY_PATH, KEY_CONTENTTYPE }, null, null, null, null, null);
	}

	/**
	 * Return a Cursor positioned at the sample that matches the given rowId
	 * 
	 * @param rowId
	 *            id of sample to retrieve
	 * @return Cursor positioned to matching sample, if found
	 * @throws SQLException
	 *             if sample could not be found/retrieved
	 */
	public Cursor fetchSample(long rowId) throws SQLException {

		Cursor mCursor =

		mDb.query(true, DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ROWID,
				KEY_NAME, KEY_PATH, KEY_CONTENTTYPE }, KEY_ROWID + "=" + rowId,
				null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;

	}

	/**
	 * Update the sample using the details provided. The sample to be updated is
	 * specified using the rowId, and it is altered to use the name, path ant
	 * content-type passed.
	 * 
	 * @param rowId
	 *            Row Id.
	 * @param name
	 *            Name.
	 * @param path
	 *            Path.
	 * @param contenttype
	 *            Content-type.
	 * @return true if sample was successfully updated, false otherwise.
	 */
	public boolean updateNote(long rowId, String name, String path,
			String contenttype) {
		ContentValues args = new ContentValues();
		args.put(KEY_NAME, name);
		args.put(KEY_PATH, path);
		args.put(KEY_CONTENTTYPE, contenttype);

		return mDb.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
	}

}
