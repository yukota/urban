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
    private Route route;
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
    public UrbanAgent(Coord homeCoord,UrbanCompany initCompany, Route initRoute){
        //開始地点は家
        this.coord = homeCoord;
        this.company = initCompany;
        //初期ルートの設定
        this.route = initRoute;
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
    
    
       
    
}
