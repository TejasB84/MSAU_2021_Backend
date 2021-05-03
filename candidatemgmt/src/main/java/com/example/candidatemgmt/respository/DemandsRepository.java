package com.example.candidatemgmt.respository;

import com.example.candidatemgmt.bean.Demands;
import com.example.candidatemgmt.bean.DemandsRowMapper;
import com.example.candidatemgmt.bean.OnBoardingDetails;
import com.example.candidatemgmt.bean.OnboardDetailsRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DemandsRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<OnBoardingDetails> getDemandsdetails(){
        return  jdbcTemplate.query("select * from demands",new DemandsRowMapper());
    }

    public Demands findById(Integer id){

        String sql = "SELECT * FROM demands WHERE DID = ?";
        try{
            return  (Demands) this.jdbcTemplate.queryForObject(
                    sql, new Object[] { id }, new DemandsRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }

    }

    public Boolean saveDemandsdetails(Demands demands){
        String query="insert into demands values(?,?,?,?,?)";
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setInt(1,demands.getDid());
                ps.setString(2,demands.getRole());
                ps.setString(3,demands.getDept());
                ps.setString(4,demands.getMname());
                ps.setString(5,demands.getLocation());



                return ps.execute();

            }
        });
    }

    public Integer updateDemandsdetails(Demands demands){
        String query="update demands set role = ? , dept = ? , mname = ? , location = ? where did = ?";
        Object[] params = {demands.getRole(),demands.getDept(),demands.getMname(),demands.getLocation(),demands.getDid()};
        int[] types = {Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER};

        return jdbcTemplate.update(query, params, types);
    }

    public Integer deleteDemandsdetailsById(Integer id){
        return jdbcTemplate.update("delete from demands where did = ?",id);
    }


}


