package name.dericbourg.apps.mobile.soundsampler.model;

import java.util.ArrayList;
import java.util.List;

import name.dericbourg.apps.mobile.soundsampler.core.model.AbstractObject;
import name.dericbourg.apps.mobile.soundsampler.core.model.PrimaryKey;
import name.dericbourg.apps.mobile.soundsampler.core.persitence.Table;

/**
 * Preset.
 * 
 * @author alban
 * 
 */

public class Preset extends AbstractObject {
	/** Object fields in database. */
	@Table("PRESET")
	public enum Fields {
		/** Identifier. */
		PRE_ID,
		/** Label. */
		LABEL;

		public static String getTableName() {
			return "PRESET";
		}

		public static String[] toArray() {
			List<String> fields = new ArrayList<String>();
			for (Fields field : Fields.values()) {
				fields.add(field.name());
			}
			return (String[]) fields.toArray();
		}
	}

	@PrimaryKey
	private Long preId;
	private String label;

	public Long getPreId() {
		return preId;
	}

	public void setPreId(Long preId) {
		this.preId = preId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
