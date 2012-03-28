package pl.seam.hibernate.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import org.hibernate.validator.*;

import java.lang.annotation.*;

@ValidatorClass(AlphaValidator.class)
@Target( { METHOD, FIELD })
@Retention(RUNTIME)
@Documented
public @interface Alpha {
	
	boolean allowNumeric() default false;
	
	boolean allowSpace() default false;
	
	String message() default "invalid unicode letters";
}
