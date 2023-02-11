package com.zyabin.productservice.service;

import com.zyabin.productservice.dto.ProductRequest;
import com.zyabin.productservice.dto.ProductResponse;
import com.zyabin.productservice.model.Product;
import com.zyabin.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private ProductRepository productRepository;


    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {}  is saved",product.getId() );


    }

    public List<ProductResponse> getAllProduct() {
       List<Product> products =  productRepository.findAll();

        return  products.stream().map(this::mapToProductResponse).toList();

    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())

                .build();

    }
}
