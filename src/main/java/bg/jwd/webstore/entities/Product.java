package bg.jwd.webstore.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 5221830063279663423L;
	
	@Id
	@Column(name = "ID")
	private long id;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "PRODUCT_PRICE")
	private Double productPrice;

	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "QUANTITY")
	private Integer quantity;
	
	@Column(name = "STATUS_ID")
	private long statusId;

/*	(One to One (1/2)
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "STATUS_ID", insertable = false, updatable = false)
	private Status status;*/
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "STATUS_ID", insertable = false, updatable = false)
	private Status status;
	
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

}
