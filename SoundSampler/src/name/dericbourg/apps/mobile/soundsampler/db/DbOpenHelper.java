package name.dericbourg.apps.mobile.soundsampler.db;

import name.dericbourg.apps.mobile.soundsampler.ApplicationProperties;
import name.dericbourg.apps.mobile.soundsampler.core.exception.NotImplementedException;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

final class DbOpenHelper extends SQLiteOpenHelper {
	DbOpenHelper(Context context) {
		super(context, ApplicationProperties.DATABASE_NAME.getStringValue(),
				null, ApplicationProperties.DATABASE_VERSION.getIntValue());
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		throw new NotImplementedException("onCreate(SQLiteDatabase db)");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		throw new NotImplementedException(
				"onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)");

	}
}
