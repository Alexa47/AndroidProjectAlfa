package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class AngielskiPodst extends AppCompatActivity {

    private ArrayList<String> slowka=new ArrayList<String>();
    private SensorManager sm;
    private Fragment_a fragment1;
    private Fragment_a fragment2;
    private ImageView image;
    private float acelVal;
    private float acelLast;
    private float shake;

    private void getNewWord(){
        //String resource="R.drawable.";
        Random rand=new Random();
        int offset=rand.nextInt(slowka.size()-1);
        String record=slowka.get(offset);
        String [] temp=record.split(" " );
        fragment1 =Fragment_a.newInstance(temp[0]);
        fragment2=Fragment_a.newInstance(temp[1]);
        getSupportFragmentManager().beginTransaction().replace(R.id.My_Container_1_ID, fragment1).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.My_Container_2_ID, fragment2).commit();
        if(temp.length==3){
            String filename=temp[2];
            String PACKAGE_NAME=getApplicationContext().getPackageName();
            int imgId=getResources().getIdentifier(PACKAGE_NAME+":drawable/"+filename, null, null);
            image.setImageBitmap(BitmapFactory.decodeResource(getResources(), imgId));
            //Toast.makeText(getApplicationContext(), "ma zdjecie", Toast.LENGTH_SHORT).show();
        }else{
            image.setImageResource(android.R.color.transparent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String filename="angielski_";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angielski_podst);
        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            String value=extras.getString("key");
            filename+=value+".txt";
        }
        BufferedReader reader=null;
        try{
            reader=new BufferedReader(new InputStreamReader(getAssets().open(filename)));
            String line;
            while((line=reader.readLine())!=null){
                slowka.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sm=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        acelVal=SensorManager.GRAVITY_EARTH;
        acelLast=SensorManager.GRAVITY_EARTH;
        shake=0.00f;
        String[]temp=slowka.get(0).split(" ");
        String test=temp[0];
        fragment1 =Fragment_a.newInstance(test);
        fragment2=Fragment_a.newInstance(temp[1]);
        getSupportFragmentManager().beginTransaction().replace(R.id.My_Container_1_ID, fragment1).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.My_Container_2_ID, fragment2).commit();
        image=findViewById(R.id.wordImage);
        if(temp.length==3){
            String file=temp[2];
            String PACKAGE_NAME=getApplicationContext().getPackageName();
            int imgId=getResources().getIdentifier(PACKAGE_NAME+":drawable/"+file, null, null);
            image.setImageBitmap(BitmapFactory.decodeResource(getResources(), imgId));
        }else{
            image.setImageResource(android.R.color.transparent);
        }

    }
    private final SensorEventListener sensorListener=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x=event.values[0];
            float y=event.values[1];
            float z=event.values[2];

            acelLast=acelVal;
            acelVal=(float)Math.sqrt((double)(x*x+y*y+z*z));
            float delta=acelVal-acelLast;
            shake=shake*0.9f+delta;

            if(shake>3){
                //Toast.makeText(getApplicationContext(), "shake", Toast.LENGTH_SHORT).show();
                getNewWord();
            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };


}