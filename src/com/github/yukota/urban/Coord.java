package com.github.yukota.urban;

/**
 * 座標型.
 * @author YuK_Ota
 *
 */
public class Coord {
    /**x座標.*/
    private double x;
    /**y座標.*/
    private double y;
    
    /**
     * コンストラクタ
     * @param inX
     * @param inY
     */
    public Coord(double inX, double inY) {
        this.setX(inX);
        this.setY(inY);
    }
    
    public void setX(double inX) {
        this.x = inX;
    }

    public void setY(double inY) {
        this.y = inY;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    
}
