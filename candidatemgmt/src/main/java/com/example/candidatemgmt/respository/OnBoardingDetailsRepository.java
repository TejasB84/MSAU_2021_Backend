package com.example.candidatemgmt.respository;

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
import java.util.List;



@Repository
public class OnBoardingDetailsRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<OnBoardingDetails> getOnboarddetails(){
        return  jdbcTemplate.query("select * from onboardingdetails",new OnboardDetailsRowMapper());
    }

    public OnBoardingDetails findById(Integer id){

        String sql = "SELECT * FROM onboardingdetails WHERE ID = ?";
        try{
            return  (OnBoardingDetails) this.jdbcTemplate.queryForObject(
                    sql, new Object[] { id }, new OnboardDetailsRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }

    }

    public Boolean saveOnboarddetails(OnBoardingDetails onboardingdetails){
        String query="insert into onboardingdetails values(?,?,?,?,?)";
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setInt(1,onboardingdetails.getId());
                ps.setString(2,onboardingdetails.getonboardingDate());
                ps.setString(3,onboardingdetails.getbcgStatus());
                ps.setString(4,onboardingdetails.getGraduationStatus());
                ps.setString(5,onboardingdetails.getetaStatus());



                return ps.execute();

            }
        });
    }

    public Integer updateOnboarddetails(OnBoardingDetails onboardingdetails){
        String query="update onboardingdetails set onboardingDate = ? , bcgStatus = ? , GraduationStatus = ? , etaStatus = ? where id = ?";
        Object[] params = {onboardingdetails.getonboardingDate(),onboardingdetails.getbcgStatus(),onboardingdetails.getGraduationStatus(),onboardingdetails.getetaStatus(),onboardingdetails.getId()};
        int[] types = {Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER};

        return jdbcTemplate.update(query, params, types);
    }

    public Integer deleteOnboarddetailsById(Integer id){
        return jdbcTemplate.update("delete from onboardingdetails where id = ?",id);
    }
}

