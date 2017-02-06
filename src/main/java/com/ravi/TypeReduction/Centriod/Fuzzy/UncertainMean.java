package com.ravi.TypeReduction.Centriod.Fuzzy;

import com.ravi.TypeReduction.Centriod.CentriodIterMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rc16956 on 27/01/2017.
 */
public class UncertainMean extends GaussianMF {
    private double m1;
    private double m2;
    private double sigma;
    private List<Double> elements;

    private double cl = 0.0;
    private double cr = 0.0;

    public UncertainMean(double m1, double m2, double sigma) {
        this.m1 = m1;
        this.m2 = m2;
        this.sigma = sigma;
    }

    public double upperMemFunction(double x) {
        if(x<m1)
            return gaussianFunction(m1,sigma,x);
        else if(x>m2)
            return gaussianFunction(m2,sigma,x);
        else if(x>=m1 && x<=m2)
            return 1.0;

        return 0.0;
    }

    public double lowerMemFunction(double x) {
        if((m1+m2)/2 >= x)
            return gaussianFunction(m2, sigma, x);
        else
            return gaussianFunction(m1, sigma, x);
    }

    public List<Double> getElements(int n) {
        if(elements == null) {
            double start = m1 - sigma * 4;
            double end = m2 + sigma * 4;
            double inc = (end - start) / (n - 1);

            elements = new ArrayList<Double>();
            for (double i = start; i <= end; i = i + inc) {
                elements.add(i);
            }
        }

        return elements;
    }

    public String getUncertainVal() {
        return "["+m1+","+m2+"]";
    }

    public double getUncertainValDiff() {
        return m2-m1;
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
