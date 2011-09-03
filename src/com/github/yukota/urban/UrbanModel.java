package com.github.yukota.urban;


public class UrbanModel {
    /**人.*/
	private UrbanAgent agent[];
	/**家．*/
	private UrbanHome home[];
	private UnitTrip unitTrip[];
	private UrbanParams params;
	private Route route[];
	private UrbanCompany company[];
	private UrbanParking parking[];
	private UrbanBikeLot bikeLot[];
	
	public UrbanModel(UrbanParams inParams) {
	    this.params = inParams;
	    this.setupTrip();
		this.setupHome();
	    this.setupCompany();
		this.setupAgent();
		this.setupParkLot();
	}
	
	/**
	 * tripのインスタンス作成
	 */
	private void setupTrip() {
	    this.setupUnitTrip();
		this.setupRoute();
	}
	
	private void setupUnitTrip() {
	   TripMethods[] tripMethod = this.params.getUnitTrip();
	   Goals[] goal_id = this.params.getGoalId();
	   int loopMax = tripMethod.length;
	   unitTrip = new UnitTrip[loopMax];
	   for (int loopCount = 0; loopCount < loopMax; loopCount++) {
	       unitTrip[loopCount] = new UnitTrip(tripMethod[loopCount], goal_id[loopCount]);
	   }
	}
	
	private void setupRoute(){
	    RouteLandmark [][] routeParam = this.params.getRoute();
	    int routeNum = routeParam.length;
	    route = new Route[routeNum];
	    for(int loop = 0; loop < routeNum; loop++){
    	    route[loop] = new Route(routeParam[loop]);
	    }
	}
	
	/**
	 * homeのインスタンス作成
	 */
	private void setupHome() {
        int homeNum = params.getNumOfHome();
        double lengthOfStations  = params.getLengthOfStations();
        double lengthOfHomezone= params.getLenthOfHomezone();
		home = new UrbanHome[homeNum];
		for (int iLoop = 0; iLoop < homeNum; iLoop += 2) {
			home[iLoop] = new UrbanHome(lengthOfStations, lengthOfHomezone);
			home[iLoop+1] = new UrbanHome(lengthOfStations, lengthOfHomezone);
			//box-muller使用のためcoordを再計算
			BoxMuller boxMuller1 = home[iLoop].getBoxMuller();
			double coord1X = boxMuller1.getResultCos();
			double coord2X = boxMuller1.getResultSin();
			BoxMuller boxMuller2 = home[iLoop + 1].getBoxMuller();
			double coord1Y = boxMuller2.getResultCos();
			double coord2Y = boxMuller2.getResultSin();
			home[iLoop].setCoord(coord1X, coord1Y);
			home[iLoop + 1].setCoord(coord2X, coord2Y);
		}
	}
	
	public void setupCompany(){
        double lengthOfStations  = params.getLengthOfStations();
        double lengthOfBusinesszone  = params.getLenthOfBusinesszone();
	    int companyNum = this.params.getNumOfCompany();
	    company = new UrbanCompany[companyNum];
	    for (int loop = 0; loop < companyNum; loop += 2) {
	        company[loop] = new UrbanCompany(lengthOfStations, lengthOfBusinesszone);
	        company[loop + 1] = new UrbanCompany(lengthOfStations, lengthOfBusinesszone);
			BoxMuller boxMuller1 = company[loop].getBoxMuller();
			double coord1X = boxMuller1.getResultCos();
			double coord2X = boxMuller1.getResultSin();
			BoxMuller boxMuller2 = company[loop + 1].getBoxMuller();
			double coord1Y = boxMuller2.getResultCos();
			double coord2Y = boxMuller2.getResultSin();
			company[loop].setCoord(coord1X, coord1Y);
			company[loop + 1].setCoord(coord2X, coord2Y);
	    }
	}

	/**
	 * agentのインスタンス作成
	 * @param agent_num (int):作成agent数
	 */
	private void setupAgent() {
	    int agentNum = params.getNumOfAgent();
		agent = new UrbanAgent[agentNum];
		for (int iLoop = 0; iLoop < agentNum; iLoop++) {
		    //初期家の決定
		    int selectHome = (int) (Math.random() % home.length);
		    Coord homeCoord = home[selectHome].getCoord();
		    //初期会社の決定
		    int selectCompany = (int) (Math.random() % company.length);
		    //初期ルートの決定
		    int selectRoute = (int) (Math.random() % route.length);
			agent[iLoop] = new UrbanAgent(homeCoord, company[selectCompany], route[selectRoute]);
		}
	}
	
