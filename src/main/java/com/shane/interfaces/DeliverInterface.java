package com.shane.interfaces;

import com.shane.dto.DeliverDTO;
import com.shane.entity.Deliver;

import java.util.List;
import java.util.Optional;

public interface DeliverInterface {
    public DeliverDTO createDeliver(Deliver deliver);
    public List<Deliver> getDelivers();
    public Optional<Deliver> getDeliverById(String id);
    public DeliverDTO updateDeliverById(String id,Deliver deliver);
    public void deleteDeliverById(String id);
}
