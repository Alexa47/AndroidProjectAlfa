package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Niemiecki extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niemiecki);
    }

    public void uruchomPodstDomRodzN(View v){
        final Intent intencja1=new Intent(this, NiemieckiPodst.class);
        String value="dom";
        intencja1.putExtra("key", value);
        startActivity(intencja1);
    }

    public void uruchomPodstJedzenieN(View v){
        final Intent intencja2=new Intent(this, NiemieckiPodst.class);
        String value="jedzenie";
        intencja2.putExtra("key", value);
        startActivity(intencja2);
    }

    public void uruchomPodstSportN(View v){
        final Intent intencja3=new Intent(this, NiemieckiPodst.class);
        String value="sport";
        intencja3.putExtra("key", value);
        startActivity(intencja3);
    }

    public void uruchomPodstTechnikaN(View v){
        final Intent intencja4=new Intent(this, NiemieckiPodst.class);
        String value="technika";
        intencja4.putExtra("key", value);
        startActivity(intencja4);
    }

    public  void uruchomPodstPrzyrodaN(View v){
        final Intent intencja5=new Intent(this, NiemieckiPodst.class);
        String value="przyroda";
        intencja5.putExtra("key", value);
        startActivity(intencja5);
    }
}