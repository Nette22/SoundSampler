package name.dericbourg.apps.mobile.soundsampler.db;

import name.dericbourg.apps.mobile.soundsampler.exception.SystemException;
import name.dericbourg.apps.mobile.soundsampler.model.Preset;
import android.content.Context;
import android.database.Cursor;

public class ServiceWrapper {

	private final PresetDao presetDao;
	private final SampleDao sampleDao;

	public ServiceWrapper(final Context context) {
		this.presetDao = new PresetDao(context);
		this.sampleDao = new SampleDao(context);
	}

	public Long savePreset(final Preset preset) throws SystemException {
		return presetDao.save(preset);
	}

	public Cursor getPreset(final Long preId) {
		return presetDao.get(preId);
	}

	public Cursor getAllPreset() {
		return presetDao.getAll();
	}

	public void deletePreset(final Long preId) throws SystemException {
		presetDao.delete(preId);
	}
}
