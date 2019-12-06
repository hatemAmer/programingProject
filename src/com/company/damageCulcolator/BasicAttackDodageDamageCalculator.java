package com.company.damageCulcolator;

import com.company.champion.Champion;
import com.company.game.Square;
import com.company.move.Move;

public class BasicAttackDodageDamageCalculator extends DamageCalculator {
    Square squareAttack;
    int damage;

    public void calculatorIntededDamage(Champion champion, Move move) {
        double armor = champion.new ChampionAttributes().getArmor();
        this.damage = (int) (champion.new ChampionAttributes().getAttackDamage() * armor);


    }

    @Override
    public void calculatorIntededDamage(Champion champion) {

    }

    @Override
    protected void damageCalculator(DamageCalculator damage) {

    }
}
