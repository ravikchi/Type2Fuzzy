package com.ravi.TypeReduction.Centriod.Beans;

/**
 * Created by rc16956 on 27/01/2017.
 */
public class DeltaZ {
    private double lowerMemFunc;
    private double upperMemFunc;
    private double deltai;

    public DeltaZ(double lowerMemFunc, double upperMemFunc) {
        this.lowerMemFunc = lowerMemFunc;
        this.upperMemFunc = upperMemFunc;
        deltai = (upperMemFunc - lowerMemFunc)/2;
    }

    public double getDeltai() {
        return deltai;
    }
}
