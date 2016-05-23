/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.exception;

import core.com.spring.test.ExceptionMessage;
import java.util.ResourceBundle;

/**
 *
 * @author fernando
 */
public class ServiceException extends Exception{
    private static final ResourceBundle resource =  ResourceBundle.getBundle("exceptions");
    
    public ServiceException(ExceptionMessage message) {
        
        super(resource.getString(message.getValue()));
    }

    public ServiceException(ExceptionMessage message, Throwable cause) {
        super(resource.getString(message.getValue()), cause);
    }
    
}
