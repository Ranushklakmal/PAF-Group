package com.springbootexample;

import java.util.List; 

import javax.validation.Valid; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 
import com.springbootexample.SellerDAO; 
import com.springbootexample.Seller; 

@RestController 
@RequestMapping("/company") 
public class Controller {   
	@Autowired  SellerDAO sellerDAO; 

 
     /* SAVE AN EMPLOYEE */ 
      @PostMapping("/employees")  
      public Seller createSeller(@Valid @RequestBody Seller sel) {   
    	  return sellerDAO.save(sel);  
    	  }   
      
      /* GET ALL EMPLOYEES*/ 
      @GetMapping("/employees")  
      public List<Seller> getAllSeller(){  
    	  return sellerDAO.findAll();  
    	  }    
      /* GET EMPLOYEE BY ID */  
      @GetMapping("/employees/{id}")  
      public ResponseEntity<Seller> getSellerById(@PathVariable(value="id") Long Id){   
    	  Seller sel = sellerDAO.findOne(Id);      
    	  
    	  if(sel==null) {    
    		  return ResponseEntity.notFound().build();  
    		  }   
    	  return ResponseEntity.ok().body(sel);      
      }
	
     /* UPDATE AN EMPLOYEE BY ID */  
      @PutMapping("/employees/{id}")  
      public ResponseEntity<Seller> updateSeller(@PathVariable(value="id") Long Id, 
    @Valid @RequestBody Seller empDetails){  
    	  
    	  Seller sel=sellerDAO.findOne(Id);      
    	  
    	  if(sel==null) {    
    		  return ResponseEntity.notFound().build();  
    	}   
    	sel.setName(empDetails.getName());   
    	sel.setDesignation(empDetails.getDesignation());   
    	sel.setEmail(empDetails.getEmail()); 
    	sel.setPhone(empDetails.getPhone()); 
    	
    	Seller updaSeller=sellerDAO.save(sel);     
    	return ResponseEntity.ok().body(updaSeller);   
    	
      }
    	
    	/*DELETE AN EMPLOYEE*/ 
      @DeleteMapping("/employees/{id}")  
      public ResponseEntity<Seller> deleteSeller(@PathVariable(value="id") Long Id){  
    	  Seller sel = sellerDAO.findOne(Id);   
    	  if(sel==null) {    
    		  return ResponseEntity.notFound().build();  
    		  }   
    	  sellerDAO.delete(sel);   
    	  return ResponseEntity.ok().build();  
    	  }
      }


