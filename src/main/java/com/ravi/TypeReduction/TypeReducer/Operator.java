package com.ravi.TypeReduction.TypeReducer;

/**
 * Created by ravik on 01/02/2017.
 */
public interface Operator {
    public double getFiringIntervalx();
    public double getFiringIntervaly();
    public void calculateFiringInterval(double mulx, double muly, double muux, double muuy);
    public void setFiringInterval(double x, double y);
}
