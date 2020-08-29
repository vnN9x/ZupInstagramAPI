package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"email", "user_name"}))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome_completo")
	private String nomeCompleto;
	private String email;
	@Column(name = "user_name")
	private String userName;
	private String senha;
	@Column(name = "perfil_img")
	private String perfilImg;
	private String site;
	private String biografia;
	private String telefone;
	private String genero;
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	private List<Img> imgs;	
	
	@OneToMany(cascade= CascadeType.ALL)
	private List<Seguidores> seguidores;	
	
	@OneToMany(cascade= CascadeType.ALL)
	private List<Seguindo> seguindo;	
	
	public User() {
		
	}

	public User(String nomeCompleto, String email, String userName, String senha, String perfilImg, String site,
			String biografia, String telefone, String genero) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.userName = userName;
		this.senha = senha;
		this.perfilImg = perfilImg;
		this.site = site;
		this.biografia = biografia;
		this.telefone = telefone;
		this.genero = genero;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
	
	
	
}
