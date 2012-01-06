package com.github.yukota.urban;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class FieldSetting extends BaseSetting {
    private static String FILE_NAME = "src/config/FieldSetting.yaml";
    private ArrayList<Field> field = new ArrayList<Field>();

    @Override
    final void readSetting() throws FileNotFoundException {
        ArrayList<Object> objectList = this.readYamlList(FILE_NAME);
        for (Object object : objectList) {
            this.addField(object);
        }
    }
    
    private void addField(Object object){
        HashMap<String, String> data = (HashMap<String, String>) object;
        int x = Integer.parseInt(data.get("x"));
        int y = Integer.parseInt(data.get("y"));
        Coord coord = new Coord(x, y);
        Field oneField = new Field(data.get("name"),data.get("id"), coord);
        field.add(oneField);
    }
    
    public final ArrayList<Field> getField() {
        return field;
    }

}