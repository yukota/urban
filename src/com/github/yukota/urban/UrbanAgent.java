package com.github.yukota.urban;


/**
 * UrbanAgent.
 */
public class UrbanAgent {
    /**エージェントの位置.*/
    private Coord coord;
    /**エージェントの偏行:しんどさ.*/
    private double fatigueRate;
    /**エージェントの偏行:所持金.*/
    private double usableMoney;
    /**エージェントの偏行:時間.*/
    private double usableTime;
    /**トリップ.*/
    private Goals[] route;
    private int currentPlace;
    /**移動時間.*/
    private double transferTime;
    /**移動距離_車.*/
    private double distanceByCar;
    /**移動距離_歩行.*/
    private double distanceByWalk;
    /**移動距離_自転車.*/
    private double distanceByBike;
    /**移動距離_電車.*/
    private double distanceByTrain;
    /**移動距離費用.*/
    private double transferCost;
    /**疲れ.*/
    private double fatigue;
    /**会社*/
    private UrbanCompany company;
    /**駐車場*/
    private int parking;
    private int bikelot;
    
    
    /**
     * コンストラクタ
     * @param inParams
     */
    public UrbanAgent(Coord homeCoord,UrbanCompany initCompany, Goals[] initRoute){
        //開始地点は家
        this.coord = homeCoord;
        this.company = initCompany;
        //初期ルートの設定
        this.route = initRoute;
        this.currentPlace = 0;
        //偏光の決定
        this.setupStatus();
        //トリップの割り当て
        }
    
    /**
     * 偏向を決定する
     */
    private void setupStatus() {
        int tempFatigureRate = 20 + (int) Math.random()*30;
        int tempUsableMoney = 20 + (int) Math.random()*30;
        int tempUsableTime = 100 - tempFatigureRate - tempUsableMoney;
        
        fatigueRate = (double) tempFatigureRate / 100;
        usableMoney = (double) tempUsableMoney / 100;
        usableTime = (double) tempUsableTime / 100;
    }
    
    public Coord getCoord(){
        return this.coord;
    }

    public Goals getCurrentPlace(){
        return route[currentPlace];
    }
    
    public Coord getCoordOfCompany(){
        return company.getCoord();
    }
    
    /**
     * パラメタを初期化する
     */
    public void reset(Coord initCoord) {
        //家の設定
        this.coord = initCoord;
        
        this.transferTime = 0;
        this.fatigue = 0;
        this.transferCost = 0;
        this.distanceByCar = 0;
        this.distanceByWalk = 0;
        this.distanceByBike = 0;
        this.distanceByTrain = 0;
        
        this.parking = 0;
        this.bikelot = 0;
    }

    public void setNextSpot() {
        currentPlace++;
    }

    public void setCoord(Coord nextCoord) {
        this.coord = nextCoord;
        
    }
    
       
    
}
