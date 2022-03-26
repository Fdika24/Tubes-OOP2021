package com.company.Presentation.Game.view;

import com.company.Presentation.Game.viewModel.GameViewModel;
import com.company.Presentation.Game.viewModel.GameViewModelOutput;
import com.company.extention.UIViewController;
import com.company.utilities.ElementConfiguration;
import com.company.utilities.MonsterConfiguration;
import com.company.utilities.SkillsConfiguration;

import java.util.Scanner;

public class GameView extends UIViewController implements GameViewModelOutput {
    private GameViewModel viewModel;
    private boolean gameGoing = true;

    @Override
    protected void loadView() {
        super.loadView();
        // load skills from csv file
        SkillsConfiguration.shared.start();
        // load monsters from csv file
        MonsterConfiguration.shared.start();
        //load element from csv
        ElementConfiguration.shared.start();

        GameViewModel.config(this);
    }

    @Override
    protected void viewDidLoad() {
        super.viewDidLoad();
        System.out.println("Game Start!");
        viewModel.showPlayerCurrentMonster();
        while (gameGoing) {
            viewModel.showMenu();
        }
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        //todo : wip
        System.out.println("Looks like the game has ended, type 1 to continue your journey traveler");

        String selection = scan.next();
        this.navigationController.popToRootView();

    }

    public void setViewModel(GameViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void didTapShowMenu() {
        System.out.println("Menu.....");
        System.out.println("1. Show Monsters");
        System.out.println("2. Show current monster");
        System.out.println("3. Switch Monster");
        System.out.println("4. Move");
        System.out.println("5. End turn");
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Select option :");

        int selection = scan.nextInt();  // Read user input
        if (selection == 1){
            viewModel.showPlayerMonsters();
            viewModel.showMenu();
        } else if (selection == 2){
            viewModel.showPlayerCurrentMonster();
            viewModel.showMenu();
        } else if (selection == 3){
            viewModel.showPlayerMonsters();
            viewModel.switchMonster();
        } else if (selection == 4){
            viewModel.attackMonster();
        } else {
            this.gameGoing = false;
        }

    }

    @Override
    public void didAllMonstersDead() {
        System.out.println("You have lost!");
        this.gameGoing = false;
    }
}
