package com.company.model;

import com.company.model.monsters.Stats;
import com.company.model.moveModel.EffectType;
import com.company.model.moveModel.Move;
import com.company.model.moveModel.MoveTarget;
import com.company.model.moveModel.MoveType;

//TODO : WIP
public class StatMove extends Move {
    public StatMove(int id, MoveType moveType, String name, ElementType elementType, int accuracy, int priority, int ammunition, MoveTarget target, Stats effect, EffectType effectType) {
        super(id, moveType, name, elementType, accuracy, priority, ammunition, target, effect, effectType);
    }
}
