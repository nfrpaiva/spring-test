package core.com.spring.test.exception;

/**
 * @author Nilton Fernando
 */
public class ServiceException extends BusinessException {

	private static final long serialVersionUID = -3447125273328585747L;

	public ServiceException() {
		super();
	}

	public ServiceException(ExceptionMessages message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(ExceptionMessages message) {
		super(message);
	}


}
