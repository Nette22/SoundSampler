package name.dericbourg.apps.mobile.soundsampler;

import name.dericbourg.apps.mobile.soundsampler.db.ServiceWrapper;
import name.dericbourg.apps.mobile.soundsampler.model.Preset;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
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
		final int[] views = new int[] { R.id.presetRow };
		final SimpleCursorAdapter presets = new SimpleCursorAdapter(this, R.layout.sample_pad, presetCursor,
				displayedFields, views);
		setListAdapter(presets);
	}

	/** {@inheritDoc} */
	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		final MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.preset_list_menu, menu);
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		switch (item.getItemId()) {
			case R.id.new_preset:
				newPreset();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	private void newPreset() {
		final AlertDialog.Builder alert = new AlertDialog.Builder(this);
		alert.setTitle("New preset");
		alert.setMessage("Preset name: ");
		// Set an EditText view to get user input
		final EditText input = new EditText(this);
		alert.setView(input);
		alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

			public void onClick(final DialogInterface dialog, final int whichButton) {
				final String value = input.getText().toString();
				final Preset preset = new Preset();
				preset.setLabel(value);
				serviceWrapper.savePreset(preset);
				// TODO Refresh listview.
				return;
			}
		});
		alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

			public void onClick(final DialogInterface dialog, final int which) {
				return;
			}
		});
		alert.show();
	}
}
