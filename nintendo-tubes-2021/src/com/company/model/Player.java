package com.company.model;

import com.company.model.monsters.Alchu;
import com.company.model.monsters.MonsterModel;
import com.company.model.monsters.MonsterState;
import com.company.utilities.MonsterConfiguration;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<MonsterModel> monsters = new ArrayList<MonsterModel>();
    private int useMonster = 0;
    public Player() {
        this.monsters.add(MonsterConfiguration.shared.getMonsterByID(1));
        this.monsters.add(MonsterConfiguration.shared.getMonsterByID(2));
        this.monsters.add(MonsterConfiguration.shared.getMonsterByID(3));
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
        if (use > monsters.size() || use <= 0) { // next condition is when monster is dead
            System.out.println("Cannot use Monster or Monster is not available in your index");
            return;
        }
        this.useMonster = use-1;
        System.out.println("You are now using " + this.getMonster().getName());
    }
    public MonsterModel getMonster() {
        return this.monsters.get(useMonster);
    }

}
