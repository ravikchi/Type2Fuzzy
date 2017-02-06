package com.ravi.TypeReduction.TypeReducer;

/**
 * Created by ravik on 30/01/2017.
 */
public class ProductTnorm implements Operator{
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

    public void setFiringInterval(double firingIntervalx, double firingIntervaly){
        this.firingIntervalx = firingIntervalx;
        this.firingIntervaly = firingIntervaly;
    }

    public void calculateFiringInterval(double mulx, double muly, double muux, double muuy) {
        this.mulx = mulx;
        this.muly = muly;
        this.muux = muux;
        this.muuy = muuy;
        this.firingIntervalx = mulx * muly;
        this.firingIntervaly = muux * muuy;
    }

    public void setFiringIntervaly(double firingIntervaly) {
        this.firingIntervaly = firingIntervaly;
    }
}
