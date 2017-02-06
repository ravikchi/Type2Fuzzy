package com.ravi.TypeReduction.Centriod.Fuzzy;

import com.ravi.TypeReduction.Centriod.CentriodIterMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravik on 29/01/2017.
 */
public class TriangularInteriorMF extends TriangularMF {

    private double a;
    private double b;
    private double sigmaA;
    private double sigmaB;
    private double p;

    private double startUMF;
    private double meanUMF;
    private double endUMF;

    private double startLMF;
    private double meanLMF;
    private double endLMF;

    private List<Double> elements;

    private double cl = 0.0;
    private double cr = 0.0;

    public TriangularInteriorMF(double a, double b, double sigmaA, double sigmaB, double p) {
        this.a = a;
        this.b = b;
        this.sigmaA = sigmaA;
        this.sigmaB = sigmaB;
        this.p = p;

        this.startUMF = a - (1+p) * sigmaA;
        this.meanUMF = (a+b)/2;
        this.endUMF = b + (1+p)*sigmaB;

        this.startLMF = a - (1-p)*sigmaA;
        this.meanLMF = (a+b)/2;
        this.endLMF = b+(1-p)*sigmaB;
    }

    public double upperMemFunction(double x) {
        if(x<=startUMF || x>=endUMF){
            return 0;
        }

        if(x == meanUMF){
            return 1;
        }else if(x < meanUMF){
            return (x-startUMF)/(meanUMF-startUMF);
        }else{
            return (endUMF - x)/(endUMF-meanUMF);
        }
    }

    public double lowerMemFunction(double x) {
        if(x<=startLMF || x>=endLMF){
            return 0;
        }

        if(x == meanLMF){
            return 1;
        }else if(x < meanLMF){
            return (x-startLMF)/(meanLMF-startLMF);
        }else{
            return (endLMF - x)/(endLMF-meanLMF);
        }
    }

    public List<Double> getElements(int n) {
        if(elements == null){
            elements = new ArrayList<Double>();

            double start = Math.min(startLMF, startUMF);
            double end = Math.max(endLMF, endUMF);

            double inc = (start + end)/(n-1);

            for(double i = start; i<=end; i = i + inc){
                elements.add(i);
            }
        }

        return elements;
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

