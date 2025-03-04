package br.org.serratec.mapeamento.domain;

import java.time.LocalDate; 
import java.util.Objects;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Preencha o nome")
	@Size(max = 60, min = 0, message = "Preencha o nome")
	@Column(name = "nome", nullable = false, length = 60)
	private String nome;

	@CPF( message = "CPF INVALIDO!")
	@Size(max = 11, min = 11, message = "Preencha o CPF")
	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;

	@Email(regexp = "[a-z0-9.-_]+@[a-z0-9.-_]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE, message = "EMAIL INVALIDO!")
	@Column(name = "email", nullable = false, length = 50)
	private String email;

	@NotNull
	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	private LocalDate dataNascimento;
	
	@Embedded
	private Endereco endereco;

	public Cliente(Long id, String nome, String cpf, String email, LocalDate dataNascimento, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}

	public Cliente() {

	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
}
