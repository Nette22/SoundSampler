package name.dericbourg.apps.mobile.soundsampler.db;

import name.dericbourg.apps.mobile.soundsampler.exception.NotImplementedException;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.support.ConnectionSource;

/**
 * Helper for database.
 * 
 * @author adericbourg
 */
final class DatabaseHelper {

	private DatabaseHelper() {
		// Utility class.
	}

	/**
	 * On create.
	 * 
	 * @param database Database.
	 * @param connectionSource Datasource.
	 */
	static void onCreate(final SQLiteDatabase database, final ConnectionSource connectionSource) {
		throw new NotImplementedException();
	}

	/**
	 * On upgrade.
	 * 
	 * @param database Database.
	 * @param connectionSource Datasource.
	 * @param oldVersion Old version.
	 * @param newVersion New version.
	 */
	static void onUpgrade(final SQLiteDatabase database, final ConnectionSource connectionSource, final int oldVersion,
			final int newVersion) {
		throw new NotImplementedException();
	}
}
