package com.company.damageCulcolator;

import com.company.champion.Champion;
import com.company.game.Square;
import com.company.move.Move;

public class BasicAttackDamageCalculator extends DamageCalculator {
    Square squareAttack;
    int damage;

    public void calculatorIntededDamage(Champion champion, Move move) {
        this.damage = champion.new ChampionAttributes().getAttackDamage();

    }

    @Override
    public void calculatorIntededDamage(Champion champion) {

    }

    @Override
    protected void damageCalculator(DamageCalculator damage) {

    }
}
