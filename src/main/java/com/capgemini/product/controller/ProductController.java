package com.capgemini.product.controller;

import com.capgemini.product.service.ProductService;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.product.entities.Product;
import com.capgemini.product.exceptions.ProductNotFoundException;

@RestController
public class ProductController {
private final static Logger LOGGER = Logger.getLogger(ProductController.class.getName());
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
	  
		ResponseEntity<Product> responseEntity=new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.OK);
		LOGGER.info("HELLO");
		return responseEntity;
	}
	
	
//	@PutMapping("/product")
//	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
//		try{
//			Product p=productService.findProductById(product.getProductId());
//			if(p!=null)
//		return new ResponseEntity<Product>(productService.updateProduct(product), HttpStatus.OK);
//	      }
//		catch(ProductNotFoundException exception) {
//			//logged the exception
//		}
//		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
//	}
//	
//	@GetMapping("/product/{productId}")
//	public ResponseEntity<Product> findProductById(@PathVariable int productId) {
//		try {
//		Product p=productService.findProductById(productId);
//		if(p!=null)
//			return new ResponseEntity<Product>(p,HttpStatus.OK);
//		}
//		catch(ProductNotFoundException exception) {
//			
//		}
//		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
//		
//	}
//	
//	@DeleteMapping("/product/{productId}")
//	public ResponseEntity<Product> deleteProduct(@PathVariable int productId) {
//		try {
//			Product productFromDb = productService.findProductById(productId);
//			if (productFromDb != null) {
//				productService.deleteProduct(productFromDb);
//				return new ResponseEntity<Product>(HttpStatus.OK);
//			}
//		} catch (ProductNotFoundException exception) {
//			// logged the exception
//		}
//		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
//	}
}