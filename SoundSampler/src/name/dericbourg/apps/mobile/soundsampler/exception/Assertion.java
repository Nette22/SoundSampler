package name.dericbourg.apps.mobile.soundsampler.exception;

/**
 * Assertion for checks. TODO Add a way to disable assertions when deployed
 * (they should not fail outside dev env).
 * 
 * @author alban
 */
public final class Assertion {

	private Assertion() {
		// Utility class.
	}

	/**
	 * Check invariant condition.
	 * 
	 * @param condition Condition.
	 * @throws SystemException System exception when condition not verified.
	 */
	public static void invariant(final boolean condition) throws SystemException {
		if (!condition) {
			throw new SystemException();
		}
	}
}
