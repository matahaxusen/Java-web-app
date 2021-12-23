package tiw.clients.manage.domains;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "clients")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;
	private String name;
	private String surname;
	private String pass;
	private String city;
	private String image;
	
	/*
	@JsonIgnore
	@OneToMany (mappedBy="user",
				fetch = FetchType.EAGER)
	//@JoinColumn(name="usuarioId")
	Set<Address> address;	
	*/ 
	
	public User() {
	}

	public String getName() {
		return this.name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}