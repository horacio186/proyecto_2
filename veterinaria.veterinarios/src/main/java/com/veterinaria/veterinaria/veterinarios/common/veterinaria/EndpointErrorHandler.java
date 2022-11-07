package com.veterinaria.veterinaria.veterinarios.common.veterinaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@ControllerAdvice
public class EndpointErrorHandler {

  private static final String UNEXPECTED_ERROR = "Exception.unexpected";
  private final MessageSource messageSource;

  @Autowired
  public EndpointErrorHandler(MessageSource messageSource) {

    this.messageSource = messageSource;
  }

  @ExceptionHandler(VeterinariaNotFoundException.class)
  public ResponseEntity<ErrorInfo> handleRestaurantNotFoundException(HttpServletRequest request,
                                                                     VeterinariaNotFoundException ex, Locale locale) {
    ErrorInfo response = new ErrorInfo();
    response.setUrl(request.getRequestURL().toString());
    response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }
  @ExceptionHandler(DuplicateVeterinariaException.class)
  public ResponseEntity<ErrorInfo> handleDuplicateRestaurantException(HttpServletRequest request,
                                                                      DuplicateVeterinariaException ex, Locale locale) {
    ErrorInfo response = new ErrorInfo();
    response.setUrl(request.getRequestURL().toString());
    response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
    return new ResponseEntity<>(response, HttpStatus.IM_USED);
  }
  @ExceptionHandler(InvalidVeterinariaException.class)
  public ResponseEntity<ErrorInfo> handleInvalidRestaurantException(HttpServletRequest request,
                                                                    InvalidVeterinariaException ex, Locale locale) {
    ErrorInfo response = new ErrorInfo();
    response.setUrl(request.getRequestURL().toString());
    response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
    return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
  }

  // esta es la mas general de todas
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorInfo> handleException(Exception ex, Locale locale) {
    String errorMessage = messageSource.getMessage(UNEXPECTED_ERROR, null, locale);
    return new ResponseEntity<>(new ErrorInfo(errorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
