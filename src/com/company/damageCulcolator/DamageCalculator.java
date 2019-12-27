package com.company.damageCulcolator;

import com.company.champion.Champion;

import java.io.Serializable;

/**
 * Write a description of DamageCalculator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DamageCalculator implements Serializable {
    protected DamageCalculator currentDamageCalculator;
    private Champion championSrc;
    private double AttackDamage;
    private double healthChange;

    public void CalculateIntendedDamage(){
        this.AttackDamage = (championSrc.new ChampionAttributes().getAttackDamage());
    }

    protected DamageCalculator(DamageCalculator damageCalculator,Champion championSrc){
        this.currentDamageCalculator = damageCalculator;
        this.championSrc = championSrc;
        this.CalculateIntendedDamage();
    }

    public DamageCalculator(Champion championSrc){
        this.championSrc = championSrc;
        this.CalculateIntendedDamage();
    }

    public Champion getChampionSrc(){
        return championSrc;
    }

    public double getAttackDamage() {
        return AttackDamage;
    }

    public void setAttackDamage(double attackDamage) {
        AttackDamage = attackDamage;
    }

    public double getHealthChange() {
        return healthChange;
    }

    public void setHealthChange(double healthChange) {
        this.healthChange = healthChange;
    }

}
