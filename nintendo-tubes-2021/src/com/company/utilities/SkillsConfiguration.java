package com.company.utilities;

import com.company.model.ElementType;
import com.company.model.moveModel.Move;
import com.company.model.moveModel.MoveTarget;
import com.company.model.moveModel.MoveType;

import java.util.ArrayList;
import java.util.List;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;

//@author Farhandika-1822015

public class SkillsConfiguration {
    private enum Status {
        READY, // 1
        FAILS, // -1
        LOADING, // 0
    }
    private final String configName = "skillConfig.txt";
    private List<Move> listOfMoves = new ArrayList<Move>();
    public static SkillsConfiguration shared = new SkillsConfiguration();
    private Status status = Status.LOADING;
    public SkillsConfiguration() {
        this.loadMoveFromConfig();
    }
    public void start(){
        System.out.println("Skills has been added to the system");
    }

    private MoveType toMoveType(String str){
        switch (str){
            case "SPECIAL" : return MoveType.SPECIAL;
            case "STATUS" : return MoveType.STATS;
            default : return MoveType.NORMAL;
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

    public void loadMoveFromConfig(){
        List<String> datas = LoadConfiguration.loadConfig("skillConfig.csv");
        for (String data: datas ){
            System.out.println(data);
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
