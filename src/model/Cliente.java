package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return this.cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDatnasc() {
		return this.datnasc;
	}
	public void setDatnasc(Date datnasc) {
		this.datnasc = datnasc;
	}
	public String getSexo() {
		return this.sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEstcivil() {
		return this.estcivil;
	}
	public void setEstcivil(String estcivil) {
		this.estcivil = estcivil;
	}
	public int getAtivo() {
		return this.ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	
	public String getDatnascForm() {
		String retorno = "";
		
		try {
			retorno = new SimpleDateFormat("yyyy-MM-dd").format(this.datnasc);
		} catch(Exception e) {
			System.out.println(e);
		}
		return retorno;
	}

}
