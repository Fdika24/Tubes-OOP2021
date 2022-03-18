package com.company.rootFolder.model;

public class Element {
    public final ElementType type;
    public final Element target;
    public final double effectivity;

    public Element(ElementType type, Element target, double effectivity) {
        this.type = type;
        this.target = target;
        this.effectivity = effectivity;
    }
}
