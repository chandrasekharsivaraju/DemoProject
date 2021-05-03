package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Alien;

@Controller
public class HomeController {
	
	@RequestMapping("home")
	public ModelAndView home(Alien alien)
	{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("obj", alien);
		System.out.println(alien);
		System.out.println("*** inside home controller ***");
		
		return mv;
	}

}
