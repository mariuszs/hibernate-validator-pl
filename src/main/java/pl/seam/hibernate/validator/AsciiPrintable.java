package pl.seam.hibernate.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import org.hibernate.validator.*;

import java.lang.annotation.*;

@ValidatorClass(AsciiPrintableValidator.class)
@Target( { METHOD, FIELD })
@Retention(RUNTIME)
@Documented
public @interface AsciiPrintable {

	String message() default "invalid unicode letters";
}
