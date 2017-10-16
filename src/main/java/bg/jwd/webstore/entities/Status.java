package bg.jwd.webstore.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STATUS")
public class Status implements Serializable {

	private static final long serialVersionUID = -2860194811166589101L;

	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "STATUS_NAME")
	private String statusName;
	/* One To One (2/2) - Това е една таблица, к. е разделена на две по вертикалата
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "status")
	private Product product;
	*/
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "status")
	private List<Product> product;

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
}
