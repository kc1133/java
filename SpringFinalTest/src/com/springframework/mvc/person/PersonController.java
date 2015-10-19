package com.springframework.mvc.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.samples.mvc.exceptions.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import com.springframework.beans.*;

 
@Controller
public class PersonController {
     
   
     
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("person", new Person());
        
        return "person";
    }
     
    //For add and update person both
    @RequestMapping(value= "/person/add", method = RequestMethod.POST)
    @ExceptionHandler({MyException.class})
    public String addPerson(@ModelAttribute("person") Person p,Model m){
         
    	if(p.getName().length() < 5 ){
            throw new MyException("Given name is too short");
         }else{
          
         }
         
        m.addAttribute("name", p.getName());
         
         return "result";
         
    }
     
    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
         
       
        return "redirect:/persons";
    }
  
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        
        return "person";
    }
     
}