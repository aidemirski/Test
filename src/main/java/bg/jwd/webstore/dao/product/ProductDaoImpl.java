package bg.jwd.webstore.dao.product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bg.jwd.webstore.entities.Product;
import bg.jwd.webstore.entities.Status;


@Repository
public class ProductDaoImpl implements ProductDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Product getProduct(String productName) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
		Root<Product> from = criteriaQuery.from(Product.class);

		criteriaQuery.where(from.get("productName").in(productName));

		criteriaQuery.select(from);
		TypedQuery<Product> query = entityManager.createQuery(criteriaQuery);
		List<Product> products = query.getResultList();

		return products != null ? products.get(0) : null;
	}

	@Override
	public List<Product> getProducts(String productName, String status) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
		Root<Product> from = criteriaQuery.from(Product.class);

		Predicate predicate1 = criteriaBuilder.and();
		Predicate predicate2 = criteriaBuilder.and();
		if (status != null && !status.isEmpty()) {
			predicate1 = from.get("statusId").in(status);
		}
		if (productName != null && !productName.isEmpty()) {
			predicate2 = from.get("productName").in(productName);
		}

		criteriaQuery.where(predicate1, predicate2);

		criteriaQuery.select(from);
		TypedQuery<Product> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	@Override
	public List<Product> getProducts() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
		Root<Product> from = criteriaQuery.from(Product.class);
		criteriaQuery.select(from);
		TypedQuery<Product> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public boolean addProduct(Product product) {
	//	product.setId(12L);
    // Това е с EntityManager-a вариант 2 - не е нужно commit, само си го прави
	  //long id = product.getStatus().getId();
	  //Status status = new Status();
	  //status.setId(1);
	  product.setStatusId(1);
	  entityManager.persist(product);
	  //entityManager.flush();

				
		return true;
	}

}
