package pl.seam.hibernate.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import org.hibernate.validator.*;


import java.lang.annotation.*;

@ValidatorClass(NIPValidator.class)
@Target( { METHOD, FIELD })
@Retention(RUNTIME)
@Documented
public @interface NIP {
	String message() default "invalid NIP value";
}
