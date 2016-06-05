package core.com.spring.test.exception;

import java.util.ResourceBundle;

/**
 * @author Nilton Fernando
 */
public abstract class BusinessException extends Exception {

	private static final long serialVersionUID = -3447125273328585747L;
	private static final ResourceBundle resource = ResourceBundle.getBundle("exceptions");

	public BusinessException(ExceptionMessages message) {
		super(resource.getString(message.getValue()));
	}

	public BusinessException(ExceptionMessages message,Throwable cause) {
		super(resource.getString(message.getValue()),cause);
	}
	
	public BusinessException(){
		
	}
}
