package name.dericbourg.apps.mobile.soundsampler.db;

import name.dericbourg.apps.mobile.soundsampler.core.model.AbstractObject;
import name.dericbourg.apps.mobile.soundsampler.core.persitence.CrudOperator;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

abstract class AbstractCrudOperator<T extends AbstractObject, K extends Object>
		implements CrudOperator<T, K> {

	private final SQLiteDatabase db;

	AbstractCrudOperator(Context ctx) {
		DbOpenHelper openHelper = new DbOpenHelper(ctx);
		db = openHelper.getWritableDatabase();

	}

	protected final SQLiteDatabase getDb() {
		return db;
	}
}