package br.org.serratec.h2banco.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class PessoaFisica extends Fornecedor{

	@Column
	private String rg;
	
	@Column
	private String orgamEmisor;
	
	@Column
	private String cpf;

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgamEmisor() {
		return orgamEmisor;
	}

	public void setOrgamEmisor(String orgamEmisor) {
		this.orgamEmisor = orgamEmisor;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
