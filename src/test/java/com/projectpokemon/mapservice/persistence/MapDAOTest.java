package com.projectpokemon.mapservice.persistence;

import com.projectpokemon.mapservice.enums.MapType;
import com.projectpokemon.mapservice.objects.RouteMap;
import com.projectpokemon.mapservice.persistence.rowmapper.MapRowMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MapDAOTest {

    private static final String SELECT_ALL = "SELECT * from route_maps";
    private static final String SELECT_BY_ID = "SELECT * from route_maps WHERE id = ?";

    private static final int ID_1 = 30;
    private static final int ID_2 = 37;

    private static final String NAME_1 = "Route 404";
    private static final String NAME_2 = "Verdant Field";

    @Mock
    JdbcTemplate mockJdbcTemplate;
    @Mock
    MapRowMapper mockRowMapper;

    @InjectMocks
    private MapDAO mapDAO;

    private RouteMap routeMap1;
    private RouteMap routeMap2;


    @BeforeEach
    void setUp() {
        routeMap1 = new RouteMap(ID_1, NAME_1, MapType.GRASS_ROUTE);
        routeMap2 = new RouteMap(ID_2, NAME_2, MapType.GRASS_ROUTE);

    }

    @Test
    void can_select_all() {
        when(mockJdbcTemplate.query(eq(SELECT_ALL), eq(mockRowMapper))).thenReturn(Arrays.asList(routeMap1, routeMap2));
        List<RouteMap> actual = mapDAO.getAllMaps();

        verify(mockJdbcTemplate).query(eq(SELECT_ALL), eq(mockRowMapper));

        assertEquals(ID_1, actual.getFirst().getId());
        assertEquals(NAME_1, actual.getFirst().getName());
        assertEquals(MapType.GRASS_ROUTE, actual.getFirst().getType());

        assertEquals(ID_2, actual.get(1).getId());
        assertEquals(NAME_2, actual.get(1).getName());
        assertEquals(MapType.GRASS_ROUTE, actual.get(1).getType());
    }

    @Test
    void select_by_id() {
        when(mockJdbcTemplate.queryForObject(eq(SELECT_BY_ID), eq(mockRowMapper), eq(ID_2))).thenReturn(routeMap2);
        RouteMap actual = mapDAO.getMapById(ID_2);

        verify(mockJdbcTemplate).queryForObject(eq(SELECT_BY_ID), eq(mockRowMapper), eq(ID_2));

        assertEquals(ID_2, actual.getId());
        assertEquals(NAME_2, actual.getName());
        assertEquals(MapType.GRASS_ROUTE, actual.getType());
    }

}