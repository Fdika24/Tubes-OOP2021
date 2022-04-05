package com.company.utilities;

import java.util.concurrent.TimeUnit;

public class BasicUtils {
    public static BasicUtils shared = new BasicUtils();
    public void loading() {
        try {
            this.clearScreen();
            System.out.println("Loading....");
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e){
            System.out.println("Could not do timeout");
        } finally {
            this.clearScreen();
        }
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public int getRandomNumberWithException(int[] e) {
        return 0;
    }

    public void sleepOnly() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e){
            System.out.println("Could not do timeout");
        } finally {
            this.clearScreen();
        }
    }

    public void sleepOnly(int dur) {
        try {
            TimeUnit.SECONDS.sleep(dur);
        } catch (Exception e){
            System.out.println("Could not do timeout");
        } finally {
            this.clearScreen();
        }
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    public void enterToContinue(){
        System.out.println("Press enter to continue");
        try{
            System.in.read();
        } catch(Exception e){
            System.out.println("Could not continue");
        } finally {
            this.clearScreen();
        }
    }
}
