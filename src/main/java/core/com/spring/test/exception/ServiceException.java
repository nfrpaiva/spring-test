/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.exception;

import core.com.spring.test.Mensagens;
import java.util.ResourceBundle;

/**
 *
 * @author Nilton Fernando
 */
public class ServiceException extends Exception{
    private static final ResourceBundle resource =  ResourceBundle.getBundle("exceptions");
    
    public ServiceException(Mensagens message) {
        
        super(resource.getString(message.getValue()));
    }

    public ServiceException(Mensagens message, Throwable cause) {
        super(resource.getString(message.getValue()), cause);
    }
    
}
