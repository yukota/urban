package com.github.yukota.urban;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Main {

    /**
     * Main.
     * Create Instance Of View,Controller,DataModel
     * @param args none
     */
    public static void main(final String[] args) {
        Runtime.getRuntime().addShutdownHook(new Shutdown());
        
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.debug("Application Urban start");
        /*
         * View,DataModelの作成
         */
        View view = new View();
        Model model = new Model(); 
        Controller controller = new Controller(view, model);
        try {
            controller.init();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
	}
}

/**
 * 終了時処理.
 * @author YuK_Ota
 *
 */
class Shutdown extends Thread {
    public Shutdown(){
       super();
    }
    
    @Override
    public void run() {
       System.out.println("end process");
    }
    
}