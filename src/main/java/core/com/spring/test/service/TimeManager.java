package core.com.spring.test.service;

import java.util.Date;

import javax.inject.Named;

import org.joda.time.DateTime;

@Named
public class TimeManager {

	public Date now() {
		return DateTime.now().toDate();
	}

}
