package com.shane.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
public class Product {
    @NotEmpty(message = "El detalle del producto es obligatorio")
    private String detail;

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 1, message = "El precio debe ser mayor a 0")
    private double price;

    @NotEmpty(message = "El url del producto es obligatorio")
    private String url;

    public Product() {}

    public Product(String detail, double price, String url) {
        this.detail = detail;
        this.price = price;
        this.url = url;
    }
}
