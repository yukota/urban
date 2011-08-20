package com.github.yukota.urban;

public class Route {

    private RouteLandmark landmark[];
    
    public Route(RouteLandmark[] routeLandmarks) {
        this.landmark = routeLandmarks;
    }
}

enum RouteLandmark{
   W_STATION_A,
   W_COMPANY,
   B_STATION_A,
   B_COMPANY,
   B_BIKE_LOT,
   C_COMPANY,
   C_HIGHWAY_S,
   C_PARKING,
   C_HIGHWAY_E,
   T_STATION_B,
   B_STATION_LOT,
   END
}