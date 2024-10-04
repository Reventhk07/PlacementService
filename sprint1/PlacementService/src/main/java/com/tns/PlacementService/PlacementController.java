package com.tns.PlacementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.NoResultException;

@RestController
public class PlacementController {
    @Autowired(required = true)
    private PlacementService service;
    
    @GetMapping("/placementservice")
    public java.util.List<Placement> list() {
        return service.listAll();
    }
    
    @GetMapping("/placementservice/{placementId}")
    public ResponseEntity<Placement> get(@PathVariable Integer placementId) {
        try {
            Placement placement = service.get(placementId);
            return new ResponseEntity<Placement>(placement, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/placementservice")
    public void add(@RequestBody Placement placement) {
        service.save(placement);
    }
    
    @PutMapping("/placementservice/{placementId}")
    public ResponseEntity<?> update(@RequestBody Placement placement, @PathVariable Integer placementId) {
        Placement existPlacement = service.get(placementId);
        if (existPlacement != null) {
            placement.setPlacementId(placementId);
            service.save(placement);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/placementservice/{placementId}")
    public void delete(@PathVariable Integer placementId) {
        service.delete(placementId);
    }
}
