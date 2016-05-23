/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.exception;

import java.util.ResourceBundle;

/**
 *
 * @author Nilton Fernando
 */
public class ServiceException extends Exception{
    private static final ResourceBundle resource =  ResourceBundle.getBundle("exceptions");
    
    public ServiceException(ExceptionMensagens message) {
        
        super(resource.getString(message.getValue()));
    }

    public ServiceException(ExceptionMensagens message, Throwable cause) {
        super(resource.getString(message.getValue()), cause);
    }
    
}
