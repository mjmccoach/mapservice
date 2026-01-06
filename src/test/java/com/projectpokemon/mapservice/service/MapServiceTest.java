package com.projectpokemon.mapservice.service;

import com.projectpokemon.mapservice.enums.MapType;
import com.projectpokemon.mapservice.objects.RouteMap;
import com.projectpokemon.mapservice.persistence.MapDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MapServiceTest {

    private static final int ID_1 = 30;
    private static final int ID_2 = 37;

    private static final String NAME_1 = "Route 404";
    private static final String NAME_2 = "Verdant Field";

    @Mock
    MapDAO mockMapDAO;

    @InjectMocks
    MapService mapService;

    private RouteMap routeMap1;
    private RouteMap routeMap2;

    @BeforeEach
    void setUp() {
        routeMap1 = new RouteMap(ID_1, NAME_1, MapType.GRASS_ROUTE);
        routeMap2 = new RouteMap(ID_2, NAME_2, MapType.GRASS_ROUTE);
    }

    @Test
    void get_all_maps() {
        when(mockMapDAO.getAllMaps()).thenReturn(Arrays.asList(routeMap1, routeMap2));

        List<RouteMap> actual = mapService.getAllMaps();

        assertEquals(2, actual.size());

        assertEquals(ID_1, actual.getFirst().getId());
        assertEquals(NAME_1, actual.getFirst().getName());
        assertEquals(MapType.GRASS_ROUTE, actual.getFirst().getType());

        assertEquals(ID_2, actual.get(1).getId());
        assertEquals(NAME_2, actual.get(1).getName());
        assertEquals(MapType.GRASS_ROUTE, actual.get(1).getType());
    }

    @Test
    void get_map_by_id() {
        when(mockMapDAO.getMapById(anyInt())).thenReturn(routeMap1);

        RouteMap actual = mapService.getMapById(ID_1);

        assertEquals(ID_1, actual.getId());
        assertEquals(NAME_1, actual.getName());
        assertEquals(MapType.GRASS_ROUTE, actual.getType());
    }
}