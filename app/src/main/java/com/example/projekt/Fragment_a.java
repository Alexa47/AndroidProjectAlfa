package com.example.projekt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_a extends Fragment {

    private static final String ARG_TEXT = "argText";
    private String text;

    public static Fragment_a newInstance(String text){
        Fragment_a fragment=new Fragment_a();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_a, container, false);
        TextView text_fragment_a=v.findViewById(R.id.text_1);
        if(getArguments()!=null){
            text=getArguments().getString(ARG_TEXT);
        }
        text_fragment_a.setText(text);
        return v;
    }

    public String getText(){
        return text;
    }


}
