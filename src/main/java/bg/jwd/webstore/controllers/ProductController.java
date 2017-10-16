package bg.jwd.webstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bg.jwd.webstore.constants.UrlConstants;

import bg.jwd.webstore.dto.ProductSearch;
import bg.jwd.webstore.entities.Product;
import bg.jwd.webstore.service.ProductService;
import bg.jwd.webstore.utils.UserUtils;

@Controller
public class ProductController {
		
	@Autowired
	private ProductService productService;

	@RequestMapping(value = UrlConstants.PRODUCT_REGISTER_URL, method = RequestMethod.GET)
	public String getProducts(Model model, @ModelAttribute("ProductSearch") ProductSearch productSearch) {
		
		model.addAttribute("products", productService.getProducts(productSearch.getProductName(), productSearch.getStatus()));
		model.addAttribute("productRegisterUrl", UrlConstants.PRODUCT_REGISTER_URL);
		model.addAttribute("addProductUrl", UrlConstants.ADD_PRODUCT_URL);
		model.addAttribute("user", UserUtils.getUser());

		return "products";
	}

	@RequestMapping(value = UrlConstants.ADD_PRODUCT_URL, method = RequestMethod.GET)
	public String addProduct(Model model) {
		model.addAttribute("addProductUrl", UrlConstants.ADD_PRODUCT_URL);
		return "addProduct";
	}
/*	//Аалогично на горния метод, но с ModelAndView
	@RequestMapping(value = UrlConstants.ADD_PRODUCT_URL, method = RequestMethod.GET)
	public ModelAndView addProductModelAndView(ModelAndView modelAndView) {
		modelAndView.addObject("addProductUrl", UrlConstants.ADD_PRODUCT_URL);
		modelAndView.setViewName("addProduct");
		return modelAndView;
	}*/
	
	@RequestMapping(value = UrlConstants.ADD_PRODUCT_URL, method = RequestMethod.POST)
	public String addProduct(Model model, @ModelAttribute("product") Product product) {

		productService.addProduct(product);
		
		return "redirect:" + UrlConstants.PRODUCT_REGISTER_URL;
	}
	
	

}
