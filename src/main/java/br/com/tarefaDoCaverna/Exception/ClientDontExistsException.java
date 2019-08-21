package br.com.tarefaDoCaverna.Exception;

public class ClientDontExistsException extends RuntimeException {

	
	private static final long serialVersionUID = 2671590021473514990L;

	public ClientDontExistsException (String message) {
		super(message);
	}
	
	public ClientDontExistsException() {
		super();
	}
	
}
