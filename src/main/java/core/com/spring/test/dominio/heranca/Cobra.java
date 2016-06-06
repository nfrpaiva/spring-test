package core.com.spring.test.dominio.heranca;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idAnimal",foreignKey=@ForeignKey(name="COBRA_ANIMAL_FK"))
public class Cobra extends Animal {
	private String veneno;

	public String getVeneno() {
		return veneno;
	}

	public void setVeneno(String veneno) {
		this.veneno = veneno;
	}


}
