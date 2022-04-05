package com.company.model;

import com.company.model.monsters.MonsterModel;
import com.company.model.monsters.MonsterState;
import com.company.utilities.MonsterConfiguration;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<MonsterModel> monsters = new ArrayList<MonsterModel>();
    private int useMonster = 0;
    //private MonsterConfiguration config = new MonsterConfiguration();

    public void init() {
        MonsterConfiguration config = new MonsterConfiguration();
        config.start();
        // add randomizer
        this.monsters.add(config.getMonsterRandom());
        this.monsters.add(config.getMonsterRandom());
        this.monsters.add(config.getMonsterRandom());
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
    public boolean setUseMonster(int use){
        if (use == this.useMonster){
            System.out.println("Cannot use Monster, you are currently using " + this.getMonster().getName());
            return false;
        }
        if (use > monsters.size()-1 || use < 0) { // next condition is when monster is dead
            System.out.println("Cannot use Monster or Monster is not available in your index");
            return false;
        }
        this.getMonster().getMonsterStats().didChangeMonster();
        this.useMonster = use;
        System.out.println("You are now using " + this.getMonster().getName());
        return  true;
    }

    public boolean isMonsterAllDead() {
        for (MonsterModel monster : monsters){
            if (monster.getMonsterState() == MonsterState.ALIVE){
                return  false;
            }
        }
        return true;
    }
    public MonsterModel getMonster() {
        return this.monsters.get(useMonster);
    }

}
