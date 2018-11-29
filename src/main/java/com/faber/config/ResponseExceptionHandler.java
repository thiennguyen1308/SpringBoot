package com.faber.config;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//</editor-fold>

/**
 *
 * @author Nguyen Duc Thien
 * @email nguyenducthien@fabercompany.co.jp
 */
@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(
            value = {IllegalArgumentException.class, IllegalStateException.class,
                     Exception.class, ArithmeticException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex,
                                                    WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(),
                                       HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
