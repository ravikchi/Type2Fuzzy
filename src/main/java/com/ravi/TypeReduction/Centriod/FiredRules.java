package com.ravi.TypeReduction.Centriod;

import com.ravi.TypeReduction.Centriod.Fuzzy.MemFunc;
import com.ravi.TypeReduction.Centriod.Fuzzy.PWLMF;
import com.ravi.TypeReduction.Centriod.Fuzzy.TriangularInteriorMF;

/**
 * Created by ravik on 29/01/2017.
 */
public class FiredRules {
    public static void main(String[] armg){
        MemFunc NVL = new PWLMF(0,1.985,0,0.8104,0.5);
        MemFunc S = new TriangularInteriorMF(2.5433,5.25,0.9066	,1.3693, 0.5);
        MemFunc MOA = new TriangularInteriorMF(3.6433,6.4567,0.8842,0.8557, 0.5);
        MemFunc LA = new TriangularInteriorMF(6.4833,8.75	,0.7484,0.5981,0.5);
        MemFunc MAA = new PWLMF(8.55,10,0.7468,0,0.5);

        double nvly3 = NVL.upperMemFunction(3);
        double nvlx3 =NVL.lowerMemFunction(3);

        double sx3 = S.lowerMemFunction(3);
        double sy3 = S.upperMemFunction(3);

        double moax3 = MOA.lowerMemFunction(3);
        double moay3 = MOA.upperMemFunction(3);

        double lay6 = LA.upperMemFunction(6);
        double lax6 =LA.lowerMemFunction(6);

        double sx6 = S.lowerMemFunction(6);
        double sy6 = S.upperMemFunction(6);

        double moax6 = MOA.lowerMemFunction(6);
        double moay6 = MOA.upperMemFunction(6);

        System.out.println("NVL/S " + "["+nvlx3+","+nvly3+"]/["+sx3+","+sy3+"]  "+ "["+0+","+0+"]/["+sx6+","+sy6+"]");
        System.out.println("NVL/MOA " + "["+nvlx3+","+nvly3+"]/["+moax3+","+moay3+"]  "+ "["+0+","+0+"]/["+moax6+","+moay6+"]");
        System.out.println("NVL/LA " + "["+nvlx3+","+nvly3+"]/["+0+","+0+"]  "+ "["+0+","+0+"]/["+lax6+","+lay6+"]");

        System.out.println("S/S " + "["+sx3+","+sy3+"]/["+sx3+","+sy3+"]  "+ "["+sx6+","+sy6+"]/["+sx6+","+sy6+"]");
        System.out.println("S/MOA " + "["+sx3+","+sy3+"]/["+moax3+","+moay3+"]  "+ "["+sx6+","+sy6+"]/["+moax6+","+moay6+"]");
        System.out.println("S/LA " + "["+sx3+","+sy3+"]/["+0+","+0+"]  "+ "["+sx6+","+sy6+"]/["+lax6+","+lay6+"]");
    }
}
