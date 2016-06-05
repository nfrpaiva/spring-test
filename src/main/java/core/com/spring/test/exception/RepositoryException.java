package core.com.spring.test.exception;

public class RepositoryException extends BusinessException {

	public RepositoryException() {
		super();
	}

	public RepositoryException(ExceptionMessages message, Throwable cause) {
		super(message, cause);
	}

	public RepositoryException(ExceptionMessages message) {
		super(message);
	}

	private static final long serialVersionUID = -5949223705882943407L;

}
