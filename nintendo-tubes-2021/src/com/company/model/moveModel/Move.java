package com.company.model.moveModel;

import com.company.model.ElementType;
import com.company.model.monsters.Stats;

public class Move {
    public final int id;
    public final MoveType moveType;
    public final String name;
    public final ElementType elementType;
    public final int accuracy;
    public final int priority;
    public int ammunition;
    public final MoveTarget target;
    private final Stats effect;
    public final double baseAttack;
    public final EffectType effectType;

    public Move(int id,
                MoveType moveType,
                String name,
                ElementType elementType,
                int accuracy,
                int priority,
                int ammunition,
                MoveTarget target,
                Stats effect,
                EffectType effectType
                ) {
        this.id = id;
        this.name = name;
        this.elementType = elementType;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;
        this.moveType = moveType;
        this.target = target;
        this.effect = effect;
        this.baseAttack = effect.getAttackPoint();
        this.effectType = effectType;
    }


    public Stats getMoveEffect() {
        return this.effect;
    }
}
