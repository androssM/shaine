package com.shane.service;

import com.shane.dto.DeliverDTO;
import com.shane.entity.Deliver;
import com.shane.interfaces.DeliverInterface;
import com.shane.repository.DeliverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DeliverService implements DeliverInterface {
    @Autowired
    private DeliverRepository deliverRepository;

    @Override
    public DeliverDTO createDeliver(Deliver deliver) {
        deliverRepository.save(deliver);

        return tranferToDTO(deliver);
    }

    @Override
    public List<Deliver> getDelivers() {

        return deliverRepository.findAll();
    }

    @Override
    public Optional<Deliver> getDeliverById(String id) {
        if(!deliverRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El pedido con ID " + id + " no existe.");

        }
        return deliverRepository.findById(id);
    }

    @Override
    public DeliverDTO updateDeliverById(String id, Deliver deliver) {
        if (deliverRepository.existsById(id)) {
            deliverRepository.save(deliver);
        }

        return tranferToDTO(deliver);
    }

    @Override
    public void deleteDeliverById(String id) {
        if (!deliverRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El pedido con ID " + id + " no existe.");
        }
        deliverRepository.deleteById(id);
    }

    public DeliverDTO tranferToDTO(Deliver deliver) {
        return new DeliverDTO(deliver.getClient(), deliver.getDetail(),
                deliver.getPrice(), deliver.getUrl());
    }
}
