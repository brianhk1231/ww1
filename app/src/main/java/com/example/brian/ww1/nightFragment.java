package com.example.brian.ww1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class nightFragment extends Fragment {
    View view;

    //Data Structures
    HashMap<String, ArrayList<String>> charMap = new HashMap<>();
    HashMap<Integer, ArrayList<String>> ordering = new HashMap<>();
    ArrayList<String> orderList = new ArrayList<>();

    //UI Elements
    Button next;
    TextView title;

    public nightFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_night, container, false);
        orderList = populateChars();
        ordering = defineOrder();

        title = (TextView) view.findViewById(R.id.titleText);
        title.setText(orderList.toString());

        next = (Button) view.findViewById(R.id.buttonNext);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getNext();
                title.setText(orderList.toString() + "\n " + ordering.toString() + "\n"+ ordering.get(2).contains("Werewolf"));
            }
        });



        return view;
    }

    public void fillChar(HashMap<String, ArrayList<String>> map){
        charMap = map;
    }

    public ArrayList<String> populateChars(){
        ArrayList<String> orderList = new ArrayList<>();
        for (String s: charMap.keySet()){
            orderList.add(s);
        }
        return orderList;
    }

    //ORDERING DEFINITION HERE
    public HashMap<Integer, ArrayList<String>> defineOrder(){
        HashMap<Integer, ArrayList<String>> ordering = new HashMap();
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

        return ordering;

    }

    public String getNext(){
        String next = "";
        int num = 6;

        while (num > 0) {
            for (String character : orderList) {
                if (ordering.get(num).contains(character)){
                    next = character;
                }

            }
            num --;
        }
        if (orderList.contains(next)){orderList.remove(next);}
        return next;
    }

}
