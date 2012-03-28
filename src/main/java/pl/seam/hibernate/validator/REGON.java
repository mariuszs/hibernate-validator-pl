package pl.seam.hibernate.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import org.hibernate.validator.*;


import java.lang.annotation.*;

@ValidatorClass(REGONValidator.class)
@Target( { METHOD, FIELD })
@Retention(RUNTIME)
@Documented
public @interface REGON {

	boolean digitsOnly() default false;
	
	String message() default "invalid regon value";

}
