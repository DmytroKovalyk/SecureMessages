package com.kovalyk.securemessages.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.kovalyk.securemessages.util.View;

@Entity
@Table(name = "account")
public class Account implements Serializable {

	private static final long serialVersionUID = -2012031750963363681L;

	@JsonView(View.Summary.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonView(View.Summary.class)
	@Column(name = "photo")
	private String photo;

	@JsonView(View.Summary.class)
	@Column(name = "first_name")
	private String firstName;

	@JsonView(View.Summary.class)
	@Column(name = "second_name")
	private String secondName;

	@JsonView(View.Summary.class)
	@Column(name = "nick_name")
	private String nickName;

	@JsonView(View.Summary.class)
	private String email;

	private String password;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "USER_FRIEND", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "friend_id", referencedColumnName = "id") })
	private Set<Account> followersToOther = new HashSet<Account>();

	@JsonIgnore
	@ManyToMany(mappedBy = "followersToOther")
	private Set<Account> followersToMe = new HashSet<Account>();

	@JsonIgnore
	@OneToMany(mappedBy = "from")
	private List<Message> sentMessages;

	@JsonIgnore
	@OneToMany(mappedBy = "to")
	private List<Message> getMessages;

	@JsonView(View.Summary.class)
	@Column(name = "online", columnDefinition = "false", nullable = false)
	private boolean online;

	@JsonIgnore
	public Set<Account> getFriends() {
		Set<Account> friends = new HashSet<Account>();
		for (Account follow : followersToMe) {
			if (followersToOther.contains(follow)) {
				friends.add(follow);
			}
		}
		return friends;
	}

	@JsonIgnore
	public Set<Account> getFirstSixFriends() {
		int size = 6;
		Set<Account> friends = new HashSet<Account>(size);

		for (Account account : getFriends()) {
			friends.add(account);
			--size;
			if (size <= 0) {
				break;
			}
		}

		return friends;
	}

	@JsonIgnore
	public List<Message> getFirstSixGetMessages() {
		int size = 6;
		List<Message> messages = new ArrayList<Message>(6);
		
		for (Message message : getMessages) {
			if (!message.isRead()){
				messages.add(message);
				--size;
				if (size <= 0) {
					break;
				}
			}
		}
		
		return messages;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getFullName() {
		return firstName + " " + secondName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Set<Account> getFollowersToOther() {
		return followersToOther;
	}

	public void setFollowersToOther(Set<Account> followersToOther) {
		this.followersToOther = followersToOther;
	}

	public Set<Account> getFollowersToMe() {
		return followersToMe;
	}

	public void setFollowersToMe(Set<Account> followersToMe) {
		this.followersToMe = followersToMe;
	}

	public List<Message> getSentMessages() {
		return sentMessages;
	}

	public void setSentMessages(List<Message> sentMessages) {
		this.sentMessages = sentMessages;
	}

	public List<Message> getGetMessages() {
		return getMessages;
	}

	public void setGetMessages(List<Message> getMessages) {
		this.getMessages = getMessages;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result
				+ ((secondName == null) ? 0 : secondName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (secondName == null) {
			if (other.secondName != null)
				return false;
		} else if (!secondName.equals(other.secondName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", photo=" + photo + ", firstName="
				+ firstName + ", secondName=" + secondName + ", nickName="
				+ nickName + ", email=" + email + ", password=" + password
				+ "]";
	}

}
