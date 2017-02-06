package com.ravi.TypeReduction.TypeReducer;

import java.util.*;

/**
 * Created by ravik on 29/01/2017.
 */
public class TypeReduce {
    private Map<Double, Rule> ruleMapy;
    private Map<Double, Rule> ruleMapx;
    private List<Double> yrk;
    private List<Double> ylk;

    public TypeReduce(List<Rule> ruleList){
        ruleMapx = new HashMap<Double, Rule>();
        ruleMapy = new HashMap<Double, Rule>();

        yrk = new ArrayList<Double>();
        ylk = new ArrayList<Double>();

        double addValue = 0.0000000001;
        int count = 0;
        for(Rule rule : ruleList){
            ruleMapx.put(rule.getClAvgx()+addValue*count, rule);
            ruleMapy.put(rule.getClAvgy()+addValue*count, rule);

            System.out.println((rule.getClAvgx()+(addValue*count)) + " "+ (rule.getClAvgy()+(addValue*count)) + ", is "+rule.getFiringInterval().getFiringIntervalx() + ","+rule.getFiringInterval().getFiringIntervaly());
            count++;
        }

        yrk.addAll(ruleMapy.keySet());
        Collections.sort(yrk);

        ylk.addAll(ruleMapx.keySet());
        Collections.sort(ylk);
    }

    public static TypeReduce getDummyInstance(){

        Map<Double, Rule> ruleMapy = new HashMap<Double, Rule>();
        Map<Double, Rule> ruleMapx = new HashMap<Double, Rule>();

        /*RuleRow ruleRow = new RuleRow("NVL/NVL", 38, 7, 2, 0,0,1.5420, 2.0043);
        ruleRow.setFiringInterval(new ProductTnorm(0, 0.2475, 0, 0.3827, 0, 0.0947));
        ruleMapy.put(ruleRow.getClAvgy(), ruleRow);
        ruleMapx.put(ruleRow.getClAvgx(), ruleRow);
*/
            //RuleRow ruleRow = new RuleRow("NVL/S", 33, 11, 3, 0,0,1.8512, 2.3479);
        Operator firingInterval = new ProductTnorm();
        firingInterval.setFiringInterval(0, 0.0947);
        Rule ruleRow = new Rule(firingInterval);
            //ruleRow.setFiringInterval();
        ruleMapy.put(ruleRow.getClAvgy(), ruleRow);
        ruleMapx.put(ruleRow.getClAvgx(), ruleRow);

        firingInterval = new ProductTnorm();
        firingInterval.setFiringInterval( 0, 0.1601);
        //ruleRow = new Rule(new ProductTnorm(0, 0.2475, 0.4822, 0.6469,));
        ruleRow = new Rule(firingInterval);
            ruleMapy.put(ruleRow.getClAvgy(), ruleRow);
            ruleMapx.put(ruleRow.getClAvgx(), ruleRow);

            //ruleRow = new Rule(new ProductTnorm(0, 0.2475, 0, 0.2834, 0, 0.0701));
        firingInterval = new ProductTnorm();
        firingInterval.setFiringInterval(  0, 0.0701);
        ruleRow = new Rule(firingInterval);
            ruleMapy.put(ruleRow.getClAvgy(), ruleRow);
            ruleMapx.put(ruleRow.getClAvgx(), ruleRow);

        /*ruleRow = new RuleRow("NVL/LA", 0, 12, 26, 4,0,5.0045, 5.6046);
        ruleRow.setFiringInterval(new ProductTnorm(0, 0.2475, 0, 0.3827, 0, 0.0947));
        ruleMap.put(ruleRow.getClAvgy(), ruleRow);
*/
            //ruleRow = new Rule(new ProductTnorm(0.5037, 0.6695, 0, 0.3827, 0, 0.2562));
        firingInterval = new ProductTnorm();
        firingInterval.setFiringInterval(   0, 0.2562);
        ruleRow = new Rule(firingInterval);
            ruleMapy.put(ruleRow.getClAvgy(), ruleRow);
            ruleMapx.put(ruleRow.getClAvgx(), ruleRow);

            //ruleRow = new Rule(new ProductTnorm(0.5037, 0.6695, 0.4822, 0.6469, 0.2429, 0.4331));
        firingInterval = new ProductTnorm();
        firingInterval.setFiringInterval(   0.2429, 0.4331);
        ruleRow = new Rule(firingInterval);
            ruleMapy.put(ruleRow.getClAvgy(), ruleRow);
            ruleMapx.put(ruleRow.getClAvgx(), ruleRow);

            //ruleRow = new Rule(new ProductTnorm(0.5037, 0.6695, 0, 0.2834, 0, 0.1897));
        firingInterval = new ProductTnorm();
        firingInterval.setFiringInterval(   0, 0.1897);
        ruleRow = new Rule(firingInterval);
            ruleMapy.put(ruleRow.getClAvgy(), ruleRow);
            ruleMapx.put(ruleRow.getClAvgx(), ruleRow);

            //ruleRow = new Rule(new ProductTnorm(0, 0.2499, 0, 0.3827, 0, 0.0956));
        firingInterval = new ProductTnorm();
        firingInterval.setFiringInterval(   0, 0.0956);
        ruleRow = new Rule(firingInterval);
            ruleMapy.put(ruleRow.getClAvgy(), ruleRow);
            ruleMapx.put(ruleRow.getClAvgx(), ruleRow);

            //ruleRow = new Rule(new ProductTnorm(0, 0.2499, 0.4822, 0.6469, 0, 0.1617));
        firingInterval = new ProductTnorm();
        firingInterval.setFiringInterval(    0, 0.1617);
        ruleRow = new Rule(firingInterval);
            ruleMapy.put(ruleRow.getClAvgy(), ruleRow);
            ruleMapx.put(ruleRow.getClAvgx(), ruleRow);

            //ruleRow = new Rule(new ProductTnorm(0, 0.2499, 0, 0.2834, 0, 0.0708));
        firingInterval = new ProductTnorm();
        firingInterval.setFiringInterval(   0, 0.0708);
        ruleRow = new Rule(firingInterval);
            ruleMapy.put(ruleRow.getClAvgy(), ruleRow);
            ruleMapx.put(ruleRow.getClAvgx(), ruleRow);

            List<Double> yrk = new ArrayList<Double>();
            yrk.addAll(ruleMapy.keySet());

            List<Double> ylk = new ArrayList<Double>();
            ylk.addAll(ruleMapx.keySet());

            Collections.sort(yrk);
            Collections.sort(ylk);

            return new TypeReduce(ruleMapy, ruleMapx, yrk, ylk);

    }

