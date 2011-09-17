package com.github.yukota.urban;

/**
 * 駐車場のsuperクラス
 * @author YuK_Ota
 *
 */
public class Parking {
    private Coord coord;
    private double lengthOfStations;
    private double lengthOfParking;


    public Parking(double inLengthOfStations, double inLengthOfParking) {
        this.lengthOfStations = inLengthOfStations;
        this.lengthOfParking = inLengthOfParking;
    }

    public void setCoord (double inX,double inY) {
        this.coord = new Coord(inX, inY);
    }
    
    public Coord getCoord() {
        return coord;
    }

    
    public BoxMuller getBoxMuller() {
        double sigma = lengthOfParking / 5.0;
        //平均m=-L/2
        double m = -lengthOfStations / 2;
        BoxMuller boxMuller = new BoxMuller(sigma, m);
        return boxMuller;
    }

}
