package core.com.spring.test.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Nilton Fernando
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = AnoFabricaoModeloConstraint.class)
@Documented
public @interface AnoFabricacaoMaiorQueAnoModelo {

    String message() default "{core.com.spring.test.constraint.anofabricacao}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
