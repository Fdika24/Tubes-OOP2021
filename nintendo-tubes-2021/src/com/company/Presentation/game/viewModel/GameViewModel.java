package com.company.Presentation.game.viewModel;

import com.company.Presentation.game.view.GameView;
import com.company.model.MonsterModel;
import com.company.model.Player;

import java.util.List;

public class GameViewModel {
    private Player player = new Player();
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
    public void showPlayerMonsters() {
        System.out.println("Player Monsters :");
        List<MonsterModel> playerMonsters = player.getMonsters();
        for (int i = 0; i < playerMonsters.size();i++) {
            System.out.print("no." + (i+1) + " ");
            System.out.println(playerMonsters.get(i).getName() + ", Status : " + playerMonsters.get(i).getMonsterState());
        }
    }
    public void attackMonster() {
        this.player.getMonster();
    }
    public void showMenu() {
        this.output.didTapShowMenu();
    }
}
