package com.ravi.TypeReduction.TypeReducer;

import com.ravi.TypeReduction.Centriod.Fuzzy.MemFunc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravik on 01/02/2017.
 */
public class Rule {
    private List<MemFunc> antc = new ArrayList<MemFunc>();
    private List<MemFunc> cons = new ArrayList<MemFunc>();

    private Operator firingInterval;

    public Rule(List<MemFunc> antc, List<MemFunc> cons, Operator firingInterval) {
        this.antc.addAll(antc);
        this.cons.addAll(cons);
        this.firingInterval = firingInterval;
    }

    public Rule(Operator firingInterval) {
        this.firingInterval = firingInterval;
    }

    public void calculateFiringInterval(double x, double y){
        MemFunc memFunc = antc.get(0);
        double muux = memFunc.upperMemFunction(x);
        double mulx = memFunc.lowerMemFunction(x);

        memFunc = antc.get(1);
        double muuy = memFunc.upperMemFunction(y);
        double muly = memFunc.lowerMemFunction(y);

        firingInterval.calculateFiringInterval(mulx, muly, muux, muuy);
    }

    public Operator getFiringInterval() {
        return firingInterval;
    }

    public double getClAvgy(){
        double avg = 0.0;
        int n = 0;
        for(MemFunc memFunc: cons){
            avg = avg + memFunc.getCr();
            n++;
        }

        return avg/n;
    }

    public double getClAvgx(){
        double avg = 0.0;
        int n = 0;
        for(MemFunc memFunc: cons){
            avg = avg + memFunc.getCl();
            n++;
        }

        return avg/n;
    }
}
