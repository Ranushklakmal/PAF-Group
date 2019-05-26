package com.springbootexample;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Isolation; 
import org.springframework.transaction.annotation.Transactional; 
import com.springbootexample.Seller; 
import com.springbootexample.SellerRepository; 

@Service public class SellerDAO { 
 
	@Autowired  
	SellerRepository sellerRepository;    
 
	/* SAVE AN EMPLOYEE */ 
	@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)  
	public Seller save(Seller sel) {   
		return sellerRepository.save(sel);  
		 
	}
 
	/* SEARCH ALL EMPLOYEES */  
	public List<Seller> findAll(){   
		return sellerRepository.findAll();  
	}    
	
	/* GET AN EMPLOYEE */ 
	public Seller findOne(Long Id) {  
		Optional<Seller> op = sellerRepository.findById(Id);   
		if(op.isPresent()) {   
			return op.get();   
			}   else {    
				return null;   
			}  }    
	
	/* DELETE AN EMPLOYEE by id */  
	@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED) 
	public void delete(Seller sel) {   
		sellerRepository.delete(sel);  
		} 
	}  

