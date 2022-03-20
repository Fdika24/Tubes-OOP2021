package com.company.utilities;

import com.company.model.ElementType;
import com.company.model.monsters.MonsterModel;
import com.company.model.monsters.Stats;

import java.util.ArrayList;
import java.util.List;

public class MonsterConfiguration {

    public static MonsterConfiguration shared = new MonsterConfiguration();

    private List<MonsterModel> listOfMonster = new ArrayList<MonsterModel>();

    public void start() {
        System.out.println("Monsters has been added to the system");
    }
    public MonsterConfiguration() {
        this.loadMoveFromConfig();
    }

    private ElementType toElement(String str){
        switch (str){
            case "GRASS" : return ElementType.GRASS;
            case "FIRE" : return ElementType.FIRE;
            case "WATER" : return ElementType.WATER;
            default : return ElementType.NORMAL;
        }
    }

    private void loadMoveFromConfig() {
        List<String> datas = LoadConfiguration.loadConfig("monsterConfig.csv");
        String[] temp;
        String[] tempStats;
        for(String data:datas){
            temp = data.split(";");
            tempStats = temp[3].split(",");
            Stats stats = new Stats(
                    Double.parseDouble(tempStats[0]),
                    Double.parseDouble(tempStats[1]),
                    Double.parseDouble(tempStats[2]),
                    Double.parseDouble(tempStats[3]),
                    Double.parseDouble(tempStats[4]),
                    Double.parseDouble(tempStats[5])
            );
            MonsterModel monster = new MonsterModel(
                    temp[1],
                    stats
            );
            for (String id:temp[4].split(",")) {
                monster.addMove(SkillsConfiguration.shared.getMoveByID(Integer.parseInt(id)));
            }
            for (String elmt:temp[2].split(",")) {
                monster.addElement(this.toElement(elmt));
            }
            this.listOfMonster.add(monster);
        }
    }

    public MonsterModel getMonsterByID(int id) {
        //TODO: ADD EXCEPTION
        return this.listOfMonster.get(id-1);
    }
    public MonsterModel getMonsterRandom() {
        //TODO: ADD RANDOMIZER
        return this.listOfMonster.get(0);
    }


}
