package com.ravi.TypeReduction.TypeReducer;

/**
 * Created by ravik on 29/01/2017.
 */
public class RuleRow {
    private String ruleName;
    private int NVL;
    private int S;
    private int MOA;
    private int LA;
    private int MAA;
    private double clAvgx;
    private double clAvgy;
    private ProductTnorm firingInterval;

    public RuleRow(String ruleName, int NVL, int s, int MOA, int LA, int MAA, double clAvgx, double clAvgy) {
        this.ruleName = ruleName;
        this.NVL = NVL;
        S = s;
        this.MOA = MOA;
        this.LA = LA;
        this.MAA = MAA;
        this.clAvgx = clAvgx;
        this.clAvgy = clAvgy;
    }

    public ProductTnorm getFiringInterval() {
        return firingInterval;
    }

    public void setFiringInterval(ProductTnorm firingInterval) {
        this.firingInterval = firingInterval;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public int getNVL() {
        return NVL;
    }

    public void setNVL(int NVL) {
        this.NVL = NVL;
    }

    public int getS() {
        return S;
    }

    public void setS(int s) {
        S = s;
    }

    public int getMOA() {
        return MOA;
    }

    public void setMOA(int MOA) {
        this.MOA = MOA;
    }

    public int getLA() {
        return LA;
    }

    public void setLA(int LA) {
        this.LA = LA;
    }

    public int getMAA() {
        return MAA;
    }

    public void setMAA(int MAA) {
        this.MAA = MAA;
    }

    public double getClAvgx() {
        return clAvgx;
    }

    public void setClAvgx(double clAvgx) {
        this.clAvgx = clAvgx;
    }

    public double getClAvgy() {
        return clAvgy;
    }

    public void setClAvgy(double clAvgy) {
        this.clAvgy = clAvgy;
    }
}
