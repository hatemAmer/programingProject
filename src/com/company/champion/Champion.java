package com.company.champion;
/**
 * Write a description of Champion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import com.company.damageCulcolator.DamageCalculator;
import com.company.game.Square;
import com.company.move.Move;

import java.util.ArrayList;
import java.util.Random;

public class Champion {
    private ArrayList<Move> moves;
    private ChampionClass ActiveClasses[] = new ChampionClass[3];
    private ArrayList<DamageCalculator> currentDamageCalculator;
    private int player;// 0 1 2 3 4 5 6 7 8
    private Square squar;
    private int GoldCost, Health, VisonRange,                        //
            AttackRange, AttackDamage, MovementSpeed,                    //
            ManaStart;                                        //
    private double Armor, MagicResist, CriticalStrikeChance,         //   atributes
            CriticalStrikeDamage, ManaCost;                                  //
    private int level;//0 1 2
    private int ability;//1 -> 48
    private String Name;


    public Champion() {
        this.squar = new Square(1, 1);
        this.squar.setX(1);
        this.squar.setY(1);
        this.level = 0;
        this.player = 0;
    }

    public Champion(int GoldCost, int Health, int VisonRange
            , int AttackRange, int AttackDamage, int MovementSpeed,
                    int ManaStart, double ManaCost, double Armor,
                    double MagicResist, double CriticalStrikeChance,
                    double CriticalStrikeDamage, String name, int ability
            , ChampionClass x1, ChampionClass x2, ChampionClass x3) {
        this();
        this.GoldCost = GoldCost;
        this.Health = Health;
        this.Armor = Armor;
        this.MagicResist = MagicResist;
        this.VisonRange = VisonRange;
        this.AttackRange = AttackRange;
        this.AttackDamage = AttackDamage;
        this.MovementSpeed = MovementSpeed;
        this.CriticalStrikeChance = CriticalStrikeChance;
        this.CriticalStrikeDamage = CriticalStrikeDamage;
        this.ManaStart = ManaStart;
        this.ManaCost = ManaCost;
        this.ManaStart = ManaStart;
        this.Name = name;
        this.ability = ability;
        this.ActiveClasses[0] = x1;
        this.ActiveClasses[1] = x2;
        this.ActiveClasses[2] = x3;
    }


    public class ChampionAttributes {
        public void promot1() {
            Champion.this.AttackDamage += Champion.this.AttackDamage * 0.1;
            Champion.this.Health += Champion.this.Health * 0.2;
            Champion.this.Armor += Champion.this.Armor * 0.2;
            Champion.this.MagicResist += Champion.this.MagicResist * 0.2;
            Champion.this.level++;
        }

        public void promot2() {
            Champion.this.AttackDamage += Champion.this.AttackDamage * 0.15;
            Champion.this.Health += Champion.this.Health * 0.25;
            Champion.this.Armor += Champion.this.Armor * 0.25;
            Champion.this.MagicResist += Champion.this.MagicResist * 0.25;
            Champion.this.level++;
        }

        public int getGoldCost() {
            return GoldCost;
        }

        public void setGoldCost(int GoldCost) {
            Champion.this.GoldCost = GoldCost;
        }

        public int getHealth() {
            return Health;
        }

        public void setHealth(int Health) {
            Champion.this.Health = Health;
        }

        public int getVisonRange() {
            return VisonRange;
        }

        public void setVisonRange(int VisonRange) {
            Champion.this.VisonRange = VisonRange;
        }

        public int getAttackRange() {
            return AttackRange;
        }

        public void setAttackRange(int AttackRange) {
            Champion.this.AttackRange = AttackRange;
        }

        public int getAttackDamage() {
            return AttackDamage;
        }

        public void setAttackDamage(int AttackDamage) {
            Champion.this.AttackDamage = AttackDamage;
        }

        public int getMovementSpeed() {
            return MovementSpeed;
        }

        public void setMovementSpeed(int MovementSpeed) {
            Champion.this.MovementSpeed = MovementSpeed;
        }

        public int getManaStart() {
            return ManaStart;
        }

        public void setManaStart(int ManaStart) {
            Champion.this.ManaStart = ManaStart;
        }

        public double getManaCost() {
            return ManaCost;
        }

        public void setManaCost(double ManaCost) {
            Champion.this.ManaCost = ManaCost;
        }

        public double getArmor() {
            return Armor;
        }

        public void setArmor(double Armor) {
            Champion.this.Armor = Armor;
        }

        public double getMagicResist() {
            return MagicResist;
        }

        public void setMagicResist(double MagicResist) {
            Champion.this.MagicResist = MagicResist;
        }

        public double getCriticalStrikeChance() {//return (new Random()).nextDouble() <= Champion.this.CriticalStrikeChance;
            return Champion.this.CriticalStrikeChance;
        }

        public void setCriticalStrikeChance(double CriticalStrikeChance) {
            Champion.this.CriticalStrikeChance = CriticalStrikeChance;
        }

        public double getCriticalStrikeDamage() {
            return CriticalStrikeDamage;
        }

        public void setCriticalStrikeDamage(double CriticalStrikeDamage) {
            Champion.this.CriticalStrikeDamage = CriticalStrikeDamage;
        }

        public void setAbility(int ability) {
            Champion.this.ability = ability;
        }

        public int getAbility() {
            return Champion.this.ability;
        }

        public String getName() {
            return Champion.this.Name;
        }

        public void setName(String Name) {
            Champion.this.Name = Name;
        }

        public void setActiveClass1(ChampionClass CC) {
            Champion.this.ActiveClasses[0] = CC;
        }

        public ChampionClass getActiveClass1() {
            return ActiveClasses[0];
        }

        public void setActiveClass2(ChampionClass CC) {
            Champion.this.ActiveClasses[1] = CC;
        }

        public ChampionClass getActiveClass2() {
            return ActiveClasses[1];
        }

        public void setActiveClass3(ChampionClass CC) {
            Champion.this.ActiveClasses[2] = CC;
        }

        public ChampionClass getActiveClass3() {
            return ActiveClasses[2];
        }

        public Square getSquare() {
            return Champion.this.squar;
        }

        public void setSquare(Square s) {
            Champion.this.squar = s;
        }

        public void setPlayer(int player) {
            Champion.this.player = player;
        }

        public int getPlayer() {
            return Champion.this.player;
        }
    }


    public int getLevel() {
        return this.level;
    }

    public void AcceptDamage() {
    }

    public void GetIntendedDamage() {
    }

    public int getAbility() {
        return Champion.this.ability;
    }

    public void print() {
        System.out.println(this.Name + "  " + this.ability + "  ");
    }
}

