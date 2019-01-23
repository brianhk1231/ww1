package com.example.brian.ww1;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class charFragment extends android.support.v4.app.Fragment {
    InputMethodManager imm;
    View view;
    int num = 0;
    LinearLayout layout;
    ArrayList<String> charList = new ArrayList<>(Arrays.asList(new String[] {"Villager","Tanner","Sear","Witch", "Detective", "Vigilante", "Bodyguard", "Hunter"}));
    ArrayList<String> sendList = new ArrayList<String>();
//    TextView numww;
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

        addWerewolf(num);
        for (String s:charList){
            addChar(s);
        }



        return view;
    }

    public void addChar(String character){
        final TextView tv = new TextView(getContext());
        tv.setText(character);
        tv.setTextColor(Color.parseColor("#808080"));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        tv.setClickable(true);
        tv.setFocusable(true);

        layout.addView(tv);

        final EditText tv2 = new EditText(getContext());
        tv2.setText("");

        tv2.setHintTextColor(Color.parseColor("#808080"));
        tv2.setTextColor(Color.parseColor("#FFFFFF"));
        tv2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);



        tv2.setFocusableInTouchMode(false);

        tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println(sendList);
                if (!(sendList.contains(tv.getText().toString()))) {
                    tv2.setFocusableInTouchMode(true);
                    tv2.requestFocus();
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                    tv.setTextColor(Color.parseColor("#FFFFFF"));
                    tv2.setTextColor(Color.parseColor("#FFFFFF"));
                    sendList.add(tv.getText().toString());
                    System.out.println("ADDED: " + sendList);
                }
                else if (sendList.contains(tv.getText().toString())) {
                    tv.setTextColor(Color.parseColor("#808080"));
                    tv2.setTextColor(Color.parseColor("#808080"));
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    sendList.remove(tv.getText().toString());
                    System.out.println("REMOVED: " + sendList);
                }

            }
        });

        layout.addView(tv2);

    }

    public void addWerewolf(int i){
        int j = 1;
        while ( j <= i){
            addChar("Werewolf " + (j));
            j++;
        }
    }

    public void pass(int i){
        num = i;
    }

}
