package br.com.tarefaDoCaverna.Exception;

public class SaldoInsuficienteException extends RuntimeException {

	private static final long serialVersionUID = 964702781904097188L;

	public SaldoInsuficienteException(String message) {
		super(message);
	}
	
	public SaldoInsuficienteException() {
		super();
	}
	
}
