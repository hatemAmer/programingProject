package com.company.damageCulcolator;

import com.company.champion.Champion;

public class BasicAttackDodgeCalculator extends DamageCalculator {

    public BasicAttackDodgeCalculator(DamageCalculator damageCalculator, Champion championSrc) {
        super(damageCalculator, championSrc);
        this.setAttackDamage(damageCalculator.getAttackDamage());
        this.setHealthChange(damageCalculator.getHealthChange());
        this.CalculateIntendedDamage();
    }

    public void CalculateIntendedDamage(){
        this.setHealthChange( this.getAttackDamage() - (this.getAttackDamage()*this.getChampionSrc().new ChampionAttributes().getArmor()));
    }


}
