package name.dericbourg.apps.mobile.soundsampler;

import android.app.Activity;
import android.os.Bundle;

/**
 * Main activity.
 * 
 * @author adericbourg
 */
public class SoundSamplerActivity extends Activity {

	/**
	 * Called when the activity is first created.
	 * 
	 * @param savedInstanceState saves instance.
	 */
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
}
