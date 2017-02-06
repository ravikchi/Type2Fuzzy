package com.ravi.TypeReduction.Centriod.Beans;

/**
 * Created by rc16956 on 27/01/2017.
 */
public class HZ {
    private double lowerMemFunc;
    private double upperMemFunc;
    private double hi;

    public HZ(double lowerMemFunc, double upperMemFunc) {
        this.lowerMemFunc = lowerMemFunc;
        this.upperMemFunc = upperMemFunc;
        hi = (lowerMemFunc + upperMemFunc)/2;
    }

    public double getHi() {
        return hi;
    }
}
