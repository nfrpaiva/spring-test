package core.com.spring.test.dominio;

import static com.lordofthejars.bool.Bool.*;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;
import static org.hamcrest.Matchers.*;

/**
 * @author Nilton Fernando
 */
public class Automovel implements Validable {

    @NotNull
    private Integer anoFabricacao;
    @NotNull
    private Integer anoModelo;

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    @Override
    public boolean validate(ConstraintValidatorContext cvc) {
        boolean isValid;

        //Usando apenas Matchers
        if(nullValue().matches(anoFabricacao) || nullValue().matches(anoModelo)){
            return true;
        }
        
        //Usando a api Bool - com.lordofthejars - bool
        if(the(anoFabricacao,nullValue()) || the(anoModelo,nullValue())){
            return true;
        } 
        
        //Usando apenas Matchers
        isValid = greaterThan(anoFabricacao).matches(anoModelo);
        
        //Usando a api Bool - com.lordofthejars - bool
        isValid = the(anoModelo, greaterThan(anoFabricacao));
        
        cvc.buildConstraintViolationWithTemplate("{core.com.spring.test.constraint.anofabricacao}")
                .addPropertyNode("anoFabricacao")
                .addConstraintViolation();
        return isValid;

    }

}
