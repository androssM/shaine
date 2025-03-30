package com.shane.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "delivers")
@Data
public class Deliver {
    @Id
    private String id;

    @CreatedDate
    private LocalDateTime dateCreation;

    @NotEmpty(message = "El nombre es obligatorio")
    private String name;

    @NotEmpty(message = "El apellido es obligatorio")
    private String lastname;

    private String status; // "pendiente", "pagado", "enviado"

    @NotEmpty(message = "Debe haber al menos un producto")
    private List<Product> products;

    public Deliver() {}

    public Deliver(String name,String lastName, String status, List<Product> products) {
        this.name = name;
        this.lastname = lastName;
        this.status = status;
        this.products = products;
    }

}
