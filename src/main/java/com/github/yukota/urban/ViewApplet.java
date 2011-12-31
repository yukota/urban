package com.github.yukota.urban;


import java.awt.Color;

import controlP5.ControlP5;
import controlP5.Textlabel;
import processing.core.PApplet;

/**
 * View.
 * Processing描写部分
 * @author YuK_Ota
 *
 */
public class ViewApplet extends PApplet {
    private int windowWidth;
    private int windowHeight;
    
    private ControlP5 controlP5;
    private Textlabel statusTextlabel;
    
    private float depth = 50;
    
    /**
     * 床面設定.
     */
    private int gridX = 100;
    private int gridY = 50;
    private float boxWidth = 100;
    private float boxHeight = 100;
    private float boxDepth = 1;
    /**
     * 床面色.
     * Hue:色相,赤0度
     * Saturation:彩度,0〜1
     * Brightness:明度,0〜1
     */
    private static float BOXHUE = 0;
    private static float BOXBRIGHTNESS = 1;
    
    
    
    float [][] floorStatus = new float[gridX][gridY];
    @Override
    public void setup() {
        size(640, 480, P3D);
        //背景色:白
        background(255);
        //輪郭削除
        noStroke();
        controlP5 = new ControlP5(this);
        controlP5.begin();
        statusTextlabel = controlP5.addTextlabel("label","Booting...",10,10);
        statusTextlabel.setColorValue(0);
        controlP5.end();
        
        //床面の初期化
        for(int x = 0;  x < gridX; x++){
            for(int y = 0;  y < gridY; y++){
                floorStatus[x][y] = 0;
            }
        }
    }
    
    /**
     * 描画
     */
    @Override
    public void draw() {
        //背景色:白
        background(255);
        
        pushMatrix();
        translate(width/2, height/2, -depth);
        rotateY((float) (frameCount * 0.1));
        rotateX((float) (frameCount * 0.1));
        //default ambientlight,directional light
        lights();
        //床の描写
        this.drawFloor();
        
        popMatrix();
        controlP5.draw();
    }
    
    /**
     * 床の描写.
     */
    private void drawFloor() {
        for(int x = 0;  x < gridX; x++){
            pushMatrix();
            for(int y = 0;  y < gridY; y++){
                Color boxColor = new Color(Color.HSBtoRGB(BOXHUE, floorStatus[x][y], BOXBRIGHTNESS));
                int red = boxColor.getRed();
                int green  = boxColor.getGreen();
                int blue = boxColor.getBlue();
                pushMatrix();
                translate(x,y,10);
                //色:r,g,b,alpha
                fill(red, green, blue, 50);
                //BoxSize
                box(boxWidth,boxHeight, boxDepth); 
                popMatrix();
            }
            popMatrix();
        }
    }
}
