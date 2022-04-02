package com.company.Presentation.Main;

import com.company.Presentation.Game.view.GameView;
import com.company.extention.UIViewController;
import com.company.utilities.BasicUtils;

import java.util.Scanner;


public class MainView extends UIViewController {

    // called when initializing view
    @Override
    protected void loadView() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        super.loadView();
        System.out.println("Loading view...");
        BasicUtils.shared.sleepOnly(2);
        BasicUtils.shared.clearScreen();
    }

    // called after you're done initializing the view
    @Override
    protected void viewDidLoad() {
        super.viewDidLoad();
        System.out.println("View has been loaded...");
        BasicUtils.shared.sleepOnly();
        System.out.println("Welcome to Piku Monsters!");
        System.out.println("Menus : ");
        System.out.println("1. Start Game");
        System.out.println("2. Start Game");
        System.out.println("3. Exit Game");

        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Select option :");

        int selection = scan.nextInt();
        BasicUtils.shared.loading();
        if (selection == 1) {
            UIViewController gameView = new GameView();
            this.navigationController.pushView(gameView);
        } else {
            this.didSelectExitGame();
        }
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

