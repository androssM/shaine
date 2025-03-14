package com.shane.controller;

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
    @Autowired
    DeliverService deliverService;
    @PostMapping
    public ResponseEntity<DeliverDTO> createDeliver(@Valid @RequestBody DeliverDTO deliverdto) {
        System.out.println(deliverdto);
        Deliver deliver  = new Deliver();
        deliver.setClient(deliverdto.getClient());
        deliver.setDetail(deliverdto.getDetail());
        deliver.setPrice(deliverdto.getPrice());
        deliver.setUrl(deliverdto.getUrl());
        deliver.setStatus("pending");
        return ResponseEntity.ok(deliverService.createDeliver(deliver));
    }
    @GetMapping
    public ResponseEntity<List<Deliver>> getDelivers(){
        return ResponseEntity.ok(deliverService.getDelivers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Deliver>> getDeliverById(@PathVariable String id){
        try{
            return ResponseEntity.ok(deliverService.getDeliverById(id));
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(null);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeliverById(@PathVariable String id){
        try{
            deliverService.deleteDeliverById(id);
            return ResponseEntity.noContent().build();
        }catch (ResponseStatusException e){
            return ResponseEntity.status(e.getStatusCode()).body(null);

        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<DeliverDTO> deleteDeliverById(@PathVariable String id,DeliverDTO deliverDTO){
        Deliver deliver  = new Deliver();
        deliver.setClient(deliverDTO.getClient());
        deliver.setDetail(deliverDTO.getDetail());
        deliver.setPrice(deliverDTO.getPrice());
        deliver.setUrl(deliverDTO.getUrl());
        deliver.setStatus("pending");
        return ResponseEntity.ok(deliverService.updateDeliverById(id,deliver));
    }
}
