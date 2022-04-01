package com.company.model;

public class ElementTypePair {
    public final ElementType type;
    public final ElementType target;

    public ElementTypePair (ElementType type, ElementType target) {
        this.type = type;
        this.target = target;
    }

    public ElementType getMonsterType() {
        return this.type;
    }

    public ElementType getTargetType() {
        return this.target;
    }
}
