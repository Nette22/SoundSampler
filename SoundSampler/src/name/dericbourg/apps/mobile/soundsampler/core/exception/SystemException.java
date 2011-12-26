package name.dericbourg.apps.mobile.soundsampler.core.exception;

/**
 * System exception.
 * 
 * @author alban
 */
public class SystemException extends Exception {

	private static final long serialVersionUID = 5428776373583242733L;

	/**
	 * Instanciante SystemException.
	 */
	public SystemException() {
		super();
	}

	/**
	 * Instanciante SystemException with explanation message.
	 * 
	 * @param detailMessage Message.
	 */
	public SystemException(final String detailMessage) {
		super(detailMessage);
	}

	/**
	 * Instanciante SystemException with explanation message and from throwable.
	 * 
	 * @param detailMessage Message.
	 * @param throwable Throwable.
	 */
	public SystemException(final String detailMessage, final Throwable throwable) {
		super(detailMessage, throwable);
	}

	/**
	 * Instanciante SystemException from throwable.
	 * 
	 * @param throwable Throwable.
	 */
	public SystemException(final Throwable throwable) {
		super(throwable);
	}
}
