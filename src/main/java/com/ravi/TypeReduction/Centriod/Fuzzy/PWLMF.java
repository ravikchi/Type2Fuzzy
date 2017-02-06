package com.ravi.TypeReduction.Centriod.Fuzzy;

import com.ravi.TypeReduction.Centriod.CentriodIterMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravik on 29/01/2017.
 */
public class PWLMF extends TriangularMF {
    private double a;
    private double b;
    private double sigmaA;
    private double sigmaB;
    private double p;

    private double startUMF;
    private double mean1UMF;
    private double mean2UMF;
    private double endUMF;

    private double startLMF;
    private double mean1LMF;
    private double mean2LMF;
    private double endLMF;

    private List<Double> elements;

    private double cl=0.0;
    private double cr=0.0;

    public PWLMF(double a, double b, double sigmaA, double sigmaB, double p) {
        this.a = a;
        this.b = b;
        this.sigmaA = sigmaA;
        this.sigmaB = sigmaB;
        this.p = p;

        this.startUMF = a - (1+p) * sigmaA;
        this.mean1UMF = a- p*sigmaA;
        this.mean2UMF = b+p*sigmaB;
        this.endUMF = b + (1+p)*sigmaB;

        this.startLMF = a - (1-p)*sigmaA;
        this.mean1LMF = a+p*sigmaA;
        this.mean2LMF = b-p*sigmaB;
        this.endLMF = b+(1-p)*sigmaB;
    }

    public PWLMF(double startUMF, double mean1UMF, double mean2UMF, double endUMF, double startLMF, double mean1LMF, double mean2LMF, double endLMF) {
        this.startUMF = startUMF;
        this.mean1UMF = mean1UMF;
        this.mean2UMF = mean2UMF;
        this.endUMF = endUMF;
        this.startLMF = startLMF;
        this.mean1LMF = mean1LMF;
        this.mean2LMF = mean2LMF;
        this.endLMF = endLMF;
    }

    public double upperMemFunction(double x) {
        if(x<startUMF || x>endUMF){
            return 0;
        }

        if(x >= mean1UMF && x <= mean2UMF){
            return 1;
        }else if(x < mean1UMF){
            return (x-startUMF)/(mean1UMF-startUMF);
        }else{
            return (endUMF - x)/(endUMF-mean2UMF);
        }
    }

    public double lowerMemFunction(double x) {
        if(x<startLMF || x>endLMF){
            return 0;
        }

        if(x >= mean1LMF && x <= mean2LMF){
            return 1;
        }else if(x < mean1LMF){
            return (x-startLMF)/(mean1LMF-startLMF);
        }else{
            return (endLMF - x)/(endLMF-mean2LMF);
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
