package com.company.Presentation.Game.viewModel;

import com.company.Presentation.Game.view.GameView;
import com.company.model.ElementType;
import com.company.model.monsters.MonsterModel;
import com.company.model.monsters.MonsterState;
import com.company.model.Player;
import com.company.model.monsters.Stats;
import com.company.model.monsters.Alchu;
import com.company.model.moveModel.EffectType;
import com.company.model.moveModel.Move;
import com.company.model.moveModel.MoveTarget;
import com.company.model.moveModel.MoveType;
import com.company.utilities.BasicUtils;
import com.company.utilities.ElementConfiguration;
import com.company.model.ElementTypePair;

import java.util.*;

import java.util.concurrent.TimeUnit;

public class GameViewModel {
    private int who = 1;
    private List<Player> players = new ArrayList<Player>();
    private int[] moveSelection =  {-1,-1};

    public void viewWillLoad() {
        players.get(0).init();
        players.get(1).init();
    }

    public static void config(GameView view) {
        GameViewModel vm = new GameViewModel(view);
        vm.players.add(new Player());
        vm.players.add(new Player());
        view.setViewModel(vm);
    }
    private GameViewModelOutput output;

    public void changeWho() {
        if (who == 1) {
            who = 2;
        } else if (who == 2){
            who = 3;
        } else {
            who = 1;
        }
    }

    public void endAllTurn() {
        this.startAttacking();
        this.moveSelection[0] = -1;
        this.moveSelection[1] = -1;
    }

    private void playerTwoAction(MonsterModel m2, double dmg2) {
        System.out.println("Player two " + m2.getName() + " use " + m2.getMoveName(moveSelection[1] ));
        System.out.println("Player two " + m2.getName() + " deals " + dmg2);
    }

    private void playerOneAction(MonsterModel m1, double dmg1) {
        System.out.println("Player one " + m1.getName() + " use " + m1.getMoveName(moveSelection[0]));
        System.out.println("Player one " + m1.getName() + " deals " + dmg1);
    }

    private void startAttacking() {
        MonsterModel m1 = players.get(0).getMonster();
        MonsterModel m2 = players.get(1).getMonster();
        double dmg1 = 0;
        double dmg2 = 0;

        // jika sama
        if (m1.getMonsterStats().getSpeedPoint() == m2.getMonsterStats().getSpeedPoint()) {
            if (m1.getMovePriority(moveSelection[0]) > m2.getMovePriority(moveSelection[1])) {
                dmg1 = getDamage(0);
                m2.didTakeDamage(dmg1);
                System.out.println("Player one " + m1.getName() + " use " + m1.getMoveName(moveSelection[0]));
                System.out.println("Player one " + m1.getName() + " deals " + dmg1);
                if (m2.isMonsterAlive()) {
                    dmg2 = getDamage(1);
                    m1.didTakeDamage(dmg2);
                    System.out.println("Player two " + m2.getName() + " use " + m2.getMoveName(moveSelection[1] ));
                    System.out.println("Player two " + m2.getName() + " deals " + dmg2);
                }
            } else  {
                dmg2 = getDamage(1);
                m1.didTakeDamage(dmg2);
                System.out.println("Player two " + m2.getName() + " use " + m2.getMoveName(moveSelection[1]));
                System.out.println("Player two " + m2.getName() + " deals " + dmg2);
                if (m1.isMonsterAlive()) {
                    dmg1 = getDamage(0);
                    m2.didTakeDamage(dmg1);
                    System.out.println("Player one " + m1.getName() + " use " + m1.getMoveName(moveSelection[0]));
                    System.out.println("Player one " + m1.getName() + " deals " + dmg1);
                }
            }
        }
        // jika m1 besar dari m1
        else if (m1.getMonsterStats().getSpeedPoint() > m2.getMonsterStats().getSpeedPoint()) {
            dmg1 = getDamage(0);
            m2.didTakeDamage(dmg1);
            System.out.println("Player one " + m1.getName() + " use " + m1.getMoveName(moveSelection[0] ));
            System.out.println("Player one " + m1.getName() + " deals " + dmg1);
            if (m2.isMonsterAlive()) {
                dmg2 = getDamage(1);
                m1.didTakeDamage(dmg2);
                System.out.println("Player two " + m2.getName() + " use " + m2.getMoveName(moveSelection[1] ));
                System.out.println("Player two " + m2.getName() + " deals " + dmg2);
            }
        }
        // jika m2 > m1
        else {
            dmg2 = getDamage(1);
            System.out.println("Player two " + m2.getName() + " use " + m2.getMoveName(moveSelection[1] ));
            System.out.println("Player two " + m2.getName() + " deals " + dmg2);
            m1.didTakeDamage(dmg2);
            if (m1.isMonsterAlive()) {
                dmg1 = getDamage(0);
                m2.didTakeDamage(dmg1);
                System.out.println("Player one " + m1.getName() + " use " + m1.getMoveName(moveSelection[0]));
                System.out.println("Player one " + m1.getName() + " deals " + dmg1);
            }
        }

        if (m1.getMonsterAffectedBy() != EffectType.NONE){
            System.out.println("Player one " + m1.getName() + " affected by " + m1.getMonsterAffectedBy());
        }
        getEffectValue(m1);
        if (m2.getMonsterAffectedBy() != EffectType.NONE) {
            System.out.println("Player two " + m2.getName() + " affected by " + m2.getMonsterAffectedBy());
        }
        getEffectValue(m2);
    }

