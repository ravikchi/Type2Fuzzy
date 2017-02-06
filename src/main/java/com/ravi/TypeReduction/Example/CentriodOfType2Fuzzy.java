 package com.ravi.TypeReduction.Example;

 import com.ravi.TypeReduction.Centriod.CentriodIterMethod;
 import com.ravi.TypeReduction.Centriod.Fuzzy.MemFunc;
 import com.ravi.TypeReduction.Centriod.Fuzzy.UncertainMean;
 import com.ravi.TypeReduction.Centriod.Fuzzy.UncertainStdDeviation;

 import java.text.DecimalFormat;
 import java.util.ArrayList;
 import java.util.List;

 /**
 * Hello world!
 *
 */
public class CentriodOfType2Fuzzy
{
    public static void main( String[] args )
    {
        List<MemFunc> uncertainMeanList = new ArrayList<MemFunc>();
        uncertainMeanList.add(new UncertainMean(5,5, 1.0));
        uncertainMeanList.add(new UncertainMean(4.875,5.125, 1.0));
        uncertainMeanList.add(new UncertainMean(4.75, 5.25, 1.0));
        uncertainMeanList.add(new UncertainMean(4.625, 5.375, 1.0));
        uncertainMeanList.add(new UncertainMean(4.5, 5.5, 1.0));
        uncertainMeanList.add(new UncertainMean(4.25,5.75, 1.0));
        uncertainMeanList.add(new UncertainMean(4, 6, 1.0));
        uncertainMeanList.add(new UncertainMean(3.75, 6.25, 1.0));
        uncertainMeanList.add(new UncertainMean(3.5, 6.5, 1.0));

        System.out.format("%-20s%-15s%-20s%-10s", "[m1,m2]", "m2-m1", "[cl,cr]", "cr-cl");
        System.out.println();

        calculateCentriod(uncertainMeanList);


        List<MemFunc> uncertainStdDevList = new ArrayList<MemFunc>();
        uncertainStdDevList.add(new UncertainStdDeviation(5,1.0, 1.0));
        uncertainStdDevList.add(new UncertainStdDeviation(5,0.875, 1.125));
        uncertainStdDevList.add(new UncertainStdDeviation(5, 0.75, 1.25));
        uncertainStdDevList.add(new UncertainStdDeviation(5, 0.625, 1.375));
        uncertainStdDevList.add(new UncertainStdDeviation(5, 0.5, 1.5));
        uncertainStdDevList.add(new UncertainStdDeviation(5,0.375, 1.625));
        uncertainStdDevList.add(new UncertainStdDeviation(5, 0.25,1.75));

        System.out.println();System.out.println();

        System.out.format("%-20s%-15s%-20s%-10s", "[sigma1,sigma2]", "sigma2-sigma1", "[cl,cr]", "cr-cl");
        System.out.println();
        calculateCentriod(uncertainStdDevList);
    }

    public static void calculateCentriod(List<MemFunc> valueList){
        CentriodIterMethod iterMethod = CentriodIterMethod.getInstance();
        for(MemFunc memFunc : valueList) {

            DecimalFormat df = new DecimalFormat("#.####");


            double cl = memFunc.getCl();
            double cr = memFunc.getCr();

            System.out.format("%-20s%-15s%-20s%-10s", memFunc.getUncertainVal(), memFunc.getUncertainValDiff()+"", "["+df.format(cl)+","+df.format(cr)+"]", df.format(cr-cl));
            System.out.println();
        }
    }
}
