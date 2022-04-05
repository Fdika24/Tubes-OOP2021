package com.company.utilities;

import com.company.model.ElementType;
import com.company.model.monsters.MonsterModel;
import com.company.model.monsters.Stats;

import java.util.ArrayList;
import java.util.List;

public class MonsterConfiguration {

    private SkillsConfiguration skillConfig = new SkillsConfiguration();

    private List<MonsterModel> listOfMonster = new ArrayList<MonsterModel>();
    private List<Integer> temp = new ArrayList<Integer>();

    public void start() {
        try {
            this.skillConfig.start();
            this.loadMoveFromConfig();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Monsters has been added to the system");
    }
    public MonsterConfiguration() {

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
                monster.addMove(skillConfig.getMoveByID(Integer.parseInt(id)));
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
        int random = BasicUtils.shared.getRandomNumber(0,listOfMonster.size() - 1);
        while (temp.contains(random)) {
            random = BasicUtils.shared.getRandomNumber(0,listOfMonster.size() - 1);
        }
        temp.add(random);
        return this.listOfMonster.get(random);
    }


}
