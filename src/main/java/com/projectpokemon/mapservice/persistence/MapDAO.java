package com.projectpokemon.mapservice.persistence;

import com.projectpokemon.mapservice.objects.RouteMap;
import com.projectpokemon.mapservice.persistence.rowmapper.MapRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MapDAO {
    private static final String SELECT_ALL = "SELECT * from route_maps";
    private static final String SELECT_BY_ID = "SELECT * from route_maps WHERE id = ?";

    private JdbcTemplate jdbcTemplate;
    private MapRowMapper rowMapper;

    public List<RouteMap> getAllMaps() {
        return jdbcTemplate.query(SELECT_ALL, rowMapper);
    }

    public RouteMap getMapById(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, rowMapper, id);
    }
}
