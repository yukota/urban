package com.github.yukota.urban;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class UrbanView {
	private UrbanController controller;
	
	/**がめんさいず*/
	private int frameWidth;
	private int frameHeight;

	public UrbanView(UrbanController urbanController, int initHeight,int initWidth) {
		controller = urbanController;
		this. frameWidth = initWidth;
		this.frameHeight = initHeight;
		
		//初期描写
		this.initView();
	}
	
	/**
	 * 初期描写
	 */
	private void initView() {
	    //ウインドウでもつくろうか
	    JFrame frame = new JFrame();
	    frame.setLayout(new BorderLayout());
	    JPanel mapPanel =  this.initMap();
	    frame.add(mapPanel);
	    frame.setSize(frameHeight, frameWidth);
	    //centerに表示する奴
	    //表示
	    frame.setVisible(true);
	}
	
	//初期描画マップの描写
	private JPanel initMap(){
	    //グラのサイズ
	    //描写空間の理論最大値
	    double lengthOfWorldWidth = this.controller.getLengthOfWorldWidth();
	    double lengthOfWorldHeight = this.controller.getLengthOfWorldHeight();
	    
	    //描写ベースの作成
	    JPanel basePanel = new JPanel();
	    basePanel.setLayout(new OverlayLayout(basePanel));
	    //街の輪っかをかきます
	    Coord centerOfHomezone = this.controller.getCoordCenterOfHomezone();
	    double lengthOfHomezone = this.controller.getLengthOfHomezone();
	    //お家を書きます
	    JPanel cityPanel = new BackgroundMapPanel(lengthOfWorldWidth,lengthOfWorldHeight,centerOfHomezone, lengthOfHomezone);
	    cityPanel.setOpaque(false);
	    basePanel.add(cityPanel,"1");
	    
	    //お家を書きます
	    //家の一覧
	    //座標取得
	    Coord [] homeCoord = this.controller.getCoordOfHome();
	    System.out.println("coordNum"+homeCoord.length);
	    
	    JPanel homePanel = new HomeMapPanel(lengthOfWorldWidth,lengthOfWorldHeight,homeCoord);
	    homePanel.setOpaque(false);
	    basePanel.add(homePanel,"-2");
	    
	    //パネルの合成
	    return basePanel;
	}

}
