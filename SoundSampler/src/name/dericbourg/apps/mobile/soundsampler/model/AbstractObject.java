package name.dericbourg.apps.mobile.soundsampler.model;

/**
 * Abstract data object.
 * 
 * @param <K> Primary key type.
 * @author adericbourg
 */
public abstract class AbstractObject<K extends Object> {

	/**
	 * Get primary key value.
	 * 
	 * @return Value.
	 */
	public abstract K getId();
}
