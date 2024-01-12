package io.Ecommerce.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import io.Ecommerce.entity.Categorie;
import io.Ecommerce.entity.Produit;
import io.Ecommerce.repository.ProduitRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ProduitServiceImpl implements IProduitService{
	
	@Autowired
	private final ProduitRepository produitRepo;
	
	private final String FOLDER_PATH="C:\\Users\\LENOVO\\Desktop\\spring\\work\\Ecommerce\\upload\\";


	
	@Override
	public Produit create(String nom,float prix,Categorie categoryid, MultipartFile file) throws IOException{
//		System.out.println(file.getOriginalFilename());
		
		//String filePath=System.getProperty("java.io.tmpdir")+"/"+file.getOriginalFilename();
		String filePath=file.getOriginalFilename();
		//file.transferTo(new File(filePath));
		byte[] fileContent = Base64.encodeBase64(file.getBytes(), false);
		
		System.out.println(new String(fileContent) );
//		String encodedString = Base64.getEncoder().encodeToString(fileContent);
//		System.out.println(encodedString);
		
		Produit fileData=produitRepo.save(Produit.builder()
				.nom(nom)
				.imageUrl(new String(fileContent))
				.prix(prix)
				.categoryId(categoryid)
				.build());
				
		file.transferTo(new File(filePath));
		log.info("Saving new Produit: {}",nom);
		//categorie.setImageUrl(setcategorieImageUrl());
		// TODO Auto-generated method stub
		return fileData;
	}

	@Override
	public Collection<Produit> list() {
		log.info("Fetching All Produits");
		// TODO Auto-generated method stub
		return produitRepo.findAll();
	}

	@Override
	public Produit update(Produit produit) {
		log.info("Update existing categorie: {}",produit.getNom());
		// TODO Auto-generated method stub
		return produitRepo.save(produit);
	}

	@Override
	public Boolean delete(Long id) {
		log.info("Deleting produit: {}",id);
		// TODO Auto-generated method stub
		produitRepo.deleteById(id);
		return true;
	}

	
//	public List<Produit> getProductsByCategory(Long category) {
//        return produitRepo.findByCategoryId(category);
//    }
//	
	public List<Produit> getProduitByCategorie(Long idCategorie){
		List<Produit> list = new ArrayList();
		List<Produit> produits = (List<Produit>) produitRepo.findAll();
		for (Produit produit : produits) {
			System.out.println(produit.getCategoryId().getIdCategorie());
			System.out.println("sssssssssssss"+idCategorie);
			if(produit.getCategoryId().getIdCategorie() == (idCategorie))
			list.add(produit);
		}
		return list;
	}

	
	

}
