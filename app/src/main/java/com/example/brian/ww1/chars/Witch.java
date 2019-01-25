package com.example.brian.ww1.chars;

public class Witch extends Character{
    int heal = 1;
    int poison = 1;
    public Witch(String name){
        super();
        role = "Witch";
        association = 1;
        player = name;
//        ordering = 4;

    }

    public void heal(Character c) {
        c.setState(1);
        heal = 0;
        System.out.println("Witch Healed " + c.getRole());
    }

    public void poison(Character c) {
        c.setState(0);
        poison = 0;
        System.out.println("Witch Poisoned " + c.getRole());
    }

    public int getHeal() {
        return this.heal;
    }

    public int getPoison() {
        return this.poison;
    }
}
