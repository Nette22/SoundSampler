package name.dericbourg.apps.mobile.soundsampler;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ApplicationPropertiesAccessor {

	private static final String BUNDLE_NAME = "name.dericbourg.apps.mobile.soundsampler.application";

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private ApplicationPropertiesAccessor() {
	}

	static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
