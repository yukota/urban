package com.github.yukota.urban;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Controller {
    
    private View view;
    private Model model;
    
    /**instance for logger.*/
    private Logger logger;
    /**
     * Instance Of Controller.
     * @param view Instance of View
     */
    Controller(final View view, final Model model) {
        logger = LoggerFactory.getLogger(Controller.class);
        logger.debug("Construct Controller");
        this.view = view;
        this.model = model;
    }
    /**
     * prepare simulator.
     * read initial data
     * setup view
     * @throws FileNotFoundException 
     */
    public void init() throws FileNotFoundException {
        logger.debug("init:start");
        model.init();
        //x,y
        logger.debug("init:call view:init" 
                     +  model.getSystemSetting().getViewWidth()
                     +  "x"
                     +  model.getSystemSetting().getViewHeight());
        view.init(model.getSystemSetting().getViewWidth(),
                  model.getSystemSetting().getViewHeight());
        
        //環境作成
        logger.debug("init : create landmark : " + model.getFieldSetting().getField().size());
        logger.debug("init : create landmark : " + model.getFieldSetting().getField().get(0).getName());
        logger.debug("init : create landmark : " + model.getFieldSetting().getField().get(0).getCoord().getX());
        
    }
    
    

}
