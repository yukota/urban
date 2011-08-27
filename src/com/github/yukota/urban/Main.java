package com.github.yukota.urban;


public class Main {

    /**
     * Main.
     * View,Controller,DataMode
     * @param args none
     */
    public static void main(final String[] args) {
        Runtime.getRuntime().addShutdownHook(new Shutdown());
        
        //設定用クラス
        UrbanParams params = new UrbanParams();
        
    	//View-> Controller ->Model
    	UrbanModel urbanModel = new UrbanModel(params);
    	
    	UrbanController urbanController = new UrbanController(urbanModel);
    	int initHeight = params.getInitFrameHeight();
    	int initWidth = params.getInitFrameWidth();
    	
    	UrbanView urbanView = new UrbanView(urbanController, initWidth, initHeight);
    	urbanController.addObserver(urbanView);
    	
    	//initial終了
    	
    	//試行開始
    	int trialTimes = params.getTrialTimes();
    	urbanController.startTrial(trialTimes);
	}
}

/**
 * 終了時処理.
 * @author YuK_Ota
 *
 */
class Shutdown extends Thread {
    public Shutdown(){
       super();
    }
    
    @Override
    public void run() {
       System.out.println("end process");
    }
    
}