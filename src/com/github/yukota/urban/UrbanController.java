package com.github.yukota.urban;

public class UrbanController {

	private UrbanModel model;
	public UrbanController(UrbanModel urbanModel) {
		model = urbanModel;
		
	}
	
	public Coord getCoordCenterOfHomezone(){
	    Coord coord = this.model.getCoordCenterOfHomezone();
	    return coord; 
	}
	
	public double getLengthOfHomezone(){
	    double length = this.model.getLengthOfHomezone();
	    return length;
	}

    public double getLengthOfWorldWidth() {
        double length = this.model.getLengthOfWorldWidth();
        return length;
    }
    
    public double getLengthOfWorldHeight() {
        double length = this.model.getLengthOfWorldHeight();
        return length;
    }

    public Coord[] getCoordOfHome() {
        Coord [] homeCoord = this.model.getCoordOfHome(); 
        return homeCoord;
    }

    public Coord[] getCoordOfCompany() {
        Coord [] companyCoord = this.model.getCoordOfCompany(); 
        return companyCoord;
    }

}
