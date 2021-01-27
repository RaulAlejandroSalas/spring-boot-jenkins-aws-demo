package de.rauldev.springbootjenkinsawsdemo.repository;

import de.rauldev.springbootjenkinsawsdemo.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<ProductEntity,Long> { }
