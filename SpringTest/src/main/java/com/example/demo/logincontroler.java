package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.util.*;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Person;
@Controller
public class logincontroler {
	List<Person> persons = new ArrayList<>();
	public logincontroler(){
		persons.add(new Person("PE001","Sing",22,"user"));
		persons.add(new Person("PE002","MEME",15,"user"));
	}
	int counter = persons.size()+1;
	String id = String.format("PE%03d", counter);
    @GetMapping("/login")
    public String login() {
    	return "login";
    }
    
    @GetMapping("/addperson")
    public String AddPerson(Model model) {
    	model.addAttribute("message", "Berhasil login");
    	return "AddPerson";
    }
    
    @GetMapping("/list")
    public String list(Model model) {
    	model.addAttribute("persons",persons);
    	return "list";
    }
    
    @PostMapping("/addperson")
    public String add(@ModelAttribute Person Person) {
    	Person.setRoles("user");
    	Person.setId(id);
    	persons.add(Person);
    	return "redirect:/list";
    }
    
    @PostMapping("/delete/{index}")
    public String del(@PathVariable int index) {
    	if(index >=0&&index<=persons.size()) {
    		persons.remove(index);
    	}
    	return "redirect:/list";
    }
    
    @GetMapping("/edit/{index}")
    public String editPerson(@PathVariable int index, Model model) {
        Person person = persons.get(index);
        model.addAttribute("person", person);
        model.addAttribute("index", index);  // Pass the index to the form for update
        return "update";  // returns editPerson.html page
    }
    
    @PostMapping("/update/{index}")
    public String edit(@PathVariable int index,@ModelAttribute Person updatedPerson) {
    	Person person = persons.get(index);
        person.setName(updatedPerson.getName());
        person.setAge(updatedPerson.getAge());
        person.setRoles(updatedPerson.getRoles());

        // Optionally, save the updated person (e.g., to a database) here

        return "redirect:/list"; 
    }
    
}
