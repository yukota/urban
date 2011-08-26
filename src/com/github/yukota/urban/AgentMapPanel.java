package com.github.yukota.urban;

import java.awt.Color;
import java.awt.Graphics;

public class AgentMapPanel extends MapPanel {
    
    private Coord coord[];
    AgentMapPanel(double inMaxWidth,double inMaxHeight, Coord [] agentCoord){
        super(inMaxWidth,inMaxHeight);    
        this.coord = agentCoord;
    }
        
    @Override
    public final void paint(final Graphics g) {
        super.paint(g);
        super.g = g;
        
        int homeNum = coord.length;
        //全家について処理
        for (int loop = 0; loop < homeNum; loop++) {
           drawCircle(coord[loop], 100,Color.BLACK);
        }
        //座標変換
        //
        
    }

    

}
