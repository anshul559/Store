package net.ash.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.ash.shoppingBackend.DAO.CategoryDao;
import net.ash.shoppingBackend.Model.Category;

@Controller
public class PageController {

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
	private CategoryDao ctgryDao;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("ctgries", ctgryDao.list());
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
		mv.addObject("ctgries", ctgryDao.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	
	/*Get Category Products*/
	@RequestMapping("/show/category/{id}/products")
	public ModelAndView showCategoryProduct(@PathVariable("id")int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("ctgries", ctgryDao.list());
		Category ct = null;
		ct = ctgryDao.get(id);
		mv.addObject("title", ct.getCtgryName());
		mv.addObject("category", ct);
		mv.addObject("userClickCategoryProduct", true);
		return mv;
	}
}
