package br.usp.ime.ingpos.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Dados_Pessoais")
public class DadosPessoais {
	
	@GeneratedValue
	@Id
	private Long dadosPessoaisID;
	@Column(length = 50)
	private String nomeCompleto;
	@Column
	private String email;
	@Column
	private String senha;
	@Column
	private String estadoCivil;
	@Column(length=11)
	private String cpf;
	@Column
	private String nacionalidade;
	@OneToOne
	private CedulaDeIdentidade cedulaDeIdentidade;
	@ManyToMany
	private Endereco endereco;
	@Column
	private Date dataDeNascimento;
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public CedulaDeIdentidade getCedulaDeIdentidade() {
		return cedulaDeIdentidade;
	}
	public void setCedulaDeIdentidade(CedulaDeIdentidade cedulaDeIdentidade) {
		this.cedulaDeIdentidade = cedulaDeIdentidade;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public Long getDadosPessoaisID() {
		return dadosPessoaisID;
	}
	public void setDadosPessoaisID(Long dadosPessoaisID) {
		this.dadosPessoaisID = dadosPessoaisID;
	}
}