	/**
	 * 
	 */
	private void setupParkLot() {
	    this.setupParking();
	    this.setupBikeLot();
	}
	private void setupParking(){
	    double lengthOfBusinesszone = params.getLenthOfBusinesszone();
	    double lengthOfStations = params.getLengthOfStations();
	    //設定park数
	    int parkingNum = params.getNumOfParking();
	    parking = new UrbanParking[parkingNum];
	    for (int loop = 0;loop < parkingNum;loop += 2) {
	        parking[loop] = new UrbanParking(lengthOfStations, lengthOfBusinesszone);
	        parking[loop + 1] = new UrbanParking(lengthOfStations, lengthOfBusinesszone);
			BoxMuller boxMuller1 = parking[loop].getBoxMuller();
			double coord1X = boxMuller1.getResultCos();
			double coord2X = boxMuller1.getResultSin();
			BoxMuller boxMuller2 = parking[loop + 1].getBoxMuller();
			double coord1Y = boxMuller2.getResultCos();
			double coord2Y = boxMuller2.getResultSin();
			parking[loop].setCoord(coord1X, coord1Y);
			parking[loop + 1].setCoord(coord2X, coord2Y);
	    }
	}
	
	private void setupBikeLot(){
	    double lengthOfBusinesszone = params.getLenthOfBusinesszone();
	    double lengthOfStations = params.getLengthOfStations();
	    //設定park数
	    int bikelotNum = params.getNumOfBikeLot();
	    bikeLot = new UrbanBikeLot[bikelotNum];
	    for (int loop = 0; loop < bikelotNum; loop += 2) {
	        bikeLot[loop] = new UrbanBikeLot(lengthOfStations, lengthOfBusinesszone);
	        bikeLot[loop + 1] = new UrbanBikeLot(lengthOfStations, lengthOfBusinesszone);
			BoxMuller boxMuller1 = bikeLot[loop].getBoxMuller();
			double coord1X = boxMuller1.getResultCos();
			double coord2X = boxMuller1.getResultSin();
			BoxMuller boxMuller2 = bikeLot[loop + 1].getBoxMuller();
			double coord1Y = boxMuller2.getResultCos();
			double coord2Y = boxMuller2.getResultSin();
			bikeLot[loop].setCoord(coord1X, coord1Y);
			bikeLot[loop + 1].setCoord(coord2X, coord2Y);
	    }
	}

    public Coord getCoordCenterOfHomezone() {
        Coord coord = params.getCoordCenterOfHomezone();
        return coord;
    }

    public double getLengthOfHomezone() {
        double length = params.getLenthOfHomezone();
        return length;
    }

    public double getLengthOfWorldWidth() {
        double length = params.getLengthOfWorldWidth();
        return length;
    }

    public double getLengthOfWorldHeight() {
        double length = params.getLengthOfWorldHeight();
        return length;
    }

    public Coord[] getCoordOfHome() {
        int homeNum = home.length;
        Coord [] homeCoord = new Coord[homeNum];
        for (int loop = 0; loop < homeNum; loop++) {
            homeCoord [loop] = home[loop].getCoord();
        }
        return homeCoord;
    }

    public Coord[] getCoordOfCompany() {
        int companyNum = company.length;
        Coord [] companyCoord = new Coord[companyNum];
        for (int loop = 0; loop < companyNum; loop++) {
            companyCoord [loop] = company[loop].getCoord();
        }
        return companyCoord;
    }

     Coord[] getCoordOfAgent() {
        int agentNum = company.length;
        Coord [] agentCoord = new Coord[agentNum];
        for (int loop = 0; loop < agentNum; loop++) {
            agentCoord [loop] = agent[loop].getCoord();
        }
        return agentCoord;
    }

    public void resetAgent() {
        for (int loop = 0; loop < agent.length; loop++) {
               agent[loop].reset(home[loop].getCoord());
        }
    }

    public void moveAgentToDistination() {
        for (int loop = 0; loop < agent.length; loop++) {
            //車密度の計算
            this.calcDencity();
        
            //エージェントの速度の更新
        
            //渋滞，疲れの計算
        
            //次の目的地の計算
            //移動
            //疲れの計算
        }
        
    }
    
    public void calcDencity(){
        
    }
	
	
	
	

}


