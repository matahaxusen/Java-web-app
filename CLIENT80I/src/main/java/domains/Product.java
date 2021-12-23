package domains;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Product {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_product;
	private String title;
	private String category;
	private String description;
	private float value;
	private String image;
	private String owner;
	private String state;
	
	

	public Product() {
	}

	public long getId_product() {
		return id_product;
	}


	public void setId_product(long id_product) {
		this.id_product = id_product;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public float getValue() {
		return value;
	}


	public void setValue(float value) {
		this.value = value;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public Product(long id_product,String title,String category,String description,float value,String image,String owner, String state) {
		this.id_product=id_product;
		this.title=title;
		this.category=category;
		this.description=description;
		this.value=value;
		this.image=image;
		this.owner=owner;
		this.state=state;
	}
	
	public Product(String title,String category,String description,float value,String image,String owner, String state) {
		this.title=title;
		this.category=category;
		this.description=description;
		this.value=value;
		this.image=image;
		this.owner=owner;
		this.state=state;
	}


}