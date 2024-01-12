package io.Ecommerce.control;


import java.util.Collection;

import javax.validation.Valid;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.Ecommerce.entity.Categorie;
import io.Ecommerce.service.CategorieServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categorie")
public class CategorieRestController {

	private final CategorieServiceImpl categorieServiceImpl;
	
	// http://localhost:8090/SpringMVC/categorie/list
	@GetMapping("/list")
	public Collection<Categorie> getCategorie(){
		Collection<Categorie> listCategories = categorieServiceImpl.list();
		return listCategories;
	}
	
	
	// http://localhost:8090/SpringMVC/categorie/create
	@PostMapping("/create")
	public Categorie SaveCategorie(@RequestBody @Valid Categorie categorie){
		Categorie cat = categorieServiceImpl.create(categorie);
		return cat;
	}
	
	// http://localhost:8090/SpringMVC/categorie/modifier
			@PutMapping("/modifier")
			public Categorie modifyCategorie(@RequestBody Categorie categorie) {
			return categorieServiceImpl.update(categorie);
			}
			
	// http://localhost:8090/SpringMVC/categorie/delete/{id}
	@DeleteMapping("/delete/{id}")
	public boolean deleteCategorie(@PathVariable("id") Long id){
		
		return categorieServiceImpl.delete(id); 
	}
	
}
