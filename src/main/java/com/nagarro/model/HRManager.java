package com.nagarro.model;
/*
 * @Author Bhumika_Arora
 */
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HRManager {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Id
	String username;
	String password;
	
	
	public HRManager() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(final int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(final String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(final String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "HRManager [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	public HRManager(final int id, final String username, final String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	
	

}
