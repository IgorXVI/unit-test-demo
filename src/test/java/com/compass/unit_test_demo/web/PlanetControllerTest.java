package com.compass.unit_test_demo.web;

import com.compass.unit_test_demo.common.PlanetConstants;
import com.compass.unit_test_demo.domain.Planet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.compass.unit_test_demo.domain.PlanetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class PlanetControllerTest {
    @InjectMocks
    private PlanetController planetController;

    @Mock
    private PlanetRepository planetRepository;

    @Test
    void createPlanet_WithValidData_ReturnsPlanet() {
        Mockito.when(planetRepository.save(PlanetConstants.PLANET)).thenReturn(PlanetConstants.PLANET);

        ResponseEntity<Planet> res = planetController.create(PlanetConstants.PLANET);

        assertThat(res).isNotNull();
        assertThat(res.getBody()).isNotNull();
        assertThat(res.getBody().getName()).isEqualTo(PlanetConstants.PLANET.getName());
        assertThat(res.getBody().getClimate()).isEqualTo(PlanetConstants.PLANET.getClimate());
        assertThat(res.getBody().getTerrain()).isEqualTo(PlanetConstants.PLANET.getTerrain());
    }

    @Test
    void createPlanet_WithInvalidData_ReturnsError() {
        Mockito.when(planetRepository.save(PlanetConstants.INAVALID_PLANET)).thenThrow(RuntimeException.class);

        assertThatThrownBy(() -> planetController.create(PlanetConstants.INAVALID_PLANET)).isInstanceOf(RuntimeException.class);
    }
}
