package com.projectpokemon.mapservice.rest;

import com.projectpokemon.mapservice.objects.RouteMap;
import com.projectpokemon.mapservice.service.MapService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/map")
public class MapResource {

    private MapService mapService;

    @GetMapping("/all")
    public List<RouteMap> getAllMaps() {
        return mapService.getAllMaps();
    }

    @GetMapping("/{id}")
    public RouteMap getMapById(@PathVariable("mapId") int mapId) {
        return mapService.getMapById(mapId);
    }
}
