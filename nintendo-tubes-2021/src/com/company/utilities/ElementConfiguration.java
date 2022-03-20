package com.company.utilities;

import com.company.model.Element;
import com.company.model.ElementType;

import javax.lang.model.util.Elements;
import java.util.HashMap;
import java.util.List;

public class ElementConfiguration {
    public static ElementConfiguration shared = new ElementConfiguration();

    private HashMap<ElementType, Element> elements = new HashMap<ElementType, Element>();
    public ElementConfiguration() {
        this.loadMoveFromConfig();
    }

    public void start() {
        System.out.println(this.elements.get(ElementType.FIRE).type);
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
            Element element = new Element(
                    toElementType(temp[0]),
                    toElementType(temp[1]),
                    Double.parseDouble(temp[2])
            );
            this.elements.put(element.type,element);
        }
    }
    public Element getElementInfo(ElementType type) {
        //TODO: GET EXCEPTION HANDLER
        return this.elements.get(type);
    }
}
