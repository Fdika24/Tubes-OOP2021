package com.company.model.monsters;

import com.company.model.ElementType;
import com.company.model.moveModel.EffectType;
import com.company.model.moveModel.Move;

import java.util.ArrayList;
import java.util.List;

public class MonsterModel {
    private final String name;
    private List<ElementType> elements;
    private Stats stats;
    private List<Move> moves;
    private MonsterState state = MonsterState.ALIVE;
    private EffectType affectedBy = EffectType.NONE;
    private int sleepDuration = 0;

    //TODO: CREATE MONSTER STATUS CONDITION

    public String getName() {
        return  this.name;
    }

    public  MonsterModel (
            String name,
            Stats stats
            ) {
        this.name = name;
        this.elements = new ArrayList<ElementType>();
        this.stats = stats;
        this.moves = new ArrayList<Move>();
    }

    //MARK :
    public List<ElementType> getElements() {
        return this.elements;
    }
    //MARK: ADD ELEMENT TO A MONSTER
    public void addElement(ElementType type){
        this.elements.add(type);
    }
    //MARK: ADD MOVE TO A MONSTER
    public void addMove(Move move){
        this.moves.add(move);
    }

    //MARK: Get Monster state, either dead or alive
    public MonsterState getMonsterState() {
        return this.state;
    }

    //MARK: SHOW MONSTER MOVES
    public void showMonsterMoves() {
        System.out.println(this.name + " move list :");
        for(int i = 0; i < this.getMoves().size(); i++){
            System.out.println((i+1) + ". " + this.moves.get(i).name);
        }
    }

    //MARK: GET MONSTER MOVES
    public List<Move> getMoves() {
        return this.moves;
    }

    //MARK: Get Monster Move Info
    public void getMonsterMoveInfo(){
        System.out.println(this.name + " Information :");
        this.showMonsterMoves();
        this.stats.showStatsInfo();
    }

    //MARK: GET STATS
    public Stats getMonsterStats() {
        return this.stats;
    }

    //MARK : GET HP
    public Double getHp() {
        return  this.stats.getHP();
    }


    //MARK: TAKE DAMAGE
    public void didTakeDamage(double damage){
        this.stats.decreaseHp(damage);
        if (this.stats.getHP() <= 0){
            this.state = MonsterState.DEAD;
        }
    }

    public EffectType getMonsterAffectedBy() {
        return  this.affectedBy;
    }

    public void setMonsterAffectedBy(EffectType type) {
        this.affectedBy = type;
        if (type == EffectType.SLEEP) {
            this.sleepDuration = 0; //randomizer from 1 to 7
        }
    }

    //CALLED TO REDUCE SLEEP DURATION
    public void reduceSleepTime() {
        if (this.sleepDuration <= 0) {
            this.affectedBy = EffectType.NONE;
            return;
        }
        this.sleepDuration -= 1;
    }

}
