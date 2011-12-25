package name.dericbourg.apps.mobile.soundsampler.core.exception;

/**
 * Developement exception. There should not be any of them on delivery.
 * 
 * @author alban
 * 
 */
public class NotImplementedException extends RuntimeException {

	private static final long serialVersionUID = 3469642257144592587L;

	public NotImplementedException() {
		super();
	}

	public NotImplementedException(String detailMessage) {
		super(detailMessage);
	}

	public NotImplementedException(Throwable throwable) {
		super(throwable);
	}

	public NotImplementedException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}
}
