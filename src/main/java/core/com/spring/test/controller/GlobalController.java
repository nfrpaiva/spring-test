package core.com.spring.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Nilton Fernando
 */
@ControllerAdvice
public class GlobalController {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> defautExceptionHandler() {
		return new ResponseEntity<>("Erro",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
