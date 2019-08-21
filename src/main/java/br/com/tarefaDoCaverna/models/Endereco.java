package br.com.tarefaDoCaverna.models;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;


@Embeddable
public class Endereco {
	
	
	@JsonProperty("cep")
	private String cep;
	
	@JsonProperty("cidade")
	private String cidade;
	
	@JsonProperty("bairro")
	private String bairro;
	
	@JsonProperty("logradouro")
	private String logradouro;
	

	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

}
