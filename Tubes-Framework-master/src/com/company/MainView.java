package com.company;

import com.company.extention.UIViewController;

import java.util.Scanner;

public class MainView extends UIViewController {
    // called when initializing view
    @Override
    protected void loadView() {
        super.loadView();
        System.out.println("Loading view...");
    }

    // called after you're done initializing the view
    @Override
    protected void viewDidLoad() {
        super.viewDidLoad();
        System.out.println("View has been loaded...");
        SecView view = new SecView();
        System.out.printf("Pilihan  : ");
        int scan = new Scanner(System.in).nextInt();
        if (scan == 1){
            this.navigationController.pushView(view);
        } else {
            this.navigationController.popView();
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
}

