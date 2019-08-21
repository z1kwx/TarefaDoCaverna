package br.com.tarefaDoCaverna.Exception.Handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.tarefaDoCaverna.Exception.ClientAlreadyExistsException;
import br.com.tarefaDoCaverna.Exception.ClientDontExistsException;
import br.com.tarefaDoCaverna.Exception.InvalidCpfOrCepException;
import br.com.tarefaDoCaverna.Exception.SaldoInsuficienteException;


@RestControllerAdvice
public class AllExceptionHandler {

	
	@ExceptionHandler(ClientAlreadyExistsException.class)
	public ResponseEntity<Object> handleClientAlreadyExistsException (ClientAlreadyExistsException e){
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidCpfOrCepException.class)
	public ResponseEntity<Object> handleInvalidCpfOrCepException(InvalidCpfOrCepException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(ClientDontExistsException.class)
	public ResponseEntity<Object> handleClientDontExistsException(ClientDontExistsException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(SaldoInsuficienteException.class)
	public ResponseEntity<Object> handleSaldoInsuficienteException(SaldoInsuficienteException e){
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
	}
	
}
