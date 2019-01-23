package com.example.brian.ww1;

import android.app.DialogFragment;
import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.brian.ww1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class werewolfFragment extends  android.support.v4.app.Fragment {
    View view;
    EditText count;
    Button next;
    InputMethodManager imm;
    public werewolfFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_werewolf, container, false);
        count = (EditText) view.findViewById(R.id.werewolfCount) ;
        count.requestFocus();
        imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        next = (Button) view.findViewById(R.id.buttonNext);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String result = count.getText().toString();
                if (result.length() != 0) {
                    //System.out.println("RESULT IS  [" + result + "]\n" );
                    int res = Integer.parseInt(result);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    charFragment cf = new charFragment();
                    cf.pass(res);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, cf).commit();

                }
            }
        });



        return view;
    }



}
