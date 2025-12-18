package com.projectpokemon.mapservice.objects;

import com.projectpokemon.mapservice.enums.MapType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RouteMap {

    private int id;
    private String name;
    private MapType type;
}
