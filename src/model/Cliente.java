package model;

import java.util.Date;

public class Cliente {
	private int id;
	private String nome;
	private String cpf;
	private String email;
	private Date datnasc = new Date();
	private String sexo;
	private String estcivil;
	private int ativo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Date getDatnasc() {
		return datnasc;
	}
	public void setDatnasc(Date datnasc) {
		this.datnasc = datnasc;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEstcivil() {
		return estcivil;
	}
	public void setEstcivil(String estcivil) {
		this.estcivil = estcivil;
	}
	public int getAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

}
