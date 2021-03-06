package core.com.spring.test.dominio;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Nilton Fernando
 */
public class Person {
  @NotNull
  private String name;
  private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  
}
