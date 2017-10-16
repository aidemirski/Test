package bg.jwd.webstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.jwd.webstore.dao.product.ProductDao;
import bg.jwd.webstore.entities.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	@Override
	public List<Product> getProducts(String productName, String status) {
		return productDao.getProducts(productName, status);
	}
	@Override
	public boolean addProduct(Product product) {
		productDao.addProduct(product);
		return true;
	}
	@Override
	public List<Product> getProducts() {
		return productDao.getProducts();
	}

}
