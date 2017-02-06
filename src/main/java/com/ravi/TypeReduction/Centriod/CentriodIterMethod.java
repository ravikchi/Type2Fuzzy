package com.ravi.TypeReduction.Centriod;

import com.ravi.TypeReduction.Centriod.Beans.DeltaZ;
import com.ravi.TypeReduction.Centriod.Beans.HZ;
import com.ravi.TypeReduction.Centriod.Beans.ThetaZ;
import com.ravi.TypeReduction.Centriod.Fuzzy.MemFunc;

/**
 * Created by rc16956 on 27/01/2017.
 */
public class CentriodIterMethod {
    private int n;

    private static CentriodIterMethod instance = null;

    protected CentriodIterMethod(int n) {
        this.n = n;
    }

    public static CentriodIterMethod getInstance(){
        if(instance == null){
            instance = new CentriodIterMethod(10000);
        }

        return instance;
    }

    public double getCl(MemFunc memFunc){
        double yQuote = step1(memFunc);//Step 1

        boolean test = true;
        while(test) {
            int e = findE(memFunc, yQuote);//Step 2
            double yQQ = step3ForCl(memFunc,e);//Step 3

            if(yQQ == yQuote) {//Step 4
                test = false;
            }else
                yQuote = yQQ;//Step 5 and Repeat
        }

        return yQuote;
    }

    public double getCr(MemFunc memFunc){
        double yQuote = step1(memFunc);

        boolean test = true;
        while(test) {
            int e = findE(memFunc, yQuote);
            double yQQ = step3ForCr(memFunc,e);

            if(yQQ == yQuote) {
                test = false;
            }else
                yQuote = yQQ;
        }

        return yQuote;
    }

    private double step1(MemFunc memFunc){
        double num = 0.0;
        double den = 0.0;

        for(double yi : memFunc.getElements(n)){
            HZ hi = new HZ(memFunc.lowerMemFunction(yi), memFunc.upperMemFunction(yi));
            ThetaZ thetai = new ThetaZ(hi);
            num = num + yi * thetai.getThetaZForStep1();
            den = den + thetai.getThetaZForStep1();
        }

        return num/den;
    }

    private int findE(MemFunc memFunc, double yQuote){
        double ye = 1.0;
        int yeCount = 1;
        for(double yi : memFunc.getElements(n)){
            if(yQuote < yi && yQuote < memFunc.getElements(n).get(yeCount)){
                ye = yi;
                break;
            }
            yeCount++;
        }
        return yeCount;
    }

    private double step3ForCl(MemFunc memFunc, int e){
        double num = 0.0;
        double den = 0.0;

        int z=1;
        for(double yi : memFunc.getElements(n)){
            HZ hi = new HZ(memFunc.lowerMemFunction(yi), memFunc.upperMemFunction(yi));
            DeltaZ deltai = new DeltaZ(memFunc.lowerMemFunction(yi), memFunc.upperMemFunction(yi));
            ThetaZ thetai = new ThetaZ(hi,deltai);
            num = num + yi * thetai.getThetaZForCL(z,e);
            den = den + thetai.getThetaZForCL(z,e);
            z++;
        }

        return num/den;
    }

    private double step3ForCr(MemFunc memFunc, int e){
        double num = 0.0;
        double den = 0.0;

        int z=1;
        for(double yi : memFunc.getElements(n)){
            HZ hi = new HZ(memFunc.lowerMemFunction(yi), memFunc.upperMemFunction(yi));
            DeltaZ deltai = new DeltaZ(memFunc.lowerMemFunction(yi), memFunc.upperMemFunction(yi));
            ThetaZ thetai = new ThetaZ(hi,deltai);
            num = num + yi * thetai.getThetaZForCR(z,e);
            den = den + thetai.getThetaZForCR(z,e);
            z++;
        }

        return num/den;
    }
}