    private TypeReduce(Map<Double, Rule> ruleMapy, Map<Double, Rule> ruleMapx, List<Double> yrk, List<Double> ylk) {
        this.ruleMapy = ruleMapy;
        this.ruleMapx = ruleMapx;
        this.yrk = yrk;
        this.ylk = ylk;
    }

    public double ylk(){
        double ylkQuote = step1(ylk, ruleMapx);

        boolean test = true;
        while(test) {
            int R = findR(ylk, ylkQuote);

            double ylkDQuote = step3l(ylk, ruleMapx, R);

            if(Math.abs(ylkQuote - ylkDQuote) < 0.000000001){
                test = false;
                break;
            }else{
                ylkQuote = ylkDQuote;
            }
        }

        return ylkQuote;
    }

    public double yrk(){
        double yrkQuote = step1(yrk, ruleMapy);

        boolean test = true;
        while(test) {
            int R = findR(yrk, yrkQuote);

            double yrkDQuote = step3(yrk, ruleMapy, R);

            if(Math.abs(yrkQuote -yrkDQuote)<0.000000001){
                test = false;
                break;
            }else{
                yrkQuote = yrkDQuote;
            }
        }

        return yrkQuote;
    }

    public double step3(List<Double> yrk, Map<Double, Rule> ruleMap, int R){
        double num=0.0;
        double den=0.0;

        int count=1;
        for(double yi:yrk){
            if(yi == 0){
                continue;
            }
            Rule ruleRow = ruleMap.get(yi);

            double fri = 0.0;
            if(count<=R){
                fri = ruleRow.getFiringInterval().getFiringIntervalx();
            }else{
                fri = ruleRow.getFiringInterval().getFiringIntervaly();
            }

            num = num + fri * yi;
            den = den + fri;

            count++;
        }

        return num/den;
    }

    public double step3l(List<Double> ylk, Map<Double, Rule> ruleMap, int R){
        double num=0.0;
        double den=0.0;

        int count=1;
        for(double yi:ylk){
            if(yi == 0){
                continue;
            }
            Rule ruleRow = ruleMap.get(yi);

            double fli = 0.0;
            if(count<=R){
                fli = ruleRow.getFiringInterval().getFiringIntervaly();
            }else{
                fli = ruleRow.getFiringInterval().getFiringIntervalx();
            }

            num = num + fli * yi;
            den = den + fli;

            count++;
        }

        return num/den;
    }


    public double step1(List<Double> yrk, Map<Double, Rule> ruleMap){
        double num = 0.0;
        double den = 0.0;

        for(double yi:yrk){
            if(yi == 0){
                continue;
            }
            Rule ruleRow = ruleMap.get(yi);
            double fri = (ruleRow.getFiringInterval().getFiringIntervalx() + ruleRow.getFiringInterval().getFiringIntervaly())/2;
            double yrki = yi;

            num = num + fri * yrki;
            den = den + fri;
        }
        return num/den;
    }

    public int findR(List<Double> yk, double yrkQuote){
        if(yk.size() == 1){
            return 1;
        }

        int R=1;
        for(double yi:yk){
            if(yi<yrkQuote && yk.get(R)>yrkQuote){
                break;
            }
            R++;
        }

        return R;
    }
}
