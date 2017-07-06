package com.kovalyk.securemessages.form;

import java.io.Serializable;

public class UserId implements Serializable {

	private static final long serialVersionUID = 2481653820668508222L;
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
