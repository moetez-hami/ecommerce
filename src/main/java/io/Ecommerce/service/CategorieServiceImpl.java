package io.Ecommerce.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.Ecommerce.entity.Categorie;
import io.Ecommerce.repository.CategorieRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class CategorieServiceImpl implements ICategorieService {
	
	@Autowired
	private final CategorieRepository categorieRepo;
	
	@Override
	public Categorie create(Categorie categorie) {
		log.info("Saving new Categorie: {}",categorie.getNom());
		//categorie.setImageUrl(setcategorieImageUrl());
		// TODO Auto-generated method stub
		return categorieRepo.save(categorie);
	}

	@Override
	public Collection<Categorie> list() {
		log.info("Fetching All Categories");
		// TODO Auto-generated method stub
		return categorieRepo.findAll();
	}

	@Override
	public Categorie update(Categorie categorie) {
		log.info("Update existing categorie: {}",categorie.getNom());
		// TODO Auto-generated method stub
		return categorieRepo.save(categorie);
	}

	@Override
	public Boolean delete(Long id) {
		log.info("Deleting categorie: {}",id);
		// TODO Auto-generated method stub
		categorieRepo.deleteById(id);
		return true;
	}

	
}
