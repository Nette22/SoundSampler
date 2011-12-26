package name.dericbourg.apps.mobile.soundsampler.model;


import com.j256.ormlite.field.DatabaseField;

/**
 * Application parameters.
 * 
 * @author alban
 */
public class Parameter extends AbstractObject<String> {

	@DatabaseField(id = true)
	private String prmCd;
	@DatabaseField
	private String label;
	@DatabaseField
	private String value;

	/**
	 * No parameter constructor.
	 */
	public Parameter() {
		super();
	}

	/**
	 * Object initializer constructor.
	 * 
	 * @param prmCd Parameter code.
	 * @param label Parameter label.
	 * @param value Parameter value.
	 */
	public Parameter(final String prmCd, final String label, final String value) {
		setPrmCd(prmCd);
		setLabel(label);
		setValue(value);
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
	 * Parameter code.
	 * 
	 * @return Code.
	 */
	public String getPrmCd() {
		return prmCd;
	}

	/**
	 * Parameter value.
	 * 
	 * @return Value.
	 */
	public String getValue() {
		return value;
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
	 * Set parameter code.
	 * 
	 * @param prmCd Parameter code.
	 */
	public void setPrmCd(final String prmCd) {
		this.prmCd = prmCd;
	}

	/**
	 * Set parameter value.
	 * 
	 * @param value Value.
	 */
	public void setValue(final String value) {
		this.value = value;
	}

	/** {@inheritDoc} */
	@Override
	public String getId() {
		return getPrmCd();
	}
}
