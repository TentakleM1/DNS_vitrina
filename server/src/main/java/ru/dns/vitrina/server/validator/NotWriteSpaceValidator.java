package ru.dns.vitrina.server.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.dns.vitrina.server.validator.annotation.NotWriteSpace;

public class NotWriteSpaceValidator implements ConstraintValidator<NotWriteSpace, String> {
    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        return string == null || !string.contains(" ");
    }
}
