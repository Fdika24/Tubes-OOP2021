package com.company.Presentation.Main;

import com.company.Presentation.Game.view.GameView;
import com.company.extention.UIViewController;
import com.company.utilities.BasicUtils;

import java.util.InputMismatchException;
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
        int selection;
        System.out.println("View has been loaded...");
        BasicUtils.shared.sleepOnly();
        System.out.println("Welcome to Piku Monsters!");
        System.out.println("Menus : ");
        System.out.println("1. Start Game");
        System.out.println("2. How to Play");
        System.out.println("3. Exit Game");

        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Select option :");

        try {
            selection = scan.nextInt();
            BasicUtils.shared.loading();
            if (selection == 1) {
                UIViewController gameView = new GameView();
                this.navigationController.pushView(gameView);
            }
            else if (selection == 2) {
                this.howToPlay();
                this.viewDidLoad();
            }
            else {
                this.didSelectExitGame();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("\nThe input should be integer. Try again.\n");
            this.viewDidLoad();
        }
        finally {
            scan.close();
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

    protected void howToPlay() {
        System.out.println("==How to Play==");
        System.out.println("1. Pilih opsi Start Game untuk memulai permainan dan Exit Game untuk keluar dari permainan");
        System.out.println("2. Lihat monster yang sedang dipakai menggunakan Show current monster");
        System.out.println("3. Jika ingin mengganti monster yang dipakai, pilih Switch Monster");
        System.out.println("4. Daftar monster yang dapat dipilih bisa dilihat di Show Monsters");
        System.out.println("5. Gunakan Move untuk menyerang monster lawan");
        System.out.println("6. Pilih opsi Continue untuk melanjutkan ke giliran pemain selanjutnya");
        System.out.println("7. Jika ingin mundur dari lawan (keluar dari gane), gunakan opsi Run");
        System.out.println("Selamat bermain!");
        BasicUtils.shared.enterToContinue();
    }

    private void didSelectExitGame() {
        System.out.println("Thank you for playing!");
    }
}