    private void getEffectValue(MonsterModel monster) {
        double dmg = 0;
        switch (monster.getMonsterAffectedBy()) {
            case BURN:
                dmg = monster.getMonsterStats().getInitialHP()/8;
                System.out.println("BURN DAMAGE : " +  dmg);
                break;
            case POISON:
                dmg = monster.getMonsterStats().getInitialHP()/16;
                System.out.println("POISON DAMAGE : " +  dmg);
                break;
            default :
                dmg = 0;
                break;
        }
        monster.getMonsterStats().decreaseHp(dmg);
    }

    public double getBurnValue(MonsterModel monster) {
        if (monster.getMonsterAffectedBy() == EffectType.BURN) {
            return 0.5;
        }
        else {
            return 1;
        }
    }

    //TODO: ADD DAMAGE CALCULATION
    private double getDamage(int who) {
        double damage = 0;
        if (moveSelection [who] == -1) {
            return damage;
        }
        Move pMove = players.get(who).getMonster().useMonsterMove(moveSelection[who] );
        MonsterModel pMonster = players.get(who).getMonster();
        ElementTypePair elementTypePair = new ElementTypePair(pMove.elementType, players.get(who == 0 ? 1:0).getMonster().getElements().get(0));
        switch (pMove.moveType){
            case NORMAL:
                damage = Math.floor((pMove.baseAttack * (pMonster.getMonsterStats().getAttackPoint()/players.get(who == 0 ? 1:0).getMonster().getMonsterStats().getDefensePoint()) + 2) * ((Math.random()/100*15)+0.85) * ElementConfiguration.shared.getEffectivityValue(elementTypePair) * getBurnValue(pMonster));
                break;
            case SPECIAL:
                damage = Math.floor((pMove.baseAttack * (pMonster.getMonsterStats().getSpecialAttackPoint()/players.get(who == 0 ? 1:0).getMonster().getMonsterStats().getSpecialDefensePoint()) + 2) * ((Math.random()/100*15)+0.85) * ElementConfiguration.shared.getEffectivityValue(elementTypePair) * getBurnValue(pMonster));
                break;
            case STATS:
                damage = 0;
                if (pMove.target == MoveTarget.OWN) {
                    if (pMove.name == "Heal") {
                        players.get(who).getMonster().getMonsterStats().setHP(pMove.getMoveEffect().getHP());
                    }
                    else {
                        players.get(who).getMonster().applyBuff(pMove.getMoveEffect());
                    }
                } else  {
                    players.get(who == 0 ? 1:0).getMonster().setMonsterAffectedBy(pMove.effectType);
                }
                break;
        }
        return damage;
    }

    public GameViewModel(GameViewModelOutput output) {
        this.output = output;
    }
    //MARK
    public void showPlayerMonsters() {
        System.out.println("Player Monsters :");
        List<MonsterModel> playerMonsters = players.get(who - 1).getMonsters();
        for (int i = 0; i < playerMonsters.size();i++) {
            System.out.print("no." + (i+1) + " ");
            System.out.println(playerMonsters.get(i).getName() + ", Status : " + playerMonsters.get(i).getMonsterState());
            System.out.println("Health : " + playerMonsters.get(i).getMonsterStats().getHP());
        }
    }
    //MARK
    public void showPlayerCurrentMonster() {
        System.out.println("Player Monsters :" + this.players.get(who - 1).getMonster().getName());
        System.out.println("Status : " + this.players.get(who - 1).getMonster().getMonsterState());
        System.out.println("Elements : " + this.players.get(who - 1).getMonster().getElements());
        System.out.println("HP : " + this.players.get(who - 1).getMonster().getMonsterStats().getHP());
        BasicUtils.shared.enterToContinue();
    }

