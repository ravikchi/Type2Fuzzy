package com.ravi.TypeReduction.Centriod.Fuzzy;

/**
 * Created by ravik on 28/01/2017.
 */
public abstract class GaussianMF  implements MemFunc{
    public double gaussianFunction(double m, double sigma, double x){
        double negNum = -1;
        double val = (negNum/2) * ((x-m)/sigma) * ((x-m)/sigma);
        return Math.exp(val);
    }
}
