/**
 * 
 */
package com.github.yukota.urban;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import processing.core.PApplet;


/**
 * @author YuK_Ota
 *
 */
public class View {

    PApplet viewApplet;
    
    private Logger logger = LoggerFactory.getLogger(View.class);
    /**
     * init
     * ウインドウの表示
     * @param width 画面幅
     * @param height 画面高さ
     */
    public void init(final int width, final int height) {
        logger.debug("Construct View : start");
        JFrame frame =  new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        /**プロセッシング用インスタンス作成
         * instance for processing
         * processing is extend JApplet
         * */
        viewApplet = new ViewApplet();
        frame.add(BorderLayout.CENTER, viewApplet);
        viewApplet.init();
        frame.pack();
        frame.setSize(width, height);
        frame.setVisible(true);
        viewApplet.start();
        logger.debug("Construct View : out");
    }

}
