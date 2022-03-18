package com.company.rootFolder.model;

import java.util.List;

public class MonsterModel {
    private String name;
    private List<Element> elements;
    private Stats stats;

    public String getName() {
        return  this.name;
    }
    public void setName(String newName) {
        this.name = newName;
    }

    public  MonsterModel (String name,List<Element> elements, Stats stats ) {
        this.name = name;
        this.elements = elements;
        this.stats = stats;
    }
}
