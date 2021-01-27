package de.rauldev.springbootjenkinsawsdemo.controller;

import de.rauldev.springbootjenkinsawsdemo.dto.ProductDTO;
import de.rauldev.springbootjenkinsawsdemo.entities.ProductEntity;
import de.rauldev.springbootjenkinsawsdemo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
@Slf4j
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductEntity> findAll(){
        log.info("Fetching All Products");
        return this.productService.findAll().collect(Collectors.toList());
    }


    @GetMapping(value = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductEntity getProductById(@PathVariable("id") long id){
        log.info("Fetching Product Data with id: {}", id);
        return this.productService.findProductById(id);
    }

    @PostMapping(value = "/products",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductEntity createProduct(@Valid @RequestBody ProductDTO productDTO){
        log.info("Creating Product : {}", productDTO.toString());
        return this.productService.createProduct(productDTO);
    }

}
