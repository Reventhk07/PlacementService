package com.tns.PlacementService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlacementService {
    @Autowired
    private PlacementRepository repo;
    
    public List<Placement> listAll() {
        return repo.findAll();
    }
    
    public void save(Placement placement) {
        repo.save(placement);
    }
    
    public Placement get(Integer placementId) {
        return repo.findById(placementId).orElse(null);
    }
    
    public void delete(Integer placementId) {
        repo.deleteById(placementId);
    }
}
