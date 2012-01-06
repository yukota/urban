package com.github.yukota.urban;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import org.ho.yaml.Yaml;
import org.ho.yaml.YamlDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.yukota.urban.Field;
public abstract class BaseSetting {
    private Logger logger = LoggerFactory.getLogger(BaseSetting.class);
    protected Object readYaml(String fileName) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(fileName);
        Reader reader = new InputStreamReader(inputStream);
        reader = new BufferedReader(reader);
        Object yamlData = Yaml.load(reader);
       
        return yamlData;
    }
    
    protected ArrayList<Object> readYamlList(String fileName) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(fileName);
        Reader reader = new InputStreamReader(inputStream);
        reader = new BufferedReader(reader);
        YamlDecoder yamlDecoder = new YamlDecoder(reader);
        ArrayList <Object> yamlData = new ArrayList<Object>();
        try {
            while (true) {
                    Object object = yamlDecoder.readObject();
                    yamlData.add(object);
                }
        } catch (EOFException e) {
            //ファイル読み込み終了
            logger.debug("Finished reading stream.");
        } finally {
            yamlDecoder.close();
        }
        return yamlData;
    }
   
    abstract void readSetting() throws FileNotFoundException;
}
