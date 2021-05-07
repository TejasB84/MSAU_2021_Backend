package com.example.candidatemgmt.bean;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DemandsRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Demands demands=new Demands();

        demands.setDid(resultSet.getInt("did"));
        demands.setRole(resultSet.getString("role"));
        demands.setDept(resultSet.getString("dept"));
        demands.setMname(resultSet.getString("mname"));
        demands.setLocation(resultSet.getString("location"));
        demands.setSkills(resultSet.getString("skills"));

        return demands;
    }
}
