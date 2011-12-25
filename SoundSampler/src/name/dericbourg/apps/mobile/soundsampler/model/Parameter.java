package name.dericbourg.apps.mobile.soundsampler.model;

import java.util.ArrayList;
import java.util.List;

import name.dericbourg.apps.mobile.soundsampler.core.model.AbstractObject;
import name.dericbourg.apps.mobile.soundsampler.core.persitence.Table;

/**
 * Application parameters.
 * 
 * @author alban
 * 
 */
public class Parameter extends AbstractObject {
	/** Database fields. */
	@Table("PARAMETER")
	public enum Fields {
		/** Parameter code identifier. */
		PRM_CD,
		/** Parameter label. */
		LABEL,
		/** Parameter value. */
		VALUE;

		public static String getTableName() {
			return "PARAMETER";
		}

		public static String[] toArray() {
			List<String> fields = new ArrayList<String>();
			for (Fields field : Fields.values()) {
				fields.add(field.name());
			}
			return (String[]) fields.toArray();
		}
	}

	private String prmCd;
	private String label;
	private String value;

	public String getPrmCd() {
		return prmCd;
	}

	public void setPrmCd(String prmCd) {
		this.prmCd = prmCd;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
