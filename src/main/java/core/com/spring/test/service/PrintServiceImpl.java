package core.com.spring.test.service;

import javax.inject.Named;

@Named
public class PrintServiceImpl implements PrintService {

	@Override
	public String printt(String value) {
		return value;
	}

}
