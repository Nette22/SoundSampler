package name.dericbourg.apps.mobile.soundsampler.db;

import name.dericbourg.apps.mobile.soundsampler.model.Preset;
import name.dericbourg.apps.mobile.soundsampler.model.Sample;
import android.content.Context;
import android.database.Cursor;

/**
 * Service wrapper.
 * 
 * @author alban
 */
public class ServiceWrapper {

	private final PresetDao presetDao;
	private final SampleDao sampleDao;

	/**
	 * Constructor.
	 * 
	 * @param context Context.
	 */
	public ServiceWrapper(final Context context) {
		this.presetDao = new PresetDao(context);
		this.sampleDao = new SampleDao(context);
	}

	/**
	 * Save preset.
	 * 
	 * @param preset Preset.
	 * @return Preset id.
	 */
	public Long savePreset(final Preset preset) {
		return presetDao.save(preset);
	}

	/**
	 * Returns cursor on a specified preset.
	 * 
	 * @param preId Preset id.
	 * @return Cursor on preset.
	 */
	public Cursor getPreset(final Long preId) {
		return presetDao.get(preId);
	}

	/**
	 * Returns a cursor on all presets.
	 * 
	 * @return Cursor on all presets.
	 */
	public Cursor getAllPreset() {
		return presetDao.getAll();
	}

	/**
	 * Delete preset.
	 * 
	 * @param preId Preset id.
	 */
	public void deletePreset(final Long preId) {
		presetDao.delete(preId);
	}

	/**
	 * Save sample.
	 * 
	 * @param sample Sample.
	 * @return Sample id.
	 */
	public Long saveSample(final Sample sample) {
		return sampleDao.save(sample);
	}

	/**
	 * Returns cursor on a specified sample.
	 * 
	 * @param splId Sample id.
	 * @return Cursor on sample.
	 */
	public Cursor getSample(final Long splId) {
		return sampleDao.get(splId);
	}

	/**
	 * Returns a cursor on all samples from a specified preset.
	 * 
	 * @param preId Preset id.
	 * @return Cursor on all samples from a specified preset.
	 * @throws SystemException System exception.
	 */
	public Cursor getAllSampleFromPreset(final Long preId) {
		return sampleDao.getAllFromPreset(preId);
	}

	/**
	 * Delete sample.
	 * 
	 * @param splId Sample id.
	 */
	public void deleteSample(final Long splId) {
		sampleDao.delete(splId);
	}
}
