package name.dericbourg.apps.mobile.soundsampler.model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Preset.
 * 
 * @author alban
 */
@DatabaseTable(tableName = "PRESET")
public class Preset extends AbstractObject<Long> {

	@DatabaseField(generatedId = true)
	private Long preId;
	@DatabaseField
	private String label;

	/**
	 * Constructor.
	 */
	public Preset() {
		// No arg constructor needed by ORMLite.
	}

	/**
	 * Object initializer constructor.
	 * 
	 * @param preId Id.
	 * @param label Label.
	 */
	public Preset(final Long preId, final String label) {
		setPreId(preId);
		setLabel(label);
	}

	/**
	 * Label.
	 * 
	 * @return Label.
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Id.
	 * 
	 * @return Id.
	 */
	public Long getPreId() {
		return preId;
	}

	/**
	 * Set label.
	 * 
	 * @param label Label.
	 */
	public void setLabel(final String label) {
		this.label = label;
	}

	/**
	 * Set id.
	 * 
	 * @param preId Id.
	 */
	public void setPreId(final Long preId) {
		this.preId = preId;
	}

	/** {@inheritDoc} */
	@Override
	public Long getId() {
		return getPreId();
	}
}
