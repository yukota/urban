package com.github.yukota.urban;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 変化がない背景の描写
 * @author YuK_Ota
 *
 */
public class BackgroundMapPanel extends MapPanel {
        
    private Coord homezoneCenter;
    private double lengthOfHomezone;
    
    BackgroundMapPanel(double inMaxWidth,double inMaxHeight, Coord inHomezoneCenter,double inLengthOfHomezone){
        super(inMaxWidth,inMaxHeight);
        this.homezoneCenter = inHomezoneCenter;
        this.lengthOfHomezone = inLengthOfHomezone;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        super.g = g;
        Color homezoneColor = Color.GREEN;
        this.drawCircle(homezoneCenter, lengthOfHomezone, homezoneColor);
        
    }


}
