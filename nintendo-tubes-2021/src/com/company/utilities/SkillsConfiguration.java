package com.company.utilities;

import com.company.model.ElementType;
import com.company.model.monsters.Stats;
import com.company.model.moveModel.EffectType;
import com.company.model.moveModel.Move;
import com.company.model.moveModel.MoveTarget;
import com.company.model.moveModel.MoveType;

import java.util.ArrayList;
import java.util.List;

//@author Farhandika-1822015

public class SkillsConfiguration {
    private enum Status {
        READY, // 1
        FAILS, // -1
        LOADING, // 0
    }
    private final String configName = "skillConfig.txt";
    private List<Move> listOfMoves = new ArrayList<Move>();
    private Status status = Status.LOADING;
    public void start(){
        try {
            this.loadMoveFromConfig();
        } catch (Exception e) {
            System.out.println("Could not configure move config due to :" + e.getMessage());
            System.exit(100);
        }
        System.out.println("Skills has been added to the system");
    }

    private MoveType toMoveType(String str){
        switch (str){
            case "SPECIAL" : return MoveType.SPECIAL;
            case "STATUS" : return MoveType.STATS;
            default : return MoveType.NORMAL;
        }
    }

    private EffectType toEffectType(String str){
        switch (str) {
            case "BURN" : return EffectType.BURN;
            case "POISON" : return  EffectType.POISON;
            case "SLEEP" : return  EffectType.SLEEP;
            case "PARALYZE" : return EffectType.PARALYZE;
            default: return  EffectType.NONE;
        }
    }

    private ElementType toElementType(String str){
        switch (str){
            case "FIRE" : return ElementType.FIRE;
            case "WATER" : return ElementType.WATER;
            case "GRASS" : return ElementType.GRASS;
            default : return ElementType.NORMAL;
        }
    }

    private MoveTarget toTarget(String str){
        switch (str){
            case "OWN" : return MoveTarget.OWN;
            default : return MoveTarget.ENEMY;
        }
    }


    private void loadMoveFromConfig(){
        List<String> datas = LoadConfiguration.loadConfig("skillConfig.csv");
        String[] temp;
        for (String data:datas){
            temp = data.split(";");
            Move tempMove;
            if (this.toMoveType(temp[1]) == MoveType.STATS ) {
                String[] stat = temp[9].split(",");
                tempMove = new Move(
                        Integer.parseInt(temp[0]),
                        this.toMoveType(temp[1]),
                        temp[2],
                        this.toElementType(temp[3]),
                        Integer.parseInt(temp[4]),
                        Integer.parseInt(temp[5]),
                        Integer.parseInt(temp[6]),
                        this.toTarget(temp[7]),
                        new Stats(
                                Integer.parseInt(stat[0]),
                                Integer.parseInt(stat[1]),
                                Integer.parseInt(stat[2]),
                                Integer.parseInt(stat[3]),
                                Integer.parseInt(stat[4]),
                                Integer.parseInt(stat[5])
                        ),
                        this.toEffectType(temp[8])
                );
            } else  {
                tempMove = new Move(
                        Integer.parseInt(temp[0]), // 2
                        this.toMoveType(temp[1]), // SPECIAL
                        temp[2], // Special Punch
                        this.toElementType(temp[3]), // NORMAL
                        Integer.parseInt(temp[4]), // 90
                        Integer.parseInt(temp[5]), // 1
                        Integer.parseInt(temp[6]), // 10
                        this.toTarget(temp[7]), // ENEMY
                        new Stats(
                              0,
                                Double.parseDouble(temp[8]),
                              0,
                              0,
                              0,
                              0
                        ),
                        EffectType.NONE
                );
            }
            this.listOfMoves.add(tempMove);
        }
    }
    //TODO: ADD EXCEPTION HANDLER
    public Move getMoveByID(int id){
        return this.listOfMoves.get(id-1);
    }


    //GET STATUS
    public int getStatus() {
        switch (status){
            case FAILS : return -1;
            case LOADING: return 0;
            case READY: return 1;
        }
        return  -1;
    }
}
