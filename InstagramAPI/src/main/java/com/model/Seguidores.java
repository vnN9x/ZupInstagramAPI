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
@Table(name = "seguidores")
public class Seguidores {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long requestId;
	@Column(name = "seguidor_id")
	private long seguidorId;
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
	@ManyToOne
	private User user;

	public Seguidores() {}
	
	public Seguidores(long seguidorId) {
		super();
		this.seguidorId = seguidorId;
	}

	public long getSeguidorId() {
		return seguidorId;
	}

	public void setSeguidorId(long seguidorId) {
		this.seguidorId = seguidorId;
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
