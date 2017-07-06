package com.kovalyk.securemessages.form;

import java.io.Serializable;

public class Notification  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8309168579985456564L;
	
	private String type;
	private String message;

	public Notification() {
		super();		
	}

	public Notification(String type, String message) {
		this.type = type;
		this.message = message;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
