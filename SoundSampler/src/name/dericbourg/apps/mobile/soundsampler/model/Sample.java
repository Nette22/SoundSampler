package name.dericbourg.apps.mobile.soundsampler.model;

import java.util.ArrayList;
import java.util.List;

import name.dericbourg.apps.mobile.soundsampler.core.model.AbstractObject;
import name.dericbourg.apps.mobile.soundsampler.core.model.PrimaryKey;
import name.dericbourg.apps.mobile.soundsampler.core.persitence.Table;

/**
 * Sample.
 * 
 * @author alban
 * 
 */
public class Sample extends AbstractObject {
	/** Fields in database. */
	@Table("SAMPLE")
	public enum Fields {
		/** Database identifier. */
		SPL_ID,
		/** Foreign key to preset. */
		PRE_ID,
		/** Sample name. */
		LABEL,
		/** URL to file. */
		FILE_URL;

		public static String getTableName() {
			return "SAMPLE";
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
	private Long splId;
	private Long preId;
	private String label;
	private String fileUrl;

	public Long getSplId() {
		return splId;
	}

	public void setSplId(Long splId) {
		this.splId = splId;
	}

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

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
}
