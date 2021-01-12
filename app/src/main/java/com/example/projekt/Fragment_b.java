package com.example.projekt;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_b extends Fragment {

    private ImageView image;

   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static Fragment_b newInstance(String image){
        Fragment_b fragment=new Fragment_b();
        fragment.setImageResource(R.drawable.)
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_b, container, false);
        ImageView image = (ImageView) v.findViewById(R.id.wordImage);
        SharedPreferences settings = this.getActivity().getSharedPreferences("PREFS", 0);
        tl.setText(settings.getString("value", ""));
        return v;

    }*/


}