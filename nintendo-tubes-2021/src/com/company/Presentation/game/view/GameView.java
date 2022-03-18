package com.company.Presentation.game.view;

import com.company.Presentation.game.viewModel.GameViewModel;
import com.company.Presentation.game.viewModel.GameViewModelOutput;
import com.company.extention.UIViewController;
import com.company.model.Element;
import com.company.model.ElementType;

import java.util.HashMap;
import java.util.Scanner;

public class GameView extends UIViewController implements GameViewModelOutput {
    private HashMap<ElementType, Element> elementList = new HashMap<ElementType, Element>();
    private GameViewModel viewModel;
    private boolean gameGoing = true;

    @Override
    protected void loadView() {
        super.loadView();
        GameViewModel.config(this);
        elementList.put(ElementType.FIRE, new Element(
                ElementType.FIRE,
                ElementType.GRASS,
                1));
    }

    @Override
    protected void viewDidLoad() {
        super.viewDidLoad();
        viewModel.showPlayerMonsters();
        while (gameGoing) {
            viewModel.showMenu();
        }
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
