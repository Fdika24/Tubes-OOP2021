package com.company.utilities;

import com.company.model.Element;
import com.company.model.ElementType;
import com.company.model.ElementTypePair;

import javax.lang.model.util.Elements;
import java.util.HashMap;
import java.util.List;

public class ElementConfiguration {
    public static ElementConfiguration shared = new ElementConfiguration();

    private HashMap<ElementTypePair, Double> elements = new HashMap<ElementTypePair, Double>();
    public ElementConfiguration() {
        this.loadMoveFromConfig();
    }

    public void start() {
        System.out.println("Elements capabilities has been added to the system");
    }

    private ElementType toElementType(String str){
        switch (str){
            case "FIRE" : return ElementType.FIRE;
            case "WATER" : return ElementType.WATER;
            case "GRASS" : return ElementType.GRASS;
            default : return ElementType.NORMAL;
        }
    }

    private void loadMoveFromConfig() {
        List<String> datas = LoadConfiguration.loadConfig("elementConfig.csv");
        String[] temp;
        for(String data:datas) {
            temp = data.split(";");
            ElementTypePair elementPair = new ElementTypePair(
                    toElementType(temp[0]),
                    toElementType(temp[1])
            );
            double effectivityValue = Double.parseDouble(temp[2]);
            this.elements.put(elementPair,effectivityValue);
        }
    }
    /*public Element getElementInfo(ElementType type) {
        //TODO: GET EXCEPTION HANDLER
        return this.elements.get(type);
    }*/

    public double getEffectivityValue(ElementTypePair elementPair) {
        return this.elements.get(elementPair);
    }
}
