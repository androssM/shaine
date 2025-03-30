package com.shane.dto;

import com.shane.entity.Product;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DeliverDTO {
    private String id;
    private String name;
    private String lastName;
    private List<Product> products;
    LocalDateTime dateCreation;
    // Constructor vacío (necesario para MongoDB)
    public DeliverDTO() {}

    // Constructor con parámetros
    public DeliverDTO(String name,String lastName, List<Product> products) {
        this.name = name;
        this.lastName = lastName;
        this.products = products;

    }
}
