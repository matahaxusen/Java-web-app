package tiw.clients.manage.domains;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "bank")
public class Bank implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_transaction;
	private String buyer;
	private String seller;
	private float value;
	private long product_id;
	private String product;
	private String date;
	
	
	public Bank() {
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
	
	

}
