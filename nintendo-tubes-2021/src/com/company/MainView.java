package com.company;

import com.company.extention.UIViewController;
import com.company.rootFolder.model.Element;
import com.company.rootFolder.model.ElementType;

import java.util.HashMap;

import java.util.Scanner;

public class MainView extends UIViewController {

    private HashMap<ElementType, Element> elementList = new HashMap<ElementType, Element>();
    // called when initializing view
    @Override
    protected void loadView() {
        super.loadView();
        elementList.put(ElementType.FIRE, new Element(
                ElementType.FIRE,
                ElementType.GRASS,
                1));
        System.out.println("Loading view...");
    }

    // called after you're done initializing the view
    @Override
    protected void viewDidLoad() {
        super.viewDidLoad();
        System.out.println("View has been loaded...");
        System.out.println("Welcome to Piku Monsters!");
        System.out.println("Menus : ");
        System.out.println("1. Start Game");
        System.out.println("2. Start Game");
        System.out.println("3. Exit Game");
    }

    // called when you pop the view
    @Override
    protected void deleteView() {
        super.deleteView();
        System.out.println("Deleting View...");
    }

    // called when system is done removing this view from navigation stack
    @Override
    protected void viewDidFinnish() {
        super.viewDidFinnish();
        System.out.println("View has been removed from stack...");
    }

    private void didSelectExitGame() {
        System.out.println("Thank you for playing!");
    }
}

