package com.vehicle.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
    @GetMapping
    public String getAllVehicle() {
        return "Hello, World!";
    }
}