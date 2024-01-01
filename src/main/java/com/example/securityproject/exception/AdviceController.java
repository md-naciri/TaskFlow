package com.example.securityproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Response<List<ErrorMessage>>> inputValidationException(MethodArgumentNotValidException ex) {
//        List<ErrorMessage> errorMessages = new ArrayList<>();
//        Response<List<ErrorMessage>> response = new Response<>();
//        ex.getBindingResult().getFieldErrors().forEach(error -> {
//            String errorMessage = error.getDefaultMessage();
//            String errorField = error.getField();
//            ErrorMessage errorMessageObj = ErrorMessage.builder()
//                    .field(errorField)
//                    .message(errorMessage).build();
//            errorMessages.add(errorMessageObj);
//        });
//        response.setMessage("Validation error");
//        response.setErrors(errorMessages);
//        return new ResponseEntity<>(
//                response,
//                HttpStatus.BAD_REQUEST
//        );
//    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> userNotFound(UsernameNotFoundException ex) {
        return new ResponseEntity<>(
                "User not found",
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> badCredentials(BadCredentialsException ex) {
        return new ResponseEntity<>(
                "Invalid email or password",
                HttpStatus.BAD_REQUEST
        );
    }
    @ExceptionHandler({
            AccessDeniedException.class,
            Exception.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> abstractBadRequest(Exception ex) {
        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST
        );
    }
}
