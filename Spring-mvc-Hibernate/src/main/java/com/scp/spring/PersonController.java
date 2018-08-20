package com.scp.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scp.spring.model.Person;
import com.scp.spring.service.PersonService;

import net.bytebuddy.asm.Advice.This;


@Controller//controller for handling request and responce 
public class PersonController {

	private PersonService personService;
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String listPerson(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listOfPerson",this.personService.listOfPersons());
		return "person";		
	}
	
	@RequestMapping(value="/person/add",method=RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p) {
		if(p.getId()!=0) {
			this.personService.addPerson(p);
			
		}else {
			this.personService.updatePersone(p);
		}
		return "redirect:/persons";
		
	}
	
	@RequestMapping("/remove/{id}")
	public String  removePerson(@PathVariable("id") int id) {
		this.personService.removePerson(id);
		return "redirect:/persons";
		
	}
	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id,Model model) {
		model.addAttribute("person",this.personService.getPersonById(id));
		model.addAttribute("listPerson", this.personService.listOfPersons());
		return "person";
	}
}
