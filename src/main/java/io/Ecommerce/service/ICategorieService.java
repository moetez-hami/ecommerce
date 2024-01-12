package io.Ecommerce.service;

import java.util.Collection;

import io.Ecommerce.entity.Categorie;

public interface ICategorieService {

	Categorie create(Categorie categorie);
	Collection<Categorie> list();
	Categorie update(Categorie categorie);
	Boolean delete(Long id); 
}
