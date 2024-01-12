package io.Ecommerce.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.Ecommerce.entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{

	//List<Produit> findByCategoryId(Long categoryId);
	

	    
	
}
