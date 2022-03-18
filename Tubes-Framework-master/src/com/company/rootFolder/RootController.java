package com.company.rootFolder;

import com.company.MainView;
import com.company.extention.UINavigationController;
import com.company.extention.UIViewController;


public class RootController {
    // this is root navigationController
    private UINavigationController navigationController;
    // This is the first view when you open the app
    private UIViewController rootView = new MainView(); // <-- change this if needed
    public void start() {
        navigationController =  new UINavigationController(rootView);
    }
}
