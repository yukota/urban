package com.github.yukota.urban;

public class UrbanHome {

/**コンフィグ.*/
    
    /**駅間の距離.*/
    private double lengthOfStations;
    /**家のある範囲.*/
    private double lengthOfHomezone;
    
    /**homeの値段.*/
    private double price;
    /**家の座標.*/
    private Coord coord;
    
    
    
    /**
     * コンストラクタ
     * @param inParams
     */
    public UrbanHome(double inLengthOfStations, double inLengthofHomezone){
        this.lengthOfStations = inLengthOfStations;
        this.lengthOfHomezone = inLengthofHomezone;
        this.setupInitHomeCoord();
        price = 0;
    }
    /**
     * home初期座標を設定する
     */
    private void setupInitHomeCoord() {
        //x座標の設定
        double tmpHomeX = this.calcHomeX();
        //y座標の設定
        double tmpHomeY = this.calcHomeY();
        this.setCoord(tmpHomeX, tmpHomeY);
    }
    
    public void setCoord(double inX, double inY) {
        coord = new Coord(inX, inY);
    }
    
    private double calcHomeX(){
        //今回はBoxMullerにより外から決める
        return 0;
    }
     
    private double calcHomeY(){
        //今回はBoxMullerにより外から決める
        return 0;
    } 
    
    
    public BoxMuller getBoxMuller() {
         //乱数の取得(0から1までの値)
        double sigma = lengthOfHomezone / 5.0;
        //平均m=-L/2
        double m = -lengthOfStations / 2;
        BoxMuller boxMuller = new BoxMuller(sigma, m);
        return boxMuller;
    }
    
    public Coord getCoord(){
        return coord;
    }
}