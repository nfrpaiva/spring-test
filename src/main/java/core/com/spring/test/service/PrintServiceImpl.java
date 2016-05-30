package core.com.spring.test.service;

import javax.inject.Named;

@Named
public class PrintServiceImpl implements PrintService {

	@Override
	public String imprimir(String value) {
		return value;
	}

}
