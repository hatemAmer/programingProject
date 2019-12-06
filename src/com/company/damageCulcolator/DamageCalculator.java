package com.company.damageCulcolator;

import com.company.champion.Champion;

/**
 * Write a description of DamageCalculator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class DamageCalculator {

    public abstract void calculatorIntededDamage(Champion champion);

    protected abstract void damageCalculator(DamageCalculator damage);


}
