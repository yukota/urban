package com.github.yukota.urban;

public class UrbanCompany {
    /**会社座標.*/
    private Coord companyCoord;
    
    /**会社の存在する半径.*/
    private double lengthOfBusinesszone;
    /**駅の距離.*/
    private double lengthOfStations;
    
    public UrbanCompany(double inLengthOfStations, double inLengthOfBusinesszone){
        this.lengthOfStations = inLengthOfStations;
        this.lengthOfBusinesszone = inLengthOfBusinesszone;
        
        this.setupInitCompanyCoord();
    }
    
    private void setupInitCompanyCoord() {
        this.setCoord(0, 0);
    }
    public void setCoord(double inX, double inY) {
        companyCoord = new Coord(inX, inY);
    }
    public Coord getCoord(){
        return companyCoord;
    }
     
    public BoxMuller getBoxMuller() {
         //乱数の取得(0から1までの値)
        double sigma = lengthOfBusinesszone / 5.0;
        //平均m=-L/2
        double m = -lengthOfStations / 2;
        BoxMuller boxMuller = new BoxMuller(sigma, m);
        return boxMuller;
    }
}

