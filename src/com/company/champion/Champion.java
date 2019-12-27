package com.company.champion;
/**
 * Write a description of com.company.Champion.Champion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import com.company.damageCulcolator.DamageCalculator;
import com.company.move.Move;
import com.company.game.Square;
import com.company.champion.ChampionClass;
import com.company.damageCulcolator.DamageCalculator;
import com.company.game.Square;
import com.company.move.Move;

import java.io.Serializable;

public class Champion implements Serializable {
    private Move moves;
    private ChampionClass ActiveClasses[] = new ChampionClass[3];
    private DamageCalculator currentDamageCalculator;
    private int player;// 0 1 2 3 4 5 6 7 8
    private Square squar;
    private int GoldCost;
    private int Health;
    private int MaxHealth;
    private int VisonRange;
    private int AttackRange;
    private int AttackDamage;
    private int MovementSpeed;
    private int ManaStart;
    private int championNumber;
    private double Armor, MagicResist, CriticalStrikeChance,
            CriticalStrikeDamage, ManaCost;
    private int level;//0 1 2
    private int stuns;
    private String Name;


    public Champion() {
        this.squar = new Square(1, 1);
        this.squar.setX(-1);
        this.squar.setY(-1);
        this.level = 1;
        this.player = 0;
    }

    public Champion(int GoldCost, int Health, int VisonRange
            , int AttackRange, int AttackDamage, int MovementSpeed,
                    int ManaStart, double ManaCost, double Armor,
                    double MagicResist, double CriticalStrikeChance,
                    double CriticalStrikeDamage, String name
            , ChampionClass x1, ChampionClass x2, ChampionClass x3,int id) {
        this();
        this.GoldCost = GoldCost;
        this.Health = Health;
        this.MaxHealth = Health;
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
        this.ActiveClasses[0] = x1;
        this.ActiveClasses[1] = x2;
        this.ActiveClasses[2] = x3;
        this.championNumber = id;
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
            Champion.this.ManaStart = Math.max(1,Champion.this.ManaStart);
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
            Champion.this.Armor = Math.max(0,Armor);
        }

        public double getMagicResist() {
            return MagicResist;
        }

        public void setMagicResist(double MagicResist) {
            Champion.this.MagicResist = MagicResist;
        }

        public double getCriticalStrikeChance() {
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

        public Move getMoves() {
            return moves;
        }

        public void setMoves(Move moves) {
            Champion.this.moves = moves;
        }

        public int getChampionNumber() {
            return championNumber;
        }

        public void setChampionNumber(int championNumber) {
            Champion.this.championNumber = championNumber;
        }

        public int getLevel() {
            return Champion.this.level;
        }

        public int getStuns() {
            return stuns;
        }

        public void setStuns(int stuns) {
            Champion.this.stuns += stuns;
        }

        public int getMaxHealth() {
            return MaxHealth;
        }

    }

    public void AcceptDamage(){
        this.new ChampionAttributes().setHealth(this.Health-(int)this.currentDamageCalculator.getHealthChange());
    }

    public void GetIntendedDamage(){
        this.currentDamageCalculator = new DamageCalculator(this);

    }


    public DamageCalculator getCurrentDamageCalculator() {
        return currentDamageCalculator;
    }

    public void setCurrentDamageCalculator(DamageCalculator currentDamageCalculator) {
        this.currentDamageCalculator = currentDamageCalculator;
    }

    public String toString(){
        return new String("Name:"+this.Name + "  Armor:" + this.Armor + "  AttackDamage:" + this.AttackDamage + " AttackRange:" + this.AttackRange + " GoldCost" +this.GoldCost
                + " Player:" + this.player + " position:" + this.squar + " Health:" +this.Health + " VisionRange:" + this.VisonRange
                +" (" + ActiveClasses[0] + "." + ActiveClasses[1] + "." + ActiveClasses[2] + ")" + " level:" + this.level+" Mana:"+this.ManaStart +" ABCost:" + this.ManaCost
        + "Movment SP:"+this.MovementSpeed);

    }
}