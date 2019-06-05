package biz.korwin.web.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	/**
	 * Ugly and minimalistic error handling.
	 * */
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleExcetionn(Exception ex, WebRequest request) {
	 
	    RestError restError =  new RestError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), ex);
	    
	    return new ResponseEntity<Object>(restError, new HttpHeaders(), restError.getStatus());
	}

}
