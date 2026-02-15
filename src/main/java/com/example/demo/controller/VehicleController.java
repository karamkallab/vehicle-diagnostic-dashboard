package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/analyze")
    public Vehicle analyze(@RequestBody Vehicle vehicle) {
        return vehicleService.analyze(vehicle);
    }

    @GetMapping
    public List<Vehicle> getAll() {
        return vehicleService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        vehicleService.delete(id);
    }

    @PutMapping("/{id}")
    public Vehicle update(@PathVariable String id,
                          @RequestBody Vehicle updated) {
        return vehicleService.update(id, updated);
    }

    @PutMapping("/{id}/resolve")
    public Vehicle resolve(@PathVariable String id) {
        return vehicleService.resolve(id);
    }

    @GetMapping("/stats")
    public VehicleService.Stats stats() {
        return vehicleService.getStats();
    }
}
