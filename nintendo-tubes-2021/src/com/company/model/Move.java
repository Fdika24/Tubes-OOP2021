package com.company.model;

public class Move {
    public final int id;
    public final String name;
    public final ElementType elementType;
    private final int accuracy;
    public final int priority;
    public int ammunition;
    public final MoveType moveType;

    public Move(int id,String name, ElementType elementType, int accuracy, int priority, int ammunition, MoveType moveType) {
        this.id = id;
        this.name = name;
        this.elementType = elementType;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;
        this.moveType = moveType;
    }
}
