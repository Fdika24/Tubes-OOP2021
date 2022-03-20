package com.company.Presentation.Game.viewModel;

import com.company.Presentation.Game.view.GameView;
import com.company.model.monsters.MonsterModel;
import com.company.model.monsters.MonsterState;
import com.company.model.Player;
import com.company.model.monsters.Stats;
import com.company.model.monsters.Alchu;
import java.util.Random;

import java.util.List;

public class GameViewModel {
    private Player player = new Player();
    private Alchu enemy = new Alchu();

    public static void config(GameView view) {
        GameViewModel vm = new GameViewModel(view);
        view.setViewModel(vm);
    }
    private GameViewModelOutput output;
    Random rand = new Random();

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
        Stats monsterStats = this.player.getMonster().getMonsterStats();
        Stats enemyStats = this.enemy.getMonsterStats();
        System.out.println("Enemy " + enemy.getName() + " health point : " + enemy.getMonsterStats().getHP() );
        //TODO: ADD ELEMENT EFFECTIVENESS
        double damage = (100 * (monsterStats.getAttackPoint() / enemyStats.getDefensePoint()) + 2) * rand.nextDouble();
        enemy.didTakeDamage(damage);
        if (enemy.getMonsterState() == MonsterState.DEAD){
            this.monsterIsDead();
            return;
        }
        System.out.println("Enemy " + enemy.getName() + " health point : " + enemy.getMonsterStats().getHP() );
    }

    private void monsterIsDead() {
        System.out.println("Seems like your monster is dead...");
        this.output.didAllMonstersDead();
//        int avail = player.getAvailMonster();
//        if (avail == -1){
//            this.output.didAllMonstersDead();
//            return;
//        }
//        player.setUseMonster(avail);
    }

    public void showMenu() {
        this.output.didTapShowMenu();
    }
}
