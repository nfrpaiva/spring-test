package core.com.spring.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("security")
public class SecurityController {

	@RequestMapping
	public String hello () {
		return "Hello Security";
	}
	
}
