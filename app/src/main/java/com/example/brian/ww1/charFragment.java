package com.example.brian.ww1;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.HttpAuthHandler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class charFragment extends android.support.v4.app.Fragment {
    InputMethodManager imm;
    View view;
    int num = 0;
    LinearLayout layout;
    TextView heading;
    Button start;
    ArrayList<String> charList = new ArrayList<>(Arrays.asList(new String[] {"Villager","Tanner","Seer","Witch", "Detective", "Vigilante", "Bodyguard", "Hunter"}));
    ArrayList<String> sendList = new ArrayList<String>();
    HashMap<String, ArrayList<EditText>> textMap = new HashMap<>();
    HashMap<String,ArrayList<String>> charMap = new HashMap<>();

    //HashMap of EditText to String for temp names and restore
    HashMap<EditText, String> editTemp = new HashMap<>();

    public charFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_char, container, false);
        imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        layout = (LinearLayout) view.findViewById(R.id.linearLayout);
        start = (Button) view.findViewById(R.id.buttonStart);
        heading = (TextView) view.findViewById(R.id.textView);
        addWerewolf(num);
        for (String s:charList){
            addChar(s);
        }
        TextView tv3 = new TextView(getContext());
        tv3.setClickable(false);
        tv3.setFocusable(false);
        tv3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30 + 10 * num);
        layout.addView(tv3);

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                charMap = new HashMap<>();
                String test = "";
                for (String s:textMap.keySet()){
                    for (EditText e:textMap.get(s)) {
                        String playerName = e.getText().toString();
                        if (playerName.length() > 0) {
                            test += s + ": " + playerName + "\n";
                            if (charMap.containsKey(s)) {
                                charMap.get(s).add(playerName.trim());
                            } else {
                                ArrayList<String> playerList = new ArrayList<>();
                                playerList.add(playerName.trim());
                                charMap.put(s, playerList);
                            }

                        }
                    }

                }
                //heading.setText(test);
                new AlertDialog.Builder(getContext())
                        .setTitle("Lock in characters?")
                        .setMessage(charMap.toString())
                        .setIcon(null)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                //Implement with game class
                                //Start Game
                                //Add Fragment
                            }})
                        .setNegativeButton(android.R.string.no, null).show();

            }
        });

        return view;
    }

    public void addChar(String character){
        final TextView tv = new TextView(getContext());
        tv.setText(character);
        tv.setTextColor(Color.parseColor("#808080"));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 22);
        tv.setClickable(true);
        tv.setFocusable(true);

        layout.addView(tv);

        final EditText tv2 = new EditText(getContext());
        tv2.setText("");

//        tv2.setHintTextColor(Color.parseColor("#808080"));
        tv2.setTextColor(Color.parseColor("#FFFFFF"));
        tv2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);

        //tv2.setAlpha(0);

        tv2.setFocusableInTouchMode(false);

        tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //System.out.println(sendList);
                if (!(sendList.contains(tv.getText().toString()))) {
                    tv2.setFocusableInTouchMode(true);
                    tv2.requestFocus();
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                    tv.setTextColor(Color.parseColor("#FFFFFF"));
                    tv2.setTextColor(Color.parseColor("#FFFFFF"));
                    sendList.add(tv.getText().toString());
                    tv2.setText(editTemp.get(tv2));
                    if (tv2.getText().toString().length() > 0) {
                        tv2.selectAll();
                    }
                    //System.out.println("ADDED: " + sendList);
                }
                else if (sendList.contains(tv.getText().toString())) {
                    tv.setTextColor(Color.parseColor("#808080"));
                    tv2.setTextColor(Color.parseColor("#808080"));
                    editTemp.put(tv2, tv2.getText().toString());
                    tv2.setText("");
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    sendList.remove(tv.getText().toString());
                    //System.out.println("REMOVED: " + sendList);

                }

            }
        });
        if (textMap.containsKey(character)){
            textMap.get(character).add(tv2);
        }
        else{
            ArrayList<EditText> editList = new ArrayList<>();
            editList.add(tv2);
            textMap.put(character, editList);
        }

        editTemp.put(tv2, "");

        layout.addView(tv2);

    }

    public void addWerewolf(int i){
        int j = 1;
        while ( j <= i){
            addChar("Werewolf");
            j++;
        }
    }

    public void pass(int i){
        num = i;
    }

}
