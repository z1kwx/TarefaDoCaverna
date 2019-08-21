package br.com.tarefaDoCaverna.models;

public class Order {

	private Long totalValue;
	private String cpf;

	
	public Long getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(Long totalValue) {
		this.totalValue = totalValue;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
