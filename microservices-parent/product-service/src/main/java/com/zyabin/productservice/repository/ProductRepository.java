package com.zyabin.productservice.repository;

import com.zyabin.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product , String> {

}
