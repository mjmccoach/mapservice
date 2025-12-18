package com.projectpokemon.mapservice.persistence;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class MapDAO {

    private JdbcTemplate jdbcTemplate;

}
