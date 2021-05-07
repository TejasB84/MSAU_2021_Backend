package com.example.candidatemgmt.bean;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Trends2RowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        trends2 trends22=new trends2();
        trends22.setLocation(resultSet.getString("location"));
        trends22.setId(resultSet.getInt("count(id)"));
        return trends22;
    }
}
