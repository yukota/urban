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
     * prepare simulater.
     * read initial data
     * setup view
     * @throws FileNotFoundException 
     */
    public void init() throws FileNotFoundException {
        logger.debug("init:start");
        model.init();
        view.init();
        
    }
    
    

}
