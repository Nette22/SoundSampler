package name.dericbourg.apps.mobile.soundsampler;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Application properties accessor.
 * 
 * @author adericbourg
 */
public final class ApplicationPropertiesAccessor {

	private static final String BUNDLE_NAME = "name.dericbourg.apps.mobile.soundsampler.application";
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private ApplicationPropertiesAccessor() {
	}

	/**
	 * Reurns resource string value from key.
	 * 
	 * @param key Key.
	 * @return Value.
	 */
	static String getString(final String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (final MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
