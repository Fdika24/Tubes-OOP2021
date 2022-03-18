package com.company.extention;

import java.util.Stack;

public class UINavigationController {
    private static Stack<UIViewController> navigationStack = new Stack<UIViewController>();
    public UINavigationController(UIViewController initialView) {
        navigationStack.push(initialView);
        this.instantiateView();
    }
    public void setInitialView(UIViewController initialView) {
        navigationStack.push(initialView);
        this.instantiateView();
    }
    /*
    what        : this function makes you navigate to a new view
    when to use : when you want to move to another view
*/
    final public void pushView(UIViewController view) {
        navigationStack.push(view);
        this.instantiateView();
    }
    final private void instantiateView() {
        navigationStack.peek().navigationController = this;
        navigationStack.peek().loadView();
        navigationStack.peek().viewDidLoad();
    }
    /*
    what        : this view pop your current view and navigate back to your previous view initial state,
    when to use : when you want to navigate back and get to it initial state
    avoid       : avoid using it in a loop
     */
    final public void popView() {
        navigationStack.peek().deleteView();
        navigationStack.peek().viewDidFinnish();
        if (navigationStack.size() > 1) {
            navigationStack.pop();
            this.instantiateView();
        } else {
            /// dev log only
            System.out.println("This is the initial view, you cannot pop it");
        }
    }
    /*
    what        :   this function pop your current view and get back to your last view and load it current state
    when to use :   Use it when you dont want to get back to your view initial state and want to get back to
                    it last state before you move to another view
     */
    final public void popViewLastState() {
        if (navigationStack.size() > 1) {
            navigationStack.pop();
        } else {
            /// dev log only
            System.out.println("This is the initial view, you cannot pop it");
        }
    }

    /*
        what        :   this function pop your first view
        when to use :   Use it when you dont want to get back to your view initial state and want to get back to
                        it last state before you move to another view
     */
    final public void popToRootView() {
        navigationStack.peek().deleteView();
        navigationStack.peek().viewDidFinnish();
        while (navigationStack.size() != 1) {
            navigationStack.pop();
        }
        this.instantiateView();
    }
}
