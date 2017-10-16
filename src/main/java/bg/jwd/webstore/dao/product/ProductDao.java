package bg.jwd.webstore.dao.product;

import java.util.List;
import bg.jwd.webstore.entities.Product;

public interface ProductDao {
	Product getProduct(String productName);
	boolean addProduct(Product product);
	List<Product> getProducts(String productName, String status);
	List<Product> getProducts();
}
