package com.example.brian.ww1;

import com.example.brian.ww1.chars.Character;
import com.example.brian.ww1.chars.Hunter;
import com.example.brian.ww1.chars.Seer;
import com.example.brian.ww1.chars.Tanner;
import com.example.brian.ww1.chars.Villager;
import com.example.brian.ww1.chars.Werewolf;
import com.example.brian.ww1.chars.Witch;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    HashMap<Integer, ArrayList<String>> ordering = new HashMap();
    public ArrayList<Character> villagerList = new ArrayList<Character>();
    public ArrayList<Character> werewolfList = new ArrayList<Character>();
    public ArrayList<Character> characterList = new ArrayList<Character>();


    Game() {
        defineOrder();
    }

    public void setState(HashMap<String, ArrayList<String>> state){
        for (String role:state.keySet()){
            for (String player:state.get(role)){
                Character charToAdd = createChar(role, player);
                addCharacter(charToAdd);
            }
        }


    }

    public Character createChar(String character, String player){
        Character c = new Character();
        switch(character){
            case("Villager"):
                c = new Villager(player);
                break;
            case("Tanner"):
                c = new Tanner(player);
                break;
            case("Hunter"):
                c = new Hunter(player);
                break;
            case("Werewolf"):
                c = new Werewolf(player);
                break;
            case("Seer"):
                c = new Seer(player);
                break;
            case("witch"):
                c = new Witch(player);
                break;
        }

        return c;


    }

    public void addCharacter(Character c) {
        if (c.getAssociation() == 0) {
            werewolfList.add(c);
        } else {
            villagerList.add(c);
        }
        characterList.add(c);
    }

    public String toString() {
        String s = "";
        s += "VillagerList: " + villagerList.toString() + "\n";
        s += "WerewolfList: " + werewolfList.toString() + "\n";
        s += "CharacterList: " + characterList.toString();
        return s;
    }

    //ORDERING DEFINITION HERE
    public void defineOrder(){
        //People who don't do anything at night
        ArrayList<String> zero = new ArrayList<>();
        zero.add("Villager");
        zero.add("Tanner");
        zero.add("Hunter");
        ordering.put(0, zero);

        //Everyone else:
        ArrayList<String> one = new ArrayList<>();
        one.add("Bodyguard");
        ordering.put(1, one);

        ArrayList<String> two = new ArrayList<>();
        two.add("Werewolf");
        ordering.put(2, two);

        ArrayList<String> three = new ArrayList<>();
        three.add("Vigilante");
        ordering.put(3, three);

        ArrayList<String> four = new ArrayList<>();
        four.add("Witch");
        ordering.put(4, four);


        ArrayList<String> five = new ArrayList<>();
        five.add("Seer");
        ordering.put(5, five);

        ArrayList<String> six = new ArrayList<>();
        six.add("Detective");
        ordering.put(6, six);

    }
}