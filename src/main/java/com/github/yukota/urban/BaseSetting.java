package com.github.yukota.urban;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.ho.yaml.Yaml;

public class BaseSetting {
    protected Object readYaml(String fileName) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(fileName);
        Reader reader = new InputStreamReader(inputStream);
        reader = new BufferedReader(reader);
        Object yamlData = Yaml.load(reader);
       
        return yamlData;
    }
}
