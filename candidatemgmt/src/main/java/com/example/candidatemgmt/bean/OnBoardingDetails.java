package com.example.candidatemgmt.bean;

public class OnBoardingDetails {
    int id;
    String onboardingDate;
    String bcgStatus;
    String GraduationStatus;
    String etaStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getonboardingDate() {
        return onboardingDate;
    }

    public void setonboardingDate(String onboardingDate) {
        this.onboardingDate = onboardingDate;
    }

    public String getbcgStatus() {
        return bcgStatus;
    }

    public void setbcgStatus(String bcgStatus) {
        this.bcgStatus = bcgStatus;
    }

    public String getGraduationStatus() {
        return GraduationStatus;
    }

    public void setGraduationStatus(String GraduationStatus) {
        this.GraduationStatus = GraduationStatus;
    }

    public String getetaStatus() {
        return etaStatus;
    }

    public void setetaStatus(String etaStatus) {
        this.etaStatus = etaStatus;
    }



}
