package br.com.tarefaDoCaverna.Exception;

public class ClientAlreadyExistsException extends RuntimeException{

	
	private static final long serialVersionUID = 6381473822101579861L;

	public ClientAlreadyExistsException (String message) {
		super(message);
	}
	
	public ClientAlreadyExistsException () {
		super();
	}
	
}
