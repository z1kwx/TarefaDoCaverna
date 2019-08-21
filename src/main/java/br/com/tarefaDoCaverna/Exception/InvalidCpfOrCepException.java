package br.com.tarefaDoCaverna.Exception;

public class InvalidCpfOrCepException extends RuntimeException {

	private static final long serialVersionUID = 2979063874116046392L;

	public InvalidCpfOrCepException(String message) {
		super(message);
	}
	
	public InvalidCpfOrCepException() {
		super();
	}
}
