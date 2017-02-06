package com.ravi.TypeReduction;

import com.ravi.TypeReduction.Centriod.CentriodIterMethod;
import com.ravi.TypeReduction.Centriod.Fuzzy.MemFunc;
import com.ravi.TypeReduction.Centriod.Fuzzy.PWLMF;
import com.ravi.TypeReduction.TypeReducer.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ravik on 01/02/2017.
 */
public class Tipping {
    public static void main(String[] args){

        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);

        /*TypeReduce rud = TypeReduce.getDummyInstance();
        System.out.println(rud.ylk() + ", " + rud.yrk());*/

        MemFunc Rancid = new PWLMF(0,1,1,5, 0,0, 0.5,4.5 );
        MemFunc Delicious = new PWLMF(4, 8, 9, 9, 4.5, 8.5, 9,9);

        MemFunc PoorService = new PWLMF(0,0,1,3,0,0,0.5,2.5);
        MemFunc GoodService = new PWLMF(1,3,5,7, 1.5,3.5, 4.5,6.5);
        MemFunc ExcellentService = new PWLMF(5,7,9,9,5.5,7.5,9,9);

        MemFunc CheapTip = new PWLMF(0, 6, 6, 12, 2,6,6,10);
        MemFunc AverageTip = new PWLMF(10,15,15,20, 12,15,15,18);
        MemFunc GenerousTip = new PWLMF(18,24,24,30, 20,24,24,28);

        List<MemFunc> antc = new ArrayList<MemFunc>();
        List<MemFunc> cons = new ArrayList<MemFunc>();

        List<Rule> ruleList = new ArrayList<Rule>();

        antc.add(Rancid); antc.add(PoorService); cons.add(CheapTip);
        ruleList.add(new Rule(antc, cons,new ProductTnorm()));
        antc.clear(); cons.clear();

        antc.add(Rancid); antc.add(GoodService); cons.add(CheapTip);
        ruleList.add(new Rule(antc, cons,new ProductTnorm()));
        antc.clear(); cons.clear();

        antc.add(Rancid); antc.add(ExcellentService); cons.add(AverageTip);
        ruleList.add(new Rule(antc, cons,new ProductTnorm()));
        antc.clear(); cons.clear();

        antc.add(Delicious); antc.add(PoorService); cons.add(AverageTip);
        ruleList.add(new Rule(antc, cons,new ProductTnorm()));
        antc.clear(); cons.clear();

        antc.add(Delicious); antc.add(GoodService); cons.add(AverageTip);
        ruleList.add(new Rule(antc, cons,new ProductTnorm()));
        antc.clear(); cons.clear();

        antc.add(Delicious); antc.add(ExcellentService); cons.add(GenerousTip);
        ruleList.add(new Rule(antc, cons,new ProductTnorm()));
        antc.clear(); cons.clear();

        Tipping tipping = new Tipping();
        System.out.println(tipping.findTip(ruleList, x, y));

        x = 9.0;
        y = 6.0;
        System.out.println(tipping.findTip(ruleList, x, y));

        x = 4.0;
        y = 2.5;
        System.out.println(tipping.findTip(ruleList, x, y));

    }

    public double findTip(List<Rule> ruleList, double x, double y){
        for(Rule rule : ruleList){
            rule.calculateFiringInterval(x, y);
        }

        TypeReduce reducer = new TypeReduce(ruleList);

        return (reducer.ylk() + reducer.yrk())/2;
    }
}
