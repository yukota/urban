/**
 * 
 */
package com.github.yukota.urban;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import processing.core.PApplet;


/**
 * @author YuK_Ota
 *
 */
public class View {

    /**
     * init
     * ウインドウの表示
     * @param width 画面幅
     * @param height 画面高さ
     */
    public void init(final int width, final int height) {
        JFrame frame =  new JFrame();
        frame.setLayout(new BorderLayout());
        /**プロセッシング描写用インスタンス作成*/
        PApplet viewApplet = new ViewApplet();
        frame.add(viewApplet, BorderLayout.CENTER);
        frame.setSize(viewApplet.getSize());
    }

}
