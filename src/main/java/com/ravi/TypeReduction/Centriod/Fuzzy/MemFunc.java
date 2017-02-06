package com.ravi.TypeReduction.Centriod.Fuzzy;

import java.util.List;

/**
 * Created by rc16956 on 27/01/2017.
 */
public interface MemFunc {
    public double upperMemFunction(double x);
    public double lowerMemFunction(double x);
    public List<Double> getElements(int n);
    public String getUncertainVal();
    public double getUncertainValDiff();
    public double getCl();
    public double getCr();
}
