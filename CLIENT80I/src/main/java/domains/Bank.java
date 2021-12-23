package domains;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Bank {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_transaction;
	private String buyer;
	private String seller;
	private float value;
	private long product_id;
	private String product;
	private String date;
	
	
	public Bank() {
	}

	

	public long getId_transaction() {
		return id_transaction;
	}


	public void setId_transaction(long id_transaction) {
		this.id_transaction = id_transaction;
	}



	public String getBuyer() {
		return buyer;
	}



	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}



	public String getSeller() {
		return seller;
	}



	public void setSeller(String seller) {
		this.seller = seller;
	}



	public float getValue() {
		return value;
	}



	public void setValue(float value) {
		this.value = value;
	}



	public long getProduct_id() {
		return product_id;
	}



	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}



	public String getProduct() {
		return product;
	}



	public void setProduct(String product) {
		this.product = product;
	}


	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public Bank(String buyer, String seller, float value, long product_id, String product, String date) {
		// TODO Auto-generated constructor stub
		this.buyer = buyer;
		this.seller = seller;
		this.value = value;
		this.product_id = product_id;
		this.product = product;
		this.date = date;
	}

}