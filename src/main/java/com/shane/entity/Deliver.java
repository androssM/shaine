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

@Document(collection = "delivers")
@Data
public class Deliver {
    @Id // Indica el identificador único del documento
    private String id;
    @NotEmpty(message = "El cliente es obligatorio")
    private String client;
    @NotEmpty(message = "El detalle del producto es obligatorio")
    private String detail;
    @NotNull(message = "El precio es obligatorio")
    @Min(value = 1, message = "El precio debe ser mayor a 0")
    private double price;
    private String status; // "pendiente", "pagado", "enviado"
    @NotEmpty(message = "El url del producto es obligatorio")
    private String url;
    @CreatedDate
    private LocalDateTime dateCreation;
    // Constructor vacío (necesario para MongoDB)
    public Deliver() {}

    // Constructor con parámetros
    public Deliver(String client, String detail, double price, String status,String url) {
        this.client = client;
        this.detail = detail;
        this.price = price;
        this.status = status;
        this.url = url;
        this.dateCreation = LocalDateTime.now();
    }
}
