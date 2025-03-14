package com.shane.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class DeliverDTO {
    private String id;
    private String client;
    private String detail;
    private double price; // "pendiente", "pagado", "enviado"
    private String url;
    private LocalDateTime dateCreation;
    // Constructor vacío (necesario para MongoDB)
    public DeliverDTO() {}

    // Constructor con parámetros
    public DeliverDTO(String client, String detail, double price,String url) {
        this.client = client;
        this.detail = detail;
        this.price = price;
        this.url = url;
    }
}
