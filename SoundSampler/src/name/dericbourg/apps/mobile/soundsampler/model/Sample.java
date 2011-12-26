package name.dericbourg.apps.mobile.soundsampler.model;


import com.j256.ormlite.field.DatabaseField;

/**
 * Sample.
 * 
 * @author alban
 */
public class Sample extends AbstractObject<Long> {

	@DatabaseField(generatedId = true)
	private Long splId;
	@DatabaseField(foreign = true)
	private Long preId;
	@DatabaseField
	private String label;
	@DatabaseField
	private String fileUrl;

	/**
	 * No arg constructor.
	 */
	public Sample() {
		super();
	}

	/**
	 * Object initializer constructor.
	 * 
	 * @param splId Id.
	 * @param preId Preset id (FK).
	 * @param label Label.
	 * @param fileUrl File URL.
	 */
	public Sample(final Long splId, final Long preId, final String label, final String fileUrl) {
		setSplId(splId);
		setPreId(preId);
		setLabel(label);
		setFileUrl(fileUrl);
	}

	/**
	 * File URL.
	 * 
	 * @return URL.
	 */
	public String getFileUrl() {
		return fileUrl;
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
	 * Preset id (FK).
	 * 
	 * @return Preset id.
	 */
	public Long getPreId() {
		return preId;
	}

	/**
	 * Id.
	 * 
	 * @return Id.
	 */
	public Long getSplId() {
		return splId;
	}

	/**
	 * Set file URL.
	 * 
	 * @param fileUrl URL.
	 */
	public void setFileUrl(final String fileUrl) {
		this.fileUrl = fileUrl;
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
	 * Set preset id (FK).
	 * 
	 * @param preId Preset Id.
	 */
	public void setPreId(final Long preId) {
		this.preId = preId;
	}

	/**
	 * Set id.
	 * 
	 * @param splId Id.
	 */
	public void setSplId(final Long splId) {
		this.splId = splId;
	}

	/** {@inheritDoc} */
	@Override
	public Long getId() {
		return getSplId();
	}
}
