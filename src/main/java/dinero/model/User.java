package dinero.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JavaBean class used in jsp action tags.
 * @author Ramesh Fadatare
 */

@Entity @Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @Column(name = "USERID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userID ;

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PASSWORD")
	private String password;
	
	
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public long getUserID() {
		return userID;
	}
	public void setUserID(long UserID) {
		this.userID = UserID;
	}

	public User(long UserID, String name, String email, String username, String password) {
		super();
		this.userID =UserID;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	public User() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public User(String name, String email, String username, String password) {
		super();

		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	

	
	
}
