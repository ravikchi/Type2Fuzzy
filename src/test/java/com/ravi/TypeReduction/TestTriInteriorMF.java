package com.ravi.TypeReduction;

import com.ravi.TypeReduction.Centriod.Fuzzy.MemFunc;
import com.ravi.TypeReduction.Centriod.Fuzzy.TriangularInteriorMF;

/**
 * Created by ravik on 29/01/2017.
 */
public class TestTriInteriorMF {
    public static void main(String[] args){
        MemFunc memFunc = new TriangularInteriorMF(2.5433,5.25,0.9066	,1.3693, 0.5);

        System.out.println(memFunc.upperMemFunction(3));
        System.out.println(memFunc.lowerMemFunction(3));

        memFunc = new TriangularInteriorMF(3.6433,6.4567,0.8842,0.8557, 0.5);

        System.out.println(memFunc.upperMemFunction(3));
        System.out.println(memFunc.lowerMemFunction(3));
    }
}
