package de.rauldev.springbootjenkinsawsdemo.service;

import de.rauldev.springbootjenkinsawsdemo.dto.ProductDTO;
import de.rauldev.springbootjenkinsawsdemo.entities.ProductEntity;
import de.rauldev.springbootjenkinsawsdemo.exeptions.NotProductFoundException;
import de.rauldev.springbootjenkinsawsdemo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;
@Service
public class ProductService {

    private IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository productRepository){
        this.productRepository =productRepository;
    }

    public ProductEntity createProduct(ProductDTO productDTO){
        return this.productRepository.save(new ProductEntity(productDTO.getName(),productDTO.getPrice()));
    }

    public Stream<ProductEntity> findAll(){
        Iterable<ProductEntity> products = this.productRepository.findAll();
        return StreamSupport.stream(products.spliterator(),false);
    }

    public ProductEntity findProductById(Long id){
        return this.productRepository.findById(id)
                                     .orElseThrow(()-> new NotProductFoundException(HttpStatus.NOT_FOUND,String.format("Not Product found with Id: {}",id)));
    }
}
