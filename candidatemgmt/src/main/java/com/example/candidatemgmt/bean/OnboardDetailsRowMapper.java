package com.example.candidatemgmt.bean;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class OnboardDetailsRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        OnBoardingDetails onBoardingDetails=new OnBoardingDetails();

        onBoardingDetails.setId(resultSet.getInt("id"));
        onBoardingDetails.setonboardingDate(resultSet.getString("onboardingDate"));
        onBoardingDetails.setbcgStatus(resultSet.getString("bcgStatus"));
        onBoardingDetails.setGraduationStatus(resultSet.getString("GraduationStatus"));
        onBoardingDetails.setetaStatus(resultSet.getString("etaStatus"));

        return onBoardingDetails;
    }
}
