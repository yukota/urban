package com.github.yukota.urban;

public class Field {
    private Coord coord;
    private String name;
    private String id;
    public Field(String id, String name,Coord coord){
        this.coord = coord;
        this.id = id;
        this.name = name;
    }
    
    public Coord getCoord() {
        return coord;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
}
