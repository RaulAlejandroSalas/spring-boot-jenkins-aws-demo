package de.rauldev.springbootjenkinsawsdemo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name = "products")
@Setter
@Getter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id;
    @NotEmpty()
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_price")
    private Double price;

    @Column(name = "product_createdAt")
    private LocalDate creationDate;

    public ProductEntity(){
        this.creationDate = LocalDate.now();
    }

    public ProductEntity(String name,Double price){
        this();
        this.name = name;
        this.price = price;
    }

}
