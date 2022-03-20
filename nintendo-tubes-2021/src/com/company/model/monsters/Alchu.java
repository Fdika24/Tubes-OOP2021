package com.company.model.monsters;

import com.company.model.*;
import com.company.model.moveModel.Move;
import com.company.model.moveModel.MoveTarget;
import com.company.model.moveModel.MoveType;

public class Alchu extends MonsterModel {

    public Alchu() {
        super(
                "Alchu",
                new Stats(
                        1000,100,20.5,
                        10.1,3.5,4
                ));
        this.setElements();
        this.setMoves();
    }

    @Override
    protected void setElements() {
        this.addElement(ElementType.NORMAL);
        this.addElement(ElementType.FIRE);
    }

    @Override
    protected void setMoves() {
        this.addMove(new Move(
                1,
                MoveType.NORMAL,
                "Kick", ElementType.NORMAL,
                100,
                1,
                99,
                MoveTarget.ENEMY));
    }


}
