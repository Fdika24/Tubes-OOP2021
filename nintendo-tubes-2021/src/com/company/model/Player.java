package com.company.model;

import com.company.model.monsters.Alchu;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<MonsterModel> monsters = new ArrayList<MonsterModel>();
    private int useMonster = 0;
    public Player() {
        this.monsters.add(new Alchu());
        this.monsters.add(new Alchu());
    }
    public int getAvailMonster() {
        for(int i = 0; i < monsters.size();i++){
            if (monsters.get(i).getMonsterState() == MonsterState.ALIVE){
                return i;
            }
        }
        return -1;
    }
    public List<MonsterModel> getMonsters() {
        return  this.monsters;
    }
    public void setUseMonster(int use){
        if (use > monsters.size()) { // next condition is when monster is dead
            System.out.println("Cannot use monster");
            return;
        }
        this.useMonster = use;
    }
    public MonsterModel getMonster() {
        return this.monsters.get(useMonster);
    }

}
