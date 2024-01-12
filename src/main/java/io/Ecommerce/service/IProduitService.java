package io.Ecommerce.service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import io.Ecommerce.entity.Categorie;
import io.Ecommerce.entity.Produit;


public interface IProduitService {

	Produit create(String nom,float prix,Categorie categoryId, MultipartFile file) throws IOException;
	Collection<Produit> list();
	Produit update(Produit produit);
	Boolean delete(Long id);
	//List<Produit> retrieveProduitByCategorie(Long categorieId);
	//List<Produit> retrieveProduitByCategorie();
	
}
