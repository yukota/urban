package com.github.yukota.urban;

import java.io.FileNotFoundException;
import java.util.HashMap;


public class SystemSetting extends BaseSetting {
    /**
     * SystemSettingファイル名.
     */
    private static String FILE_NAME = "src/config/SystemSetting.yaml";
    
    /**
     * Width of Monitor.
     * モニターサイズ
     */
    private int viewWidth;
    
    /**
     * Height of Monitor.
     */
    private int viewHeight;
    
    public int getViewWidth() {
        return viewWidth;
    }
    public void setViewWidth(String width) {
        this.viewWidth = Integer.parseInt(width);
    }
    public int getViewHeight() {
        return viewHeight;
    }
    public void setViewHeight(String height) {
        this.viewHeight = Integer.parseInt(height);
    }
    public final void readSetting() throws FileNotFoundException {
        Object yamlObject = this.readYaml(FILE_NAME);
        @SuppressWarnings("unchecked")
        HashMap<String, String> data = (HashMap<String, String>) yamlObject;
        this.setViewWidth(data.get("width"));
        this.setViewHeight(data.get("height"));
    }
    

}
