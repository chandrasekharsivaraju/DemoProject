package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepository;
import com.example.demo.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepository repository;
	
	@RequestMapping("/")
	public String home()
	{
		System.out.println("default method");
		return "home.jsp";
	}
	
	/*
	 * @RequestMapping("addAlien") public String add(Alien alien) {
	 * System.out.println("add alien method "+alien);
	 * 
	 * repository.save(alien);
	 * 
	 * return "home.jsp"; }
	 */
	
	@PostMapping("/alien")
	
	public Alien addAliens(@RequestBody Alien alien)
	{
		System.out.println("add alien method "+alien);
		
		repository.save(alien);
		
		return alien;
	}
	
	
	@GetMapping(path ="/aliens")
	public List<Alien> getAliens()
	{
		System.out.println("getAliens method ");
		
		return repository.findAll();
		
		
	}
	
	@GetMapping("/alien/{id}")
	public Optional<Alien> getAlien(@PathVariable("id") int id)
	{
		System.out.println("getAliens by id method ");
		
		return repository.findById(id);
		
		
	}
	
	
	@RequestMapping("findAlien")
	public ModelAndView findAlien(int aid)
	{
		ModelAndView mv = new ModelAndView("view.jsp");
		
		System.out.println("find alien method "+aid);
		
		Alien alien = repository.findById(aid).orElse(new Alien());
		
		System.out.println("find alien method details  "+alien);
		
		System.out.println("find alien method with names  "+repository.findByaname("Chandra"));
		
		mv.addObject(alien);
		
		return mv;
	}

}
