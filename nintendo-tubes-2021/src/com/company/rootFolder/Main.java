package com.company.rootFolder;

import com.company.utilities.SkillsConfiguration;

public class Main {
    private static RootController root = new RootController();
    public static void main(String[] args) {

        //root.start();
        SkillsConfiguration.shared.start();
    }
}
