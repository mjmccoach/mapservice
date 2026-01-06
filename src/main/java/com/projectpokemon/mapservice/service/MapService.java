package com.projectpokemon.mapservice.service;

import com.projectpokemon.mapservice.objects.RouteMap;
import com.projectpokemon.mapservice.persistence.MapDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class MapService {
    private MapDAO mapDAO;

    public List<RouteMap> getAllMaps() {
        return mapDAO.getAllMaps();
    }

    public RouteMap getMapById(int mapId) {
        return mapDAO.getMapById(mapId);
    }
}
