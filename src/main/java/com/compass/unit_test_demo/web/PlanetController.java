package com.compass.unit_test_demo.web;

import com.compass.unit_test_demo.domain.Planet;
import com.compass.unit_test_demo.domain.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planets")
public class PlanetController {
    @Autowired
    PlanetRepository planetRepository;

    @PostMapping
    public ResponseEntity<Planet> create(@RequestBody Planet planet) {
        Planet createdPlanet = planetRepository.save(planet);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlanet);
    }
}
