package com.ravi.TypeReduction.Utils;

/**
 * Created by rc16956 on 27/01/2017.
 */
public class Formatter {
    private int truncPoint;

    public Formatter(int truncPoint) {
        this.truncPoint = truncPoint;
    }

    public double format(double x){
        String val = x+"";
        int endIndex = val.indexOf('.');
        if(val.length() > endIndex+truncPoint) {
            return Double.parseDouble(val.substring(0, endIndex + truncPoint+1));
        }else{
            return x;
        }
    }
}
