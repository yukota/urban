package com.github.yukota.urban;

import java.util.Observable;
/**
 * コントローラ
 * @author YuK_Ota
 *
 */
public class UrbanController extends Observable {

    /**Modelのインスタンス.*/
    private UrbanModel model;
    
    /**試行回数用ループカウンタ.*/
    private int trialLoop;
	
	/**試行回数.*/
	private int trialNum;
	
	/**
	 * コンストラクタ.
	 * @param urbanModel モデル
	 */
	public UrbanController(final UrbanModel urbanModel) {
		model = urbanModel;
	}

    
	/**
	 * 試行開始時にこのメソッドを使用する.
	 * @param trialTimes int 交通選択試行回数
	 */
    public final void startTrial(final int trialTimes) {
        //試行回数の設定
        this.trialNum = trialTimes;
        //カウンタの初期化
        this.trialLoop = 0;
        this.doTrial();
    }
    
    /**
     * doTrial.
     * 試行回数の管理，試行の実行.1試行終了時にViewに通知を行う．
     */
    public final void doTrial() {
            this.moveAgent();
            trialLoop++;
            //描画アップデート
            setChanged();
            super.notifyObservers();
    }
    
    /**
     * 試行を1回おこなう.
     */
    private void moveAgent() {
        
        //agentの初期化が必要であれば初期化
//        model.resetAgent();
        //エージェントの移動
        model.moveAgentToDistination();
    }
    
    
    /**
     * Homezoneの中心座標を取得する.
     * @return Coord Homezoneの中心座標
     */
	public final Coord getCoordCenterOfHomezone() {
	    Coord coord = this.model.getCoordCenterOfHomezone();
	    return coord;
	}
	
	/**
	 * Homezoneの直径を取得する.
	 * @return double Homezoneの直径
	 */
	public final double getLengthOfHomezone() {
	    double length = this.model.getLengthOfHomezone();
	    return length;
	}

	/**
	 * 描写空間の横幅を取得する.
	 * @return double 空間の横幅
	 */
    public final double getLengthOfWorldWidth() {
        double length = this.model.getLengthOfWorldWidth();
        return length;
    }
    
    /**
     * 描写空間の高さを取得する.
     * @return double 空間の高さ
     */
    public final double getLengthOfWorldHeight() {
        double length = this.model.getLengthOfWorldHeight();
        return length;
    }

    /**
     * 住居の座標を取得する.
     * @return Coord[] 住居の座標の配列
     */
    public final Coord[] getCoordOfHome() {
        Coord [] homeCoord = this.model.getCoordOfHome();
        return homeCoord;
    }

    /**
     * 会社の座標を取得する.
     * @return Coord[] 会社の座標の配列
     */
    public final Coord[] getCoordOfCompany() {
        Coord [] companyCoord = this.model.getCoordOfCompany();
        return companyCoord;
    }

    /**
     * Agentの座標を取得する.
     * @return Coord[] Agentの座標の配列
     */
    public final Coord[] getCoordOfAgent() {
        Coord [] agentCoord = this.model.getCoordOfAgent();
        return agentCoord;
    }

}
