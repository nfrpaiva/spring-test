/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Nilton Fernando
 */
@ControllerAdvice
public class GlobalController {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> defautExceptionHandler() {
        return new ResponseEntity<>("Erro", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
