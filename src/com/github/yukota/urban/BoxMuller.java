package com.github.yukota.urban;

public class BoxMuller {
    private double resultCos;
    private double resultSin;
    
    private double sigma;
    private double m;
    public BoxMuller(double inSigma, double inM) {
        this.sigma = inSigma;
        this.m = inM;
        this.calcBoxMuller();
        
        
    }
    
    private void calcBoxMuller(){
        double randomNum1 = Math.random();
        double randomNum2 = Math.random();
        resultSin = (int)(sigma * Math.sqrt(-2.0 * Math.log(randomNum1)) * Math.sin(2.0*Math.PI * randomNum2) +m );
        resultCos = (int)(sigma * Math.sqrt(-2.0 * Math.log(randomNum1)) * Math.cos(2.0*Math.PI * randomNum2) +m );
    }
    
    public double getResultCos(){
        return resultCos;
    }
    
    public double getResultSin(){
        return resultSin;
    }

}
