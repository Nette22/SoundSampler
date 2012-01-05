package name.dericbourg.apps.mobile.soundsampler;

import name.dericbourg.apps.mobile.soundsampler.db.ServiceWrapper;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

/**
 * Main activity.
 * 
 * @author alban
 */
public class SoundSamplerActivity extends ListActivity {

	private ServiceWrapper serviceWrapper;

	/**
	 * Called when the activity is first created.
	 * 
	 * @param savedInstanceState saves instance.
	 */
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// TODO If preset already selected (last opened), display sample pad, else display preset list.
		setContentView(R.layout.preset_list);
		serviceWrapper = new ServiceWrapper(this);
		fillData();
	}

	//
	private void fillData() {
		final Cursor presetCursor = serviceWrapper.getAllPreset();
		startManagingCursor(presetCursor);
		final String[] displayedFields = new String[] { "LABEL" };
		final int[] views = new int[] { R.id.textView };
		final SimpleCursorAdapter presets = new SimpleCursorAdapter(this, R.layout.sample_pad, presetCursor,
				displayedFields, views);
		setListAdapter(presets);
	}
}
