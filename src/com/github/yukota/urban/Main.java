package com.github.yukota.urban;

public class Main {
	
	//�ݒ�
	private static int AGENT_NUM = 1;
	

	/**
	 * Main.
	 * View,Controller,DataMode
	 * @param args
	 */
	public static void main(String[] args) {
	    //設定用クラス
	    UrbanParams params = new UrbanParams();
	    
		//View-> Controller ->Model
		UrbanModel urbanModel = new UrbanModel(params);
		
		UrbanController urbanController = new UrbanController(urbanModel);
		int initHeight = params.getInitFrameHeight();
		int initWidth = params.getInitFrameWidth();
		UrbanView urbanView = new UrbanView(urbanController, initWidth,initHeight);
		

	}

}
