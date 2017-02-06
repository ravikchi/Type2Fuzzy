package com.ravi.TypeReduction.Centriod.Fuzzy;

import com.ravi.TypeReduction.Centriod.CentriodIterMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rc16956 on 27/01/2017.
 */
public class UncertainStdDeviation extends GaussianMF {
    private double m;
    private double sigma1;
    private double sigma2;
    private List<Double> elements;

    private double cl = 0.0;
    private double cr = 0.0;

    public UncertainStdDeviation(double m, double sigma1, double sigma2) {
        this.m = m;
        this.sigma1 = sigma1;
        this.sigma2 = sigma2;
    }

    public double upperMemFunction(double x) {
        return gaussianFunction(m,sigma2,x);
    }

    public double lowerMemFunction(double x) {
        return gaussianFunction(m,sigma1,x);
    }

    public List<Double> getElements(int n) {
        if(elements == null) {
            double sigma = (sigma1 + sigma2) / 2;
            double start = m - sigma * 5;
            double end = m + sigma * 5;
            double inc = (end - start) / (n - 1);

            elements = new ArrayList<Double>();
            for (double i = start; i <= end; i = i + inc) {
                elements.add(i);
            }
        }
        return elements;
    }

    public String getUncertainVal() {
        return "["+sigma1+","+sigma2+"]";
    }

    public double getUncertainValDiff() {
        return sigma2-sigma1;
    }

    public double getCl() {
        if(cl == 0.0) {
            cl = CentriodIterMethod.getInstance().getCl(this);
        }

        return cl;
    }

    public double getCr() {
        if(cr == 0.0)
            cr = CentriodIterMethod.getInstance().getCr(this);

        return cr;
    }
}
