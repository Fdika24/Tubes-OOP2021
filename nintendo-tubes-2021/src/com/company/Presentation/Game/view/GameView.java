package com.company.Presentation.Game.view;

import com.company.Presentation.Game.viewModel.GameViewModel;
import com.company.Presentation.Game.viewModel.GameViewModelOutput;
import com.company.extention.UIViewController;
import com.company.utilities.BasicUtils;
import com.company.utilities.ElementConfiguration;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameView extends UIViewController implements GameViewModelOutput {
    private GameViewModel viewModel;
    private boolean gameGoing = true;

    @Override
    protected void loadView() {
        super.loadView();
        //load element from csv
        ElementConfiguration.shared.start();

        GameViewModel.config(this);

        viewModel.viewWillLoad();
    }

    @Override
    protected void viewDidLoad() {
        super.viewDidLoad();
        System.out.println("Game Start!");
        BasicUtils.shared.loading();
        while (gameGoing) {
            viewModel.showMenu();
        }
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        //todo : wip
        System.out.println("Looks like the game has ended");
        BasicUtils.shared.enterToContinue();
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
        System.out.println("5. Continue");
        System.out.println("0. Run");
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Select option :");

        int selection = scan.nextInt();  // Read user input
        BasicUtils.shared.loading();
        if (selection == 1){
            viewModel.showPlayerMonsters();
            BasicUtils.shared.enterToContinue();
        } else if (selection == 2){
            viewModel.showPlayerCurrentMonster();
        } else if (selection == 3){
            viewModel.showPlayerMonsters();
            try {
                viewModel.switchMonster();
            }
            catch (InputMismatchException e) {
                System.out.println("\nThe input should be integer. Try again.\n");
                viewModel.switchMonster();
            }
        } else if (selection == 4){
            try {
                viewModel.useMove();
            }
            catch (InputMismatchException e) {
                System.out.println("\nThe input should be integer. Try again.\n");
                viewModel.useMove();
            }
        } else if (selection == 5) {
            this.didSuccessDoAction();
        }
        else {
            this.gameGoing = false;
        }
    }

    @Override
    protected void viewDidFinnish() {
        super.viewDidFinnish();
        BasicUtils.shared.loading();
    }

    @Override
    public void didAllMonstersDead() {
        this.gameGoing = false;
    }

    @Override
    public void didSuccessDoAction() {
        viewModel.changeWho();
    }

    @Override
    public void didFailDoAction() {
        System.out.println("Reloading menu...");
        BasicUtils.shared.sleepOnly();
    }
}
