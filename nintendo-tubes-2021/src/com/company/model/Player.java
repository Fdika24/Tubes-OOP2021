package com.company.model;

import com.company.model.monsters.Alchu;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<MonsterModel> monsters = new ArrayList<MonsterModel>();
    private int useMonster = 0;
    public Player() {
        this.monsters.add(new Alchu());
    }
    public List<MonsterModel> getMonsters() {
        return  this.monsters;
    }
    public void setUseMonster(int use){
        this.useMonster = use;
    }
    public MonsterModel getMonster() {
        return this.monsters.get(useMonster);
    }

}
