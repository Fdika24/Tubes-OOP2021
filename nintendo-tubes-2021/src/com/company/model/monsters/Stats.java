package com.company.model.monsters;

import com.company.model.moveModel.BuffConstant;

public class Stats {
    private double healthPoint;
    private double attackPoint;
    private double defensePoint;
    private double specialAttackPoint;
    private double specialDefensePoint;
    private double speedPoint;
    public final double initialHP;
    private final double initialAttackPoint;
    private final double initialDefensePoint;
    private final double initialSpecialAttackPoint;
    private final double initialSpecialDefensePoint;
    private final double initialSpeedPoint;

    public Stats(
            double hp, double ap, double dp,
            double sap,double sdp, double sp
            ){
        this.attackPoint = ap;
        this.healthPoint = hp;
        this.defensePoint = dp;
        this.specialAttackPoint = sap;
        this.specialDefensePoint = sdp;
        this.speedPoint = sp;

        this.initialHP = hp;
        this.initialAttackPoint = ap;
        this.initialDefensePoint = dp;
        this.initialSpecialAttackPoint = sap;
        this.initialSpecialDefensePoint = sdp;
        this.initialSpeedPoint = sp;
    }

    public double getHP() {
        if (this.healthPoint <= 0){
            this.healthPoint = 0;
        }
        return this.healthPoint;
    }

    public void setHP(double value) {
        this.healthPoint = value;
        if (this.healthPoint > this.initialHP) {
            this.healthPoint = this.initialHP;
        }
    }

    public double getAttackPoint() {
        return this.attackPoint;
    }
    public double getSpeedPoint() {
        return this.speedPoint;
    }
    public double getDefensePoint() {
        return this.defensePoint;
    }
    public double getSpecialAttackPoint() {
        return  this.specialAttackPoint;
    }
    public double getSpecialDefensePoint(){
        return this.specialDefensePoint;
    }
    public double getInitialHP() { return  this.initialHP; }

    public void decreaseHp(double value) {
        this.healthPoint -= value;
    }

    public void showStatsInfo(){
        System.out.println("Stats : ");
        System.out.println("Health point : " + this.healthPoint);
        System.out.println("Attack point : " + this.attackPoint);
        System.out.println("Defense point : " + this.defensePoint);
        System.out.println("Special Attack point : " + this.specialAttackPoint);
        System.out.println("Special Defense point : " + this.specialDefensePoint);
        System.out.println("Speed point : " + this.speedPoint);
    }

    public void didChangeMonster() {
        this.attackPoint = initialAttackPoint;
        this.specialAttackPoint = initialSpecialAttackPoint;
        this.defensePoint = initialDefensePoint;
        this.specialDefensePoint = initialSpecialDefensePoint;
        this.speedPoint = initialSpeedPoint;
    }

    public void setBuff(Stats buff) {
        this.attackPoint = BuffConstant.shared.getBuffConstant((int) buff.getAttackPoint());
        this.defensePoint = BuffConstant.shared.getBuffConstant((int) buff.getDefensePoint());
        this.speedPoint = BuffConstant.shared.getBuffConstant((int) buff.getSpeedPoint());
        this.specialAttackPoint = BuffConstant.shared.getBuffConstant((int) buff.getSpecialAttackPoint());
        this.specialDefensePoint = BuffConstant.shared.getBuffConstant((int) buff.getSpecialDefensePoint());
    }
}
