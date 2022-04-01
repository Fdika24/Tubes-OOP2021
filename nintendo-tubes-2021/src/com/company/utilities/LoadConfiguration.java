package com.company.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadConfiguration {
    static List<String> loadConfig(String fileName){ //filename must have fileName.csv extention
        List<String> dataList = new ArrayList<String>();
        String path = "./resources/" + fileName;
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            boolean isInit = true;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (!isInit){
                    dataList.add(data);
                }
                isInit = false;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. could not load configuration file....");
            e.printStackTrace();
            System.exit(200);
        }
        return dataList;
    }
}
