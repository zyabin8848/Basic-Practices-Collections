package com.zyabin.productservice.controller;

import com.zyabin.productservice.dto.ProductRequest;
import com.zyabin.productservice.dto.ProductResponse;
import com.zyabin.productservice.model.Product;
import com.zyabin.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")  // http://localhost:8080/api/product
@RequiredArgsConstructor
public class ProductController  {

    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProduct(){
      return   productService.getAllProduct();
    }




}
