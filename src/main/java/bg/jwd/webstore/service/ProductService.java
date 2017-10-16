package bg.jwd.webstore.service;

import java.util.List;
import bg.jwd.webstore.entities.Product;

public interface ProductService {

	List<Product> getProducts(String productName, String status);
	List<Product> getProducts();
	boolean addProduct(Product product);
}
