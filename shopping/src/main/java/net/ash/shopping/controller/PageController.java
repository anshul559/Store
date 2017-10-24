package net.ash.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("msg", "Hi Welcome of Spring MVC in Maven");
		return mv;
	}
	
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
}
