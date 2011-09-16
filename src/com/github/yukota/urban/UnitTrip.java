package com.github.yukota.urban;





public class UnitTrip {
    private TripMethods method;
    private Goals goal_id;
    
    public UnitTrip(TripMethods inTripMethods, Goals inGoals) {
        this.method = inTripMethods;
        this.goal_id = inGoals;
    }
    
    
    public TripMethods getMethod(){
        return this.method;
    }
    
    public Goals getGoalId(){
        return this.goal_id;
    }
    
    

}


enum TripMethods {
    WALK,
    BIKE,
    CAR,
    CAR_H,
    TRAIN
}

enum Goals {
    STATION_A,
    STATION_B,
    COMPANY,
    HIGHWAY_S,
    HIGHWAY_E,
    PARKING,
    BIKE_LOT,
    STATION_LOT,
    END
}



