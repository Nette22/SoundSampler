package name.dericbourg.apps.mobile.soundsampler;

/**
 * Application properties.
 * 
 * @author adericbourg
 */
public enum ApplicationProperties {
	/** Database name. */
	DATABASE_NAME,
	/** Database version. */
	DATABASE_VERSION,
	/** Datasource. */
	DATASOURCE;

	/**
	 * Returns int parameter value.
	 * 
	 * @return Int value.
	 */
	public Integer getIntValue() {
		return Integer.valueOf(getStringValue());
	}

	/**
	 * Returns string value.
	 * 
	 * @return Value.
	 */
	public String getStringValue() {
		return ApplicationPropertiesAccessor.getString(this.name());
	}
}
