package core.com.spring.test.exception;

import java.util.ResourceBundle;

/**
 *
 * @author Nilton Fernando
 */
public class ServiceException extends Exception{
    private static final long serialVersionUID = -3447125273328585747L;
	private static final ResourceBundle resource =  ResourceBundle.getBundle("exceptions");
    
    public ServiceException(ExceptionMessages message) {
        
        super(resource.getString(message.getValue()));
    }

    public ServiceException(ExceptionMessages message, Throwable cause) {
        super(resource.getString(message.getValue()), cause);
    }
    
}