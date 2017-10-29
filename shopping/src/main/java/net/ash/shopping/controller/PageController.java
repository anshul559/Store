package net.ash.shopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.ash.shopping.exception.CategoryNotFoundException;
import net.ash.shopping.exception.ProductNotFoundException;
import net.ash.shoppingBackend.DAO.CategoryDao;
import net.ash.shoppingBackend.DAO.ProductDao;
import net.ash.shoppingBackend.Model.Category;
import net.ash.shoppingBackend.Model.Product;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
//	@RequestMapping("/test")
	// @RequestParam get the value from query String(url Parameter)
/*	public ModelAndView test(@RequestParam(value="a", required=false)String str) { // a is url parameter which have String value and str take this value
		ModelAndView mv = new ModelAndView("show");
		if(str == null)
			str = "Hi take Value manually";
		mv.addObject("msg", str); // str assign this value into msg
		return mv;
	} */
	
	/*@RequestMapping("/test/{message}")	
	public ModelAndView test(@PathVariable("message")String str) { // message is url message which directly get with help of @PathVariable which have String value and str take this value
		ModelAndView mv = new ModelAndView("show");
		if(str == null)
			str = "Hi take Value manually";
		mv.addObject("msg", str); // str assign this value into msg
		return mv;
	}*/
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		logger.trace("Hi i am Logger with *************trace************");
		logger.info("Hi i am Logger with *************info************");
		logger.debug("Hi i am Logger with *************debug************");
		logger.error("Hi i am Logger with *************error************");
		mv.addObject("ctgries", categoryDao.listAll());
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping("/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	/*Get All Products*/
	@RequestMapping(value ="/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("ctgries", categoryDao.listAll());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	
	/*Get Category Products*/
	@RequestMapping("/show/category/{id}/products")
	public ModelAndView showCategoryProduct(@PathVariable("id")long id) throws CategoryNotFoundException {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("ctgries", categoryDao.listAll());
		Category ct = null;
		ct = categoryDao.get(id);
		if(ct == null) throw new CategoryNotFoundException();
		mv.addObject("title", ct.getCtgryName());
		mv.addObject("category", ct);
		mv.addObject("userClickCategoryProduct", true);
		return mv;
	}
	

	@RequestMapping("/show/{id}/product")
	public ModelAndView getSingleProductDetail(@PathVariable long id) throws ProductNotFoundException{
		ModelAndView mv = new ModelAndView("page");
		Product p = new Product();
		
		p = productDao.get(id);
		if(p == null) throw new ProductNotFoundException();
		/*Update Count*/
		p.setViews(p.getViews()+1);
		productDao.update(p);
		
		mv.addObject("title", p.getName());
		mv.addObject("product", p);
		mv.addObject("userClickShowProduct", true);
		return mv;
		
	}
}
