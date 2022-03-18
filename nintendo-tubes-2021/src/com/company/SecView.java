package com.company;

import com.company.extention.UIViewController;

public class SecView extends UIViewController {
    @Override
    protected void viewDidLoad() {
        super.viewDidLoad();
        System.out.println("LoadSecView");
        this.navigationController.popView();
    }
}
