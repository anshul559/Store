package net.ash.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.ash.shoppingBackend.DAO.ProductDao;
import net.ash.shoppingBackend.Model.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllActiveProducts(){
		return productDao.getActiveProducts();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getAllActiveProductsByCategory(@PathVariable long id){
		return productDao.getActiveProductsByCategory(id);
	}
}
