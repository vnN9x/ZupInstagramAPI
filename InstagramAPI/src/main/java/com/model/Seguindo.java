package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "seguindo")
public class Seguindo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long requestId;
	@Column(name = "seguindo_id")
	private int seguindoId;
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
	@ManyToOne
	private User user;

	public Seguindo() {}
	
	public Seguindo(long requestId, int seguindoId) {
		super();
		this.requestId = requestId;
		this.seguindoId = seguindoId;
	}

	public int getSeguidorId() {
		return seguindoId;
	}

	public void setSeguidorId(int seguidorId) {
		this.seguindoId = seguidorId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}
	
}