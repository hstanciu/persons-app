package biz.korwin.web.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RestError {

	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;

	
	public RestError() {
		
		this.timestamp = LocalDateTime.now();
		
	}

	
	public RestError(HttpStatus status) {
		
		this();
		this.status = status;
		
	}

	
	public RestError(HttpStatus status, Throwable ex) {
		
		this();
		this.status = status;
		this.message = "Unexpected error";
		
	}

	
	public RestError(HttpStatus status, String message, Throwable ex) {
		
		this();
		this.status = status;
		this.message = message;
		
	}

	
	public HttpStatus getStatus() {
		return status;
	}

	
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	
	public String getMessage() {
		return message;
	}

	
	public void setMessage(String message) {
		this.message = message;
	}
}
