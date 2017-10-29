package net.ash.shopping.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(JsonDataController.class);
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllActiveProducts(){
		logger.trace("Hi i am Logger with ***getAllActiveProducts**********trace************");
		logger.info("Hi i am Logger with *************info************");
		logger.debug("Hi i am Logger with *************debug************");
		logger.error("Hi i am Logger with *************error************");
		return productDao.getActiveProducts();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getAllActiveProductsByCategory(@PathVariable long id){
		logger.trace("Hi i am Logger with ******getAllActiveProductsByCategory*******trace************");
		logger.info("Hi i am Logger with *************info************");
		logger.debug("Hi i am Logger with *************debug************");
		logger.error("Hi i am Logger with *************error************");
		return productDao.getActiveProductsByCategory(id);
	}
}
