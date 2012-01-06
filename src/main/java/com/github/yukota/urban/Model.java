package com.github.yukota.urban;

import java.io.FileNotFoundException;

public class Model {
    
    SystemSetting systemSetting = new SystemSetting();
    FieldSetting fieldSetting = new FieldSetting();
    
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
        //環境設定
        systemSetting.readSetting();
        //フィールドの設定
        fieldSetting.readSetting();
    }
    
    public final SystemSetting getSystemSetting(){
        return systemSetting;
    }
    
    public final FieldSetting getFieldSetting(){
        return fieldSetting;
    }

}