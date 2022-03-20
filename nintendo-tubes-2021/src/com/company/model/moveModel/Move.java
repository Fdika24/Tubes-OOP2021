package com.company.model.moveModel;

import com.company.model.ElementType;

public class Move {
    public final int id;
    public final MoveType moveType;
    public final String name;
    public final ElementType elementType;
    public final int accuracy;
    public final int priority;
    public int ammunition;
    public final MoveTarget target;

    public Move(int id, MoveType moveType,
                String name, ElementType elementType,
                int accuracy, int priority, int ammunition, MoveTarget target) {
        this.id = id;
        this.name = name;
        this.elementType = elementType;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;
        this.moveType = moveType;
        this.target = target;
    }
}
