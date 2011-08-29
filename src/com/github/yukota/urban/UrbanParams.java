package com.github.yukota.urban;

/**
 * UrabanPrams.
 * 各パラメタを記述する
 * @author YuK_Ota
 *
 */
public class UrbanParams {
    /**描写空間の横幅.*/
    static private double WORLD_WIDTH = 5000;
    /**描写空間の高さ.*/
    static private double WORLD_HEIGHT = 5000;
    
    /**2駅間の距離.*/
    static private double LENGTH_OF_STATIONS = 4000.0;
    /**home zoneの半径.*/
    static private double LENGTH_OF_HOMEZONE = 3200.0;
    /**home zoneの中心.*/
    static private Coord CENTER_OF_HOMEZONE = new Coord(-LENGTH_OF_STATIONS / 2, -WORLD_HEIGHT/2);
    
    /**business zoneの半径.*/
    static private double LENGTH_OF_BUSINESSZONE = 3200.0;
    
    /**エージェントの数.*/
    static private int AGENT_NUM = 10000;
    
    /**家の数.*/
    static private int HOME_NUM = 10000;
    
    /**駐車場の数.*/
    static private int PARKING_NUM = 1000;
    /**駐輪場の数.*/
    static private int BIKELOT_NUM = 1000;
    
    /**unit_tripの数.*/
    private TripMethods tripMethod[] = {TripMethods.WALK,
                                        TripMethods.WALK,
                                        TripMethods.BIKE,
                                        TripMethods.BIKE,
                                        TripMethods.BIKE,
                                        TripMethods.CAR,
                                        TripMethods.CAR,
                                        TripMethods.CAR,
                                        TripMethods.CAR_H,
                                        TripMethods.TRAIN,
                                        TripMethods.BIKE
                                        };
    
     private Goals goal_id[] = {Goals.STATION_A,
                                Goals.COMPANY,
                                Goals.STATION_A,
                                Goals.COMPANY,
                                Goals.BIKE_LOT,
                                Goals.COMPANY,
                                Goals.HIGHWAY_S,
                                Goals.PARKING,
                                Goals.HIGHWAY_E,
                                Goals.STATION_B,
                                Goals.STATION_LOT
                                };
     /**ルート.*/
     private RouteLandmark[][] routeLandmark = {
                                                {RouteLandmark.W_STATION_A,RouteLandmark.T_STATION_B,RouteLandmark.W_COMPANY,RouteLandmark.END},
                                                {RouteLandmark.B_STATION_LOT,RouteLandmark.T_STATION_B,RouteLandmark.W_COMPANY,RouteLandmark.END},
                                                {RouteLandmark.W_COMPANY,RouteLandmark.END},
                                                {RouteLandmark.C_PARKING,RouteLandmark.W_COMPANY,RouteLandmark.END},
                                                {RouteLandmark.B_BIKE_LOT,RouteLandmark.W_COMPANY,RouteLandmark.END},
                                                {RouteLandmark.C_HIGHWAY_S,RouteLandmark.C_HIGHWAY_E,RouteLandmark.C_PARKING,RouteLandmark.END},
                                                {RouteLandmark.W_COMPANY,RouteLandmark.END},
                                                {RouteLandmark.B_COMPANY,RouteLandmark.END},    /////違法駐輪
                                                {RouteLandmark.B_STATION_A,RouteLandmark.T_STATION_B,RouteLandmark.W_COMPANY,RouteLandmark.END}
                                                };
     
        
     /**会社の数.*/
     static private int COMPANY_NUM = 1000;
    
     /**試行回数.*/
     static private int TRIAL_TIMES = 10;
     
     //////////システムの設定////////////
     /**画面サイズ.*/
     static private int FRAME_WIDTH = 640;
     static private int FRAME_HEIGHT = 480;
    
    public double getLengthOfStations(){
        return LENGTH_OF_STATIONS;
    }
    
    
    
    
    /**
     * LENGTH_OF_HOMEZONEのアクセサ.
     * homezone半径を返す
     * @return
     */
    public double getLenthOfHomezone(){
        return LENGTH_OF_HOMEZONE;
    }
     
    /**
     * LENGTH_OF_BUISINESSZONEのアクセサ.
     * buisinesszone半径を返す
     * @return double ビジネスゾーン半径
     */
    public double getLenthOfBusinesszone(){
        return LENGTH_OF_BUSINESSZONE;
    }
    
    /**
     * AGENT_NUMのアクセサ.
     * Agentの数を返す
     * @return int エージェント数
     */
    public int getNumOfAgent(){
        return AGENT_NUM;
    }
    
    public int getNumOfHome(){
        return HOME_NUM;
    }
    
    public TripMethods[] getUnitTrip(){
        return tripMethod;
    }
    
    public Goals[] getGoalId(){
        return goal_id;
    }
    
    public RouteLandmark[][] getRoute(){
        return routeLandmark;
    }
    
    public int getNumOfCompany() {
       return COMPANY_NUM; 
    }
    
    public int getNumOfParking(){
       return PARKING_NUM; 
    }
     
    public int getNumOfBikeLot(){
       return BIKELOT_NUM; 
    }
    
    
    public int getInitFrameWidth() {
       return FRAME_WIDTH; 
    }
    public int getInitFrameHeight() {
       return FRAME_HEIGHT; 
    }




    public Coord getCoordCenterOfHomezone() {
        return CENTER_OF_HOMEZONE;
    }




    public double getLengthOfWorldWidth() {
        return WORLD_WIDTH;
    }
    public double getLengthOfWorldHeight() {
        return WORLD_HEIGHT;
    }




    /**
     * 試行回数のgetter.
     * @return
     */
    public int getTrialTimes() {
        return TRIAL_TIMES;
    }
    
}
