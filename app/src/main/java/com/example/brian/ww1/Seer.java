package com.example.brian.ww1;

public class Seer  extends Character{

    Seer(String name){
        super();
        role = "Seer";
        association = 1;
        player = name;
        ordering = 3;
    }

    public void checkAssociation(Character c) {
        String association;
        if (c.getAssociation() == 0) {association = "Bad";} else {association = "Good";}
        System.out.println( "This person is " + association);
    }

}
