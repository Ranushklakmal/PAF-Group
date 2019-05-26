package com.springbootexample;

//Modify package according to your project 
import org.springframework.data.jpa.repository.JpaRepository; 

import com.springbootexample.Seller; 

public interface SellerRepository  extends JpaRepository <Seller, Long> {

}
