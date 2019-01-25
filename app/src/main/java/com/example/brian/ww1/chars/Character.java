package com.example.brian.ww1.chars;

public class Character{
    int association;
    int state = 1;
    String role;
    String player;
//    int ordering;

    public void setPlayer(String name) {
        player = name;
    }

    public void die() {
        state = 0;
    }

    public String toString() {
        String state;
//		if (this.getState() == 1) {state = "Alive";} else {state = "Dead";}
//		return "Role: " + role + ", Player: " + player + ", Association: " + association + ", Status: " + state;
        return role;
    }

    public int getAssociation() {
        return association;
    }

    public int getState() {
        return state;
    }

    public void setState(int s) {
        state = s;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object c){
        if (this.player == ((Character) c).player && this.role == ((Character) c).role){
            return true;
        }
        return false;
    }

//    @Override
//    public int compareTo(Character c) {
//        return (this.ordering - c.ordering);
//    }
}
