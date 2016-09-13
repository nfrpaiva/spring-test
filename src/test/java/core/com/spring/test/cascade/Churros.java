package core.com.spring.test.cascade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class Churros implements Serializable {

	private static final long serialVersionUID = 539594491383626777L;

	@Id
	@OneToOne
	private Cadu cadu;

	public Churros() {}

	public Churros(Cadu cadu) {
		this.cadu = cadu;
	}

	public Cadu getCadu() {
		return cadu;
	}

	public void setCadu(Cadu cadu) {
		this.cadu = cadu;
	}

}
