package com.github.yukota.urban;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class MapPanel extends JPanel {
    
    private double maxWidth;
    private double maxHeight;
    private Coord homezoneCenter;
    private double lengthOfHomezone;
    protected Graphics g;
    
    MapPanel(double inMaxWidth,double inMaxHeight){
        this.maxWidth = inMaxWidth;
        this.maxHeight = inMaxHeight;
    }

    
    protected void drawCircle(Coord homezoneCenter,double lengthOfHomezone,Color homezoneColor) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(homezoneColor);
//        Ellipse2D homeCircle1 = new Ellipse2D.Double(0,0,lengthOfHomezone,lengthOfHomezone+1);
        //長さ
        Coord lengthCoord = new Coord(lengthOfHomezone, lengthOfHomezone);
        Coord fixedLengthCoord = this.sizeFitter(lengthCoord);
        //中心
        Coord fixedCenterCoord = this.coordFitter(homezoneCenter,fixedLengthCoord);
        Ellipse2D homeCircle1 = new Ellipse2D.Double(fixedCenterCoord.getX(),
                                                     fixedCenterCoord.getY(),
                                                     fixedLengthCoord.getX(),
                                                     fixedLengthCoord.getY());
        
        g2.draw(homeCircle1);
    }
    
    
    protected Coord sizeFitter(Coord coord) {
        //画面のサイズを取得
        Dimension dim = this.getSize();
        //x座標
        double retX = coord.getX() * dim.getWidth() / maxWidth  ;
        //y座標の変換
        double retY = coord.getY() * dim.getHeight() / maxHeight ;
        Coord retCoord = new Coord(retX, retY);
        return retCoord;
    }
    
     
    
    protected Coord coordFitter(Coord coord,Coord fixedLength) {
        //画面のサイズを取得
        Dimension dim = this.getSize();
        //x座標
        double retX = coord.getX() * dim.getWidth() / maxWidth + dim.getWidth()/2 - fixedLength.getX() / 2;
        //y座標の変換
        double retY = coord.getY() * dim.getHeight() / maxHeight + dim.getHeight() /2 -fixedLength.getY() / 2;
        Coord retCoord = new Coord(retX, retY);
        return retCoord;
    }
    
    
    

}