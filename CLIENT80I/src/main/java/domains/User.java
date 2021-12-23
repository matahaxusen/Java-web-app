package domains;

public class User {
	private static final long serialVersionUID = 1L;

	private String name;
	private String surname;
	private String email;
	private String pass;
	private String city;
	private String image;
	
	
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
	
	public User(String name,String surname, String email, String pass, String city, String image) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.pass = pass;
		this.city = city;
		this.image = image;
	}

}