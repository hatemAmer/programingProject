package com.company.damageCulcolator;

import com.company.champion.Champion;

import java.util.Random;

public class BasicAttackDamageCalculator extends DamageCalculator {
    public BasicAttackDamageCalculator(DamageCalculator damageCalculator, Champion championSrc) {
        super(damageCalculator,championSrc);
        super.setAttackDamage(damageCalculator.getAttackDamage());
        super.setHealthChange(damageCalculator.getHealthChange());
        this.CalculateIntendedDamage();
    }
    public void CalculateIntendedDamage(){
        boolean criticalStrikeChance = (new Random()).nextDouble() <= super.getChampionSrc().new ChampionAttributes().getCriticalStrikeChance();
        double criticalStrikeDamage = super.getChampionSrc().new ChampionAttributes().getCriticalStrikeDamage();
        if(criticalStrikeChance)
            super.setAttackDamage((super.getAttackDamage()*criticalStrikeDamage));
        //System.out.println("From Calc2 : " + super.getAttackDamage());
    }
}
