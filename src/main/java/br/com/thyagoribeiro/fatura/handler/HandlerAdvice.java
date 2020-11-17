package br.com.thyagoribeiro.fatura.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

// CDD - Total: 2

@RestControllerAdvice
public class HandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroPadronizado> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) { // CDD 1 - Classe ErroPadronizado

        Collection<String> mensagens = new ArrayList<>();
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(
                fieldError -> {
                    String message = String.format("Campo %s %s", fieldError.getField(), fieldError.getDefaultMessage());
                    mensagens.add(message);
                }
        ); // CDD 1 - Função de ordem superior

        ErroPadronizado erroPadronizado = new ErroPadronizado(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroPadronizado);

    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErroPadronizado> handleConstraintViolationException(ConstraintViolationException constraintViolationException) {

        Collection<String> mensagens = new ArrayList<>();
        for (ConstraintViolation<?> violation : constraintViolationException.getConstraintViolations()) {
            mensagens.add(violation.getPropertyPath() + " " + violation.getMessage());
        }

        ErroPadronizado erroPadronizado = new ErroPadronizado(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroPadronizado);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErroPadronizado> handleMissingServletRequestParameterException(MissingServletRequestParameterException missingServletRequestParameterException) {

        Collection<String> mensagens = new ArrayList<>();
        mensagens.add(missingServletRequestParameterException.getMessage());

        ErroPadronizado erroPadronizado = new ErroPadronizado(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroPadronizado);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErroPadronizado> handleResponseStatusException(ResponseStatusException responseStatusException) {

        Collection<String> mensagens = new ArrayList<>();
        mensagens.add(responseStatusException.getReason());

        ErroPadronizado erroPadronizado = new ErroPadronizado(mensagens);
        return ResponseEntity.status(responseStatusException.getStatus()).body(erroPadronizado);
    }

}
