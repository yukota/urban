package com.github.yukota.urban;

import java.util.Observable;

public class UrbanController extends Observable {

    
	private UrbanModel model;
	
	/**試行回数用ループカウンタ.*/
	private int trialLoop;
	/**試行回数.*/
	private int trialNum;
	
	public UrbanController(UrbanModel urbanModel) {
		model = urbanModel;
		
	}
	
	

    
	/**
	 * 試行を行う
	 * @param trialTimes (int):交通選択試行回数
	 */
    public void startTrial(final int trialTimes) {
        //試行回数の設定
        this.trialNum = trialTimes;
        //カウンタの初期化
        this.trialLoop = 0;
        this.doTrial();
    }
    
    /**
     * doTrial
     */
    public void doTrial() {
        if(trialLoop < trialNum) {
            this.trial();
            trialLoop++;
            //描画アップデート
            setChanged();
            super.notifyObservers();
        }
    }
    
    /**
     * 試行を1回おこなう.
     * @return
     */
    private void trial() {
        //agentの初期化が必要なモノを初期化
        //駐車場の仮想容量設定
        //エージェントの移動
        //移動相コスト
        //駐車場の倒産.倒産時はきゃぱ0
        //エージェントのトリップ選択
        //trial終了通知
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

    public Coord[] getCoordOfAgent() {
        Coord [] agentCoord = this.model.getCoordOfAgent(); 
        return agentCoord;
    }

}
