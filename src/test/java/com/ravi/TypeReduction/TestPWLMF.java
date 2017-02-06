package com.ravi.TypeReduction;

import com.ravi.TypeReduction.Centriod.Fuzzy.MemFunc;
import com.ravi.TypeReduction.Centriod.Fuzzy.PWLMF;

/**
 * Created by ravik on 29/01/2017.
 */
public class TestPWLMF {
    public static void main(String[] armgs){
        MemFunc memFunc = new PWLMF(0,1.985,0,0.8104,0.5);

        System.out.println(memFunc.upperMemFunction(3));
        System.out.println(memFunc.lowerMemFunction(3));

        memFunc = new PWLMF(8.55,10,0.7468,0,0.5);


        System.out.println(memFunc.upperMemFunction(8.5));
        System.out.println(memFunc.lowerMemFunction(8.5));
    }
}
