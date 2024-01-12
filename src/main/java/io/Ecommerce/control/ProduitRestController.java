package io.Ecommerce.control;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;

import io.Ecommerce.entity.Categorie;
import io.Ecommerce.entity.Produit;
import io.Ecommerce.service.ProduitServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produit")
public class ProduitRestController {
	
	private final ProduitServiceImpl produitServiceImpl;
	
	// http://localhost:8090/SpringMVC/produit/list
		@GetMapping("/list")
		public Collection<Produit> getProduit(){
			Collection<Produit> listProduit = produitServiceImpl.list();
			return listProduit;
		}

//		// http://localhost:8090/SpringMVC/produit/list
//		@GetMapping("/listproduitCategorie")
//		//public List<Produit> getProduitByCategorie(@RequestBody Long categorieId) {
//			public List<Produit> getProduitByCategorie() {
//			List<Produit> listProduit = produitServiceImpl.retrieveProduitByCategorie();
//			return listProduit;
//		}
		
		 @GetMapping("/by-category/{category}")
		    public ResponseEntity<List<Produit>> getProductsByCategory(@PathVariable Long category) {
		        List<Produit> products = produitServiceImpl.getProduitByCategorie(category);

		        if (products.isEmpty()) {
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		        }

		        return new ResponseEntity<>(products, HttpStatus.OK);
		    }
		
		// http://localhost:8090/SpringMVC/produit/create
//		@PostMapping("/create")
//		public Produit SaveProduit(@RequestBody @Valid Produit produit){
//			Produit pro = produitServiceImpl.create(produit);
//			return pro;
//		}
		
		@PostMapping("/create")
		public ResponseEntity<?> SaveProduit(@RequestParam("image")MultipartFile file,@RequestParam("nom")String nom,@RequestParam("prix")float prix,@RequestParam("categoryid")Categorie categoryId) throws IOException {
		//public ResponseEntity<?> SaveProduit(@RequestParam("image")MultipartFile file,@RequestParam("produit")Produit produit) throws IOException {
			Produit uploadImage = produitServiceImpl.create(nom,prix,categoryId,file);
			return ResponseEntity.status(HttpStatus.OK)
					.body(uploadImage);
		}
		
		// http://localhost:8090/SpringMVC/produit/modifier
				@PutMapping("/modifier")
				public Produit modifyProduit(@RequestBody Produit produit) {
				return produitServiceImpl.update(produit);
				}
				
		// http://localhost:8090/SpringMVC/produit/delete/{id}
		@DeleteMapping("/delete/{id}")
		public boolean deleteProduit(@PathVariable("id") Long id){
			
			return produitServiceImpl.delete(id); 
		}
		
}
