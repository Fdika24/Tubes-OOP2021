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
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");

        String userName = myObj.nextLine();  // Read user input
    }

    public void setViewModel(GameViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void didTapShowMenu() {
        System.out.println("Menu.....");
        System.out.println("1. Show Monsters");
        /*
        1. apa
        2. apa
        3. apa
         */
    }
}
