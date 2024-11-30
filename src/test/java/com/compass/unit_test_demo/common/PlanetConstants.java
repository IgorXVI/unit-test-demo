package com.compass.unit_test_demo.common;

import com.compass.unit_test_demo.domain.Planet;

public class PlanetConstants {
    public static final Planet PLANET = new Planet("test terrain", "test climate", "test");
    public static final Planet INAVALID_PLANET = new Planet("", "test climate", "test");
}
