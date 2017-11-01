package net.ash.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.ash.shopping.springValidator.ProductValidator;
import net.ash.shopping.util.FileUploadUtility;
import net.ash.shoppingBackend.DAO.CategoryDao;
import net.ash.shoppingBackend.DAO.ProductDao;
import net.ash.shoppingBackend.Model.Category;
import net.ash.shoppingBackend.Model.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/adminaddproducts" , method=RequestMethod.GET)
	public ModelAndView adminAddProducts(@RequestParam(name="operation", required=false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAdminAddProducts", true);
		Product newPrdct = new Product();
		newPrdct.setSupplierId(1);
		newPrdct.setActive(true);
		mv.addObject("product", newPrdct);
		mv.addObject("title", "Admin Add Products");
		if(operation != null) {
			if(operation.equals("product"))
				mv.addObject("msg", "Product Saved Successfully");
		}
		return mv;
	}
	
	@ModelAttribute("categories")
	public List<Category> get(){
		return categoryDao.listAll();
	}
	
	@RequestMapping(value="/adminaddproducts", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product addProduct, BindingResult results, Model model, HttpServletRequest req) {
		/*Check if there any error*/
		
		new ProductValidator().validate(addProduct, results);
		
		if(results.hasErrors()) {
			model.addAttribute("userClickAdminAddProducts", true);
			model.addAttribute("title", "Admin Add Products");
			model.addAttribute("msg", "Save Process Failed Data not save");
			return "page";
		}
		
		logger.info(addProduct.toString());
		productDao.add(addProduct);
		
		if(!addProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(req, addProduct.getFile(), addProduct.getCode());
		}
		
		return "redirect:/manage/adminaddproducts?operation=product";
	}
	
	@RequestMapping(value="/adminshowproducts" , method=RequestMethod.GET)
	public ModelAndView adminShowProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAdminShowProducts", true);
		mv.addObject("title", "Admin Show Products");
		return mv;
	}
	
	@RequestMapping(value="/products/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable long id) {
		Product p = productDao.get(id);
		boolean isActive = p.isActive();
		p.setActive(!p.isActive());
		productDao.update(p);
		return (isActive)? "Your Product "+ p.getName() +" is Deactivate Successfully by id-"+p.getId() : "Your Product "+ p.getName() +" is Activate Successfully by id-"+p.getId();
	}
}
