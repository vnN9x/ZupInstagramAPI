package com.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="O campo nome completo deve ser preenchido")
	@Size(min=3, max=255)
	private String nomeCompleto;
	
	@NotNull(message="O campo email deve ser preenchido")
	@Email
	private String email;
	
	@NotNull(message="O campo nome de usuário deve ser preenchido")
	@Size(min=3, max=255)
	private String userName;
	
	@NotNull(message="O campo senha deve ser preenchido")
	@Size(min=3, max=255)
	private String senha;
	
	private String perfilImg;
	
	private String site;
	
	private String biografia;
	
	@Size(min=8, max=15)
	private String telefone;
	
	private String genero;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPerfilImg() {
		return perfilImg;
	}

	public void setPerfilImg(String perfilImg) {
		this.perfilImg = perfilImg;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
