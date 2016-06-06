package core.com.spring.test.dominio.heranca;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idAnimal",foreignKey=@ForeignKey(name="CACHORRO_ANIMAL_FK"))
public class Cachorro extends Animal {
	private String raca;

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}


}
