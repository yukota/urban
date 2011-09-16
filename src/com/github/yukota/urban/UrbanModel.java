package com.github.yukota.urban;


public class UrbanModel {
    /**人.*/
	private UrbanAgent agent[];
	/**家．*/
	private UrbanHome home[];
	private Goals[][] route;
	private UrbanParams params;
	private UrbanCompany company[];
	
	//区画の車密度
	private double carDensity[][];
	
	
	public UrbanModel(UrbanParams inParams) {
	    this.params = inParams;
	    this.setupTrip();
		this.setupHome();
	    this.setupCompany();
		this.setupAgent();
	}
	
	
	
	/**
	 * tripのインスタンス作成
	 */
	private void setupTrip(){
	    route = params.getRoute();
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
		    Goals routeLandmark[][] = params.getRoute();
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
		    int selectHome = (int) (Math.random() * home.length -1);
		    
		    Coord homeCoord = home[selectHome].getCoord();
		    //初期会社の決定
		    int selectCompany = (int) (Math.random() * company.length -1);
		    //初期ルートの決定
		    int selectRoute = (int) (Math.random() * route.length -1);
			agent[iLoop] = new UrbanAgent(homeCoord, company[selectCompany], route[selectRoute]);
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
        int agentNum = agent.length;
        Coord [] agentCoord = new Coord[agentNum];
        for (int loop = 0; loop < agentNum; loop++) {
            agentCoord [loop] = agent[loop].getCoord();
        }
        return agentCoord;
    }

    public void moveAgentToDistination() {
        
        boolean resetFlg = false;
        //すべてのagentの行動が終了したか問い合わせる
        for(int loop = 0; loop < agent.length; loop++){
            //RouteがENDかつ，現在が目標座標
            if(agent[loop].getCurrentPlace() == Goals.END){
                Coord agentCoord = agent[loop].getCoord();
                Coord companyCoord = agent[loop].getCoordOfCompany();
                double lengthOfBetween = Math.sqrt(Math.pow((agentCoord.getX() - companyCoord.getX()),2) + Math.pow((agentCoord.getX() - companyCoord.getX()),2));
                if(lengthOfBetween < 0.001){
                    continue;
                }
                 
                
                
                
                
                double moveSpeed = params.getSpeedOfWalk();
                double currentX = agentCoord.getX();
                double currentY = agentCoord.getY();
                
                
                double distX =  agentCoord.getX();
                double distY =  agentCoord.getY();
               
                double theta = Math.atan2(distY - currentY, distX - currentX);
                
                double moveX= moveSpeed * Math.cos(theta);
                double moveY= moveSpeed * Math.sin(theta);
                
                Coord nextCoord = new Coord(moveX  + currentX, moveY  + currentY);
                agent.clone()[loop].setCoord(nextCoord);
                
                
            }else{
               //ENDではない 
                Coord agentCoord = agent[loop].getCoord();
                Coord unitTripCoord = params.getCoordOfGoals(agent[loop].getCurrentPlace()) ;
                double lengthOfBetween = Math.sqrt(Math.pow((agentCoord.getX() - unitTripCoord.getX()),2) + Math.pow((agentCoord.getX() - unitTripCoord.getX()),2));
                if(lengthOfBetween < 0.001){
                   //次のルートへ移動 
                    agent[loop].setNextSpot();
                }
                //移動
                
                double moveSpeed = params.getSpeedOfWalk();
                double currentX = agentCoord.getX();
                double currentY = agentCoord.getY();
                
                
                double distX =  unitTripCoord.getX();
                double distY =  unitTripCoord.getY();
               
                double theta = Math.atan2(distY - currentY, distX - currentX);
                
                double moveX= moveSpeed * Math.cos(theta);
                double moveY= moveSpeed * Math.sin(theta);
                
                Coord nextCoord = new Coord(moveX  + currentX, moveY  + currentY);
                agent.clone()[loop].setCoord(nextCoord);
            }
        }
    }

    
	
	

}


