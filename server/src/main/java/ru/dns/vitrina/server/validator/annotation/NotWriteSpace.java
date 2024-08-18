package ru.dns.vitrina.server.validator.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ru.dns.vitrina.server.validator.NotWriteSpaceValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = NotWriteSpaceValidator.class)
public @interface NotWriteSpace {
    String message() default "не должно иметь пробелов";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