    //MARK
    public void switchMonster() {
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Select Monster [Integer] : ");
        int selection = scan.nextInt();
        if (this.players.get(who - 1).setUseMonster(selection - 1)) {
            BasicUtils.shared.enterToContinue();
            this.output.didSuccessDoAction();
        } else {
            this.switchMonster();
        }
    }

    public void useMove() {
        if ( players.get(who -1).getMonster().getMonsterAffectedBy() == EffectType.SLEEP){
            System.out.println("Cannot use move, monster is affected by sleep for " + players.get(who -1).getMonster().getSleepDuration() + " round");
            BasicUtils.shared.enterToContinue();
            this.output.didTapShowMenu();
            return;
        }
        if (players.get(who - 1).getMonster().getMonsterAffectedBy() == EffectType.PARALYZE) {
            System.out.println("Cannot use move, monster is affected by paralyze for 1 round");
            BasicUtils.shared.enterToContinue();
            this.output.didTapShowMenu();
            return;
        }
        players.get(who -1).getMonster().showMonsterMoves();
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Select option :");

        int selection = scan.nextInt();
        if (players.get(who -1).getMonster().isMoveAvail(selection - 1)) {
            this.moveSelection[who - 1] = selection -1;
        } else {
            System.out.println("Move is not available");
            this.useMove();
        }
        this.output.didSuccessDoAction();
        BasicUtils.shared.loading();
    }

    private void showHealths() {
        if (players.get(0).getMonster().isMonsterAlive()) {
            System.out.println("Player one " + players.get(0).getMonster().getName() + " hp : " + players.get(0).getMonster().getHp());
            if (players.get(0).getMonster().getMonsterAffectedBy() != EffectType.NONE){
                System.out.printf(players.get(0).getMonster().getName() + " is affect by " + players.get(0).getMonster().getMonsterAffectedBy());
                System.out.println(players.get(0).getMonster().getMonsterAffectedBy() == EffectType.SLEEP ? (" for the next " + players.get(0).getMonster().getSleepDuration() + " round") : "");
            }
        } else {
            System.out.println("Player one " + players.get(0).getMonster().getName() + " is Dead");
            if (players.get(0).isMonsterAllDead()) {
                this.monsterIsDead(1);
            } else {
                players.get(0).setUseMonster(players.get(0).getAvailMonster());
            }
        }

        if (players.get(1).getMonster().isMonsterAlive()) {
            System.out.println("Player two " + players.get(1).getMonster().getName() + " hp :  " + players.get(1).getMonster().getHp());
            if (players.get(1).getMonster().getMonsterAffectedBy() != EffectType.NONE){
                System.out.printf(players.get(1).getMonster().getName() + " is affect by " + players.get(1).getMonster().getMonsterAffectedBy());
                System.out.println(players.get(1).getMonster().getMonsterAffectedBy() == EffectType.SLEEP ? ("for the next " + players.get(1).getMonster().getSleepDuration() + " round") : "");
            }
        } else {
            System.out.println("Player two " + players.get(1).getMonster().getName() + " is Dead");
            if (players.get(1).isMonsterAllDead()) {
                this.monsterIsDead(0);
            } else {
                players.get(1).setUseMonster(players.get(1).getAvailMonster());
            }
        }
    }

    private void monsterIsDead(int who) {
        System.out.println("Seems like player " + (who+1) + " have defeated enemy monster");
        this.output.didAllMonstersDead();
    }

    private void deleteEffect() {
        MonsterModel m1 = players.get(0).getMonster();
        if (m1.getMonsterAffectedBy() == EffectType.PARALYZE) {
            m1.setMonsterAffectedBy(EffectType.NONE);
        }
        MonsterModel m2 = players.get(1).getMonster();
        if (m2.getMonsterAffectedBy() == EffectType.PARALYZE) {
            m2.setMonsterAffectedBy(EffectType.NONE);
        }
    }

    public void showMenu() {
        if (who == 3) {
            endAllTurn();
            this.showHealths();
            this.deleteEffect();
            this.changeWho();
            BasicUtils.shared.enterToContinue();
            return;
        }
        System.out.println("It's Player " + who + " Turn");
        this.players.get(who - 1).getMonster().reduceSleepTime();
        this.output.didTapShowMenu();
    }
}
