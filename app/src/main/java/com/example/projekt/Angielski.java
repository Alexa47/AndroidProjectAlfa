package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.FloatMath;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Angielski extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angielski);
    }

    public void uruchomPodstDomRodz(View v){
        final Intent intencja1=new Intent(this, AngielskiPodst.class);
        String value="dom";
        intencja1.putExtra("key", value);
        startActivity(intencja1);
    }

    public void uruchomPodstJedzenie(View v){
        final Intent intencja2=new Intent(this, AngielskiPodst.class);
        String value="jedzenie";
        intencja2.putExtra("key", value);
        startActivity(intencja2);
    }

    public void uruchomPodstSport(View v){
        final Intent intencja3=new Intent(this, AngielskiPodst.class);
        String value="sport";
        intencja3.putExtra("key", value);
        startActivity(intencja3);
    }

    public void uruchomPodstTechnika(View v){
        final Intent intencja4=new Intent(this, AngielskiPodst.class);
        String value="technika";
        intencja4.putExtra("key", value);
        startActivity(intencja4);
    }

    public  void uruchomPodstPrzyroda(View v){
        final Intent intencja5=new Intent(this, AngielskiPodst.class);
        String value="przyroda";
        intencja5.putExtra("key", value);
        startActivity(intencja5);
    }

}