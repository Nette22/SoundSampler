package name.dericbourg.apps.mobile.soundsampler.core.exception;

/**
 * Assertion for checks. TODO Add a way to disable assertions when deployed
 * (they should not fail outside dev env).
 * 
 * @author alban
 * 
 */
public class Assertion {
	public static void invariant(boolean condition) throws SystemException {
		if (!condition) {
			throw new SystemException();
		}
	}
}
