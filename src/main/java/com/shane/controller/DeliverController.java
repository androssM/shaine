package com.shane.controller;

import com.shane.component.JwtUtil;
import com.shane.dto.DeliverDTO;
import com.shane.entity.Deliver;
import com.shane.service.DeliverService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/delivers")
public class DeliverController {
    private final JwtUtil jwtUtil;
    @Autowired
    DeliverService deliverService;

    public DeliverController(JwtUtil jwtUtil){
        this.jwtUtil = jwtUtil;
    }
    @PostMapping
    public ResponseEntity<DeliverDTO> createDeliver(@RequestHeader("Authorization") String authHeader,@Valid @RequestBody DeliverDTO deliverdto) {
        System.out.println(deliverdto);
        System.out.println("Authorization Header: " + authHeader); // 👀 Verifica si el token llega

        Deliver deliver  = new Deliver();
        deliver.setName(deliverdto.getName());
        deliver.setLastname(deliverdto.getLastName());
        deliver.setStatus("pending");
        deliver.setProducts(deliverdto.getProducts());
        return ResponseEntity.ok(deliverService.createDeliver(deliver));
    }
    @GetMapping
    public ResponseEntity<List<Deliver>> getDelivers(@RequestHeader("Authorization") String authHeader)
    {
        return ResponseEntity.ok(deliverService.getDelivers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Deliver>> getDeliverById(@RequestHeader("Authorization") String authHeader,@PathVariable String id){
        try{
            return ResponseEntity.ok(deliverService.getDeliverById(id));
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(null);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeliverById(@RequestHeader("Authorization") String authHeader,@PathVariable String id){
        try{

            deliverService.deleteDeliverById(id);
            return ResponseEntity.noContent().build();
        }catch (ResponseStatusException e){
            return ResponseEntity.status(e.getStatusCode()).body(null);

        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<Deliver> updateDeliverById(@RequestHeader("Authorization") String authHeader,@PathVariable String id,@RequestBody Deliver deliver){


        return ResponseEntity.ok(deliverService.updateDeliverById(id,deliver));
    }
}
