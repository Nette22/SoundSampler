package name.dericbourg.apps.mobile.soundsampler.core.exception;

/**
 * Developement exception. There should not be any of them on delivery.
 * 
 * @author alban
 */
public class NotImplementedException extends RuntimeException {

	private static final long serialVersionUID = 3469642257144592587L;

	/**
	 * Instanciante NotImplementedException.
	 */
	public NotImplementedException() {
		super();
	}

	/**
	 * Instanciante NotImplementedException with explanation message.
	 * 
	 * @param detailMessage Message.
	 */
	public NotImplementedException(final String detailMessage) {
		super(detailMessage);
	}

	/**
	 * Instanciante NotImplementedException with explanation message and from throwable.
	 * 
	 * @param detailMessage Message.
	 * @param throwable Throwable.
	 */
	public NotImplementedException(final String detailMessage, final Throwable throwable) {
		super(detailMessage, throwable);
	}

	/**
	 * Instanciante NotImplementedException from throwable.
	 * 
	 * @param throwable Throwable.
	 */
	public NotImplementedException(final Throwable throwable) {
		super(throwable);
	}
}
