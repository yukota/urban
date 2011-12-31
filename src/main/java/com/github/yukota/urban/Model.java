package com.github.yukota.urban;

import java.io.FileNotFoundException;

public class Model {
    
    SystemSetting systemSetting = new SystemSetting();
    
    /**
     * Constructer of DataModel
     */
    Model() {
        
    }

    /**
     * Read setting.
     * @throws FileNotFoundException 
     */
    public void init() throws FileNotFoundException {
        //yamlの読み込み
        this.readSetting();
    }
    
    /**
     * Read setting file
     * 設定ファイルを読み込む.
     * @throws FileNotFoundException 
     */
    private void readSetting() throws FileNotFoundException {
        systemSetting.readSetting();
    }
    
    public final SystemSetting getSystemSetting(){
        return systemSetting;
    }

}