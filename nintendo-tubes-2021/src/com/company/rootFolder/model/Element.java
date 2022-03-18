package com.company.rootFolder.model;

public class Element {
    public final ElementType type;
    public final ElementType target;
    public final double effectivity;

    public Element(ElementType type, ElementType target, double effectivity) {
        this.type = type;
        this.target = target;
        this.effectivity = effectivity;
    }
}
