package com.company.Presentation.game.viewModel;

import com.company.Presentation.game.view.GameView;
import com.company.model.MonsterModel;
import com.company.model.Player;
import com.company.model.monsters.Alchu;

import java.util.List;

public class GameViewModel {
    private Player player = new Player();
    private Alchu enemy = new Alchu();

    public static void config(GameView view) {
        GameViewModel vm = new GameViewModel(view);
        view.setViewModel(vm);
    }
    private GameViewModelOutput output;

    public GameViewModel() {

    }

    public GameViewModel(GameViewModelOutput output) {
        this.output = output;
    }
    //MARK
    public void showPlayerMonsters() {
        System.out.println("Player Monsters :");
        List<MonsterModel> playerMonsters = player.getMonsters();
        for (int i = 0; i < playerMonsters.size();i++) {
            System.out.print("no." + (i+1) + " ");
            System.out.println(playerMonsters.get(i).getName() + ", Status : " + playerMonsters.get(i).getMonsterState());
        }
    }
    //MARK
    public void showPlayerCurrentMonster() {
        System.out.println("Player Monsters :");
        System.out.println(this.player.getMonster().getName() + ", Status : " + this.player.getMonster().getMonsterState());
    }

    //MARK
    public void switchMonster() {
        this.player.setUseMonster(2);
    }

    public void attackMonster() {
        //this.player.getMonster();
    }
    public void showMenu() {
        this.output.didTapShowMenu();
    }
}
