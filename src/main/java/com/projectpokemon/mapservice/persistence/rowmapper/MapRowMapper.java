package com.projectpokemon.mapservice.persistence.rowmapper;

import com.projectpokemon.mapservice.enums.MapType;
import com.projectpokemon.mapservice.objects.RouteMap;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapRowMapper implements RowMapper<RouteMap> {
    @Override
    public RouteMap mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new RouteMap(
                rs.getInt("id"),
                rs.getString("name"),
                MapType.valueOf(rs.getString("type").toUpperCase()));
    }
}
