package name.dericbourg.apps.mobile.soundsampler;

public enum ApplicationProperties {
	/** Database name. */
	DATABASE_NAME,
	/** Database version. */
	DATABASE_VERSION;

	public String getStringValue() {
		return ApplicationPropertiesAccessor.getString(this.name());
	}

	public Integer getIntValue() {
		return Integer.valueOf(getStringValue());
	}
}
