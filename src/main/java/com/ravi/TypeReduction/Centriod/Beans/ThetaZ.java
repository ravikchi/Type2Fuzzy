package com.ravi.TypeReduction.Centriod.Beans;

/**
 * Created by rc16956 on 27/01/2017.
 */
public class ThetaZ {
    private HZ hz;
    private DeltaZ dz;
    private double thetaZ;

    public ThetaZ(HZ hz) {
        this.hz = hz;
        this.thetaZ = hz.getHi();
    }

    public ThetaZ(HZ hz, DeltaZ dz) {
        this.hz = hz;
        this.dz = dz;
    }

    public double getThetaZForStep1() {
        return hz.getHi();
    }

    public double getThetaZForCR(int z, int e) {
        if(z<=e){
            return hz.getHi() - dz.getDeltai();
        }else{
            return hz.getHi() + dz.getDeltai();
        }
    }

    public double getThetaZForCL(int z, int e) {
        if(z<=e){
            return hz.getHi() + dz.getDeltai();
        }else{
            return hz.getHi() - dz.getDeltai();
        }
    }
}
