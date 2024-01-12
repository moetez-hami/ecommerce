package io.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.Ecommerce.entity.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
