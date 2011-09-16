package com.github.yukota.urban;

import java.awt.Color;
import java.awt.Graphics;

public class AgentMapPanel extends MapPanel implements Runnable {
    
    private Coord coord[];
    AgentMapPanel(double inMaxWidth,double inMaxHeight, Coord [] agentCoord){
        super(inMaxWidth,inMaxHeight);    
        this.coord = agentCoord;
        Thread refresh = new Thread(this);
        refresh.start();
        
    }
    
    public final void setCoords(Coord [] inCoord){
        this.coord = inCoord;
    }
        
    @Override
    public final void paint(final Graphics g) {
        super.paint(g);
        super.g = g;
        
        int agentNum = coord.length;
        System.out.println("agentCoord"+coord[0].getX());
        //全家について処理
        for (int loop = 0; loop < agentNum; loop++) {
           drawCircle(coord[loop], 100,Color.BLACK);
        }
        //座標変換
        
    }

    @Override
    public void run() {
        while(true){
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }

    

}
