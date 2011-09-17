package com.github.yukota.urban;

import java.awt.Color;
import java.awt.Graphics;

public class HomeMapPanel extends MapPanel {
    
    private Coord coord[];
    
    HomeMapPanel(double inMaxWidth,double inMaxHeight, Coord [] homeCoord){
    super(inMaxWidth,inMaxHeight);    
    this.coord = homeCoord;
    }
    
    @Override
    public final void paint(final Graphics g) {
        super.paint(g);
        super.g = g;
        
        int homeNum = coord.length;
        //全家について処理
        for (int loop = 0; loop < homeNum; loop++) {
           drawCircle(coord[loop], 10,Color.RED);
        }
        //座標変換
        //
        
    }

}
