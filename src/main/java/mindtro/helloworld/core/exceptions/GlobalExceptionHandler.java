package mindtro.helloworld.core.exceptions;

import mindtro.helloworld.core.utilities.ErrorResult;
import mindtro.helloworld.core.utilities.Result;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleValidationErrors(MethodArgumentNotValidException ex) {
        return new ErrorResult("Hata geldi fyi.");
    }
    @ExceptionHandler(MyException.class)
    public Result handleValidationErrors(MyException ex) {
        return new ErrorResult("Kendi exceptionundan hata geldi fyi.");
    }


}
