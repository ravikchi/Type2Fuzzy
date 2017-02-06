package com.ravi.TypeReduction.TypeReducer;

/**
 * Created by ravik on 01/02/2017.
 */
public class MinTnorm implements Operator{
    private double mulx;
    private double muly;

    private double muux;
    private double muuy;

    private double firingIntervalx;
    private double firingIntervaly;

    public double getMulx() {
        return mulx;
    }

    public void setMulx(double mulx) {
        this.mulx = mulx;
    }

    public double getMuly() {
        return muly;
    }

    public void setMuly(double muly) {
        this.muly = muly;
    }

    public double getMuux() {
        return muux;
    }

    public void setMuux(double muux) {
        this.muux = muux;
    }

    public double getMuuy() {
        return muuy;
    }

    public void setMuuy(double muuy) {
        this.muuy = muuy;
    }

    public double getFiringIntervalx() {
        return firingIntervalx;
    }

    public void setFiringIntervalx(double firingIntervalx) {
        this.firingIntervalx = firingIntervalx;
    }

    public double getFiringIntervaly() {
        return firingIntervaly;
    }

    public void calculateFiringInterval(double mulx, double muly, double muux, double muuy) {
        this.mulx = mulx;
        this.muly = muly;
        this.muux = muux;
        this.muuy = muuy;
        this.firingIntervalx = Math.min(mulx,muly);
        this.firingIntervaly = Math.min(muux,muuy);
    }

    public void setFiringInterval(double x, double y) {
        this.firingIntervalx = x;
        this.firingIntervaly = y;
    }

    public void setFiringIntervaly(double firingIntervaly) {
        this.firingIntervaly = firingIntervaly;
    }
}