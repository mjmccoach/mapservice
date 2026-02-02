package com.projectpokemon.mapservice.enums;

public enum MapType {
    ROCK_CAVE("cave"),
    ICE_CAVE("ice cave"),
    LAVA_CAVE("lava cave"),
    ROCK_ROUTE("rock route"),
    ICE_ROUTE("ice route"),
    SNOW_ROUTE("snow route"),
    GRASS_ROUTE("grass route"),
    WATER_ROUTE("water route");

    private String value;

    MapType(String value) {
        this.value = value;
    }
}
