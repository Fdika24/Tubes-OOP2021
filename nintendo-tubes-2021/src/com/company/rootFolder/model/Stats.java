package com.company.rootFolder.model;

public class Stats {
    private double healthPoint;
    private double attackPoint;
    private double defensePoint;
    private double specialAttackPoint;
    private double specialDefensePoint;

    public Stats(
            double hp, double ap, double dp,
            double sap,double sdp
            ){
        this.attackPoint = ap;
        this.healthPoint = hp;
        this.defensePoint = dp;
        this.specialAttackPoint = sap;
        this.specialDefensePoint = sdp;
    }
}
