package ru.dns.vitrina.server.error;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.dns.vitrina.server.exception.NotFoundException;
import ru.dns.vitrina.server.exception.ValidationException;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(final NotFoundException e) {
        log.warn(e.getMessage(), e);
        return new ErrorResponse(HttpStatus.NOT_FOUND, "Не найдена сущность", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidation(final ValidationException e) {
        log.warn(e.getMessage(), e);
        return new ErrorResponse(HttpStatus.BAD_REQUEST, "Ошибка валидации", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse handleConstraintValidationException(final ConstraintViolationException e) {
        log.warn(e.getMessage(), e);

        final List<Violation> violations = e.getConstraintViolations().stream()
                .map(violation -> new Violation(violation.getPropertyPath().toString(), violation.getMessage()))
                .toList();

        return new ValidationErrorResponse(HttpStatus.BAD_REQUEST, violations);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse handleMethodArgumentNotValid(final MethodArgumentNotValidException e) {
        log.warn(e.getMessage(), e);

        final List<Violation> violations = e.getBindingResult().getFieldErrors().stream()
                .map(error -> new Violation(error.getField(), error.getDefaultMessage()))
                .toList();

        return new ValidationErrorResponse(HttpStatus.BAD_REQUEST, violations);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleLikesNotFond(LayerInstantiationException e) {
        log.error(e.getMessage());
        return new ErrorResponse(HttpStatus.NOT_FOUND, "Рейтинг не найден", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleOther(final Throwable e) {
        log.warn(e.getMessage(), e);
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Неизвестная ошибка", e.getMessage());
    }
}