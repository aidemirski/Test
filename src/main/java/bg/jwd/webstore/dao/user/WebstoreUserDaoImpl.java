package bg.jwd.webstore.dao.user;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import bg.jwd.webstore.entities.WebstoreUser;

@Repository
public class WebstoreUserDaoImpl implements WebstoreUserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public WebstoreUser getUser(String username) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<WebstoreUser> criteriaQuery = criteriaBuilder.createQuery(WebstoreUser.class);
		Root<WebstoreUser> from = criteriaQuery.from(WebstoreUser.class);

		criteriaQuery.where(from.get("username").in(username));

		criteriaQuery.select(from);
		TypedQuery<WebstoreUser> query = entityManager.createQuery(criteriaQuery);
		List<WebstoreUser> users = query.getResultList();

		return users != null ? users.get(0) : null;
	}

	@Override
	public List<WebstoreUser> getUsers(String username, String status) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<WebstoreUser> criteriaQuery = criteriaBuilder.createQuery(WebstoreUser.class);
		Root<WebstoreUser> from = criteriaQuery.from(WebstoreUser.class);

		Predicate predicate1 = criteriaBuilder.and();
		Predicate predicate2 = criteriaBuilder.and();
		if (status != null && !status.isEmpty()) {
			predicate1 = from.get("status").in(status);
		}
		if (username != null && !username.isEmpty()) {
			predicate2 = from.get("username").in(username);
		}

		criteriaQuery.where(predicate1, predicate2);

		criteriaQuery.select(from);
		TypedQuery<WebstoreUser> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public List<WebstoreUser> getUsers() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<WebstoreUser> criteriaQuery = criteriaBuilder.createQuery(WebstoreUser.class);
		Root<WebstoreUser> from = criteriaQuery.from(WebstoreUser.class);
		criteriaQuery.select(from);
		TypedQuery<WebstoreUser> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

}