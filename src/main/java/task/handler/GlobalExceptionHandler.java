package task.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import task.exception.ValidCustomException;
import task.response.ExceptionResponse;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	@ExceptionHandler(value = ValidCustomException.class)
	public ExceptionResponse mismatchException(ValidCustomException exception) {
		return ExceptionResponse.builder().code(exception.getCode()).error(exception.getMessage()).build();
	}
}
