package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class RozszerzenieNiemiecki extends AppCompatActivity {

    private ArrayList<String> slowka=new ArrayList<String>();
    private SensorManager sm;
    private float acelVal;
    private float acelLast;
    private float shake;
    private Fragment_a fragment1;
    //private Fragment_b fragment2;
    private EditText et;
    private String translation;
    private Button submit;
    private ImageView image;

    private void getNewWord(){
        Random rand=new Random();
        int offset=rand.nextInt(slowka.size()-1);
        String record=slowka.get(offset);
        String [] temp=record.split("-" );
        fragment1 =Fragment_a.newInstance(temp[1]);
        translation=temp[0];
        getSupportFragmentManager().beginTransaction().replace(R.id.cont1N, fragment1).commit();

        if(temp.length==3){
            String filename=temp[2];
            String PACKAGE_NAME=getApplicationContext().getPackageName();
            int imgId=getResources().getIdentifier(PACKAGE_NAME+":drawable/"+filename, null, null);
            image.setImageBitmap(BitmapFactory.decodeResource(getResources(), imgId));
        }else{
            image.setImageResource(android.R.color.transparent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String filename="niemiecki_";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rozszerzenie_niemiecki);
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
        String[]temp=slowka.get(0).split("-");
        translation=temp[0];
        fragment1 =Fragment_a.newInstance(temp[1]);
        et=findViewById(R.id.editTN);
        getSupportFragmentManager().beginTransaction().replace(R.id.cont1N, fragment1).commit();
        sm=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        acelVal=SensorManager.GRAVITY_EARTH;
        acelLast=SensorManager.GRAVITY_EARTH;
        shake=0.00f;
        image=findViewById(R.id.rozWordImageN);
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
                getNewWord();
            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    public void check(View view) {
        String s2=et.getText().toString();

        if(s2.equals(translation)){
            Toast.makeText(getApplicationContext(), "DOBRZE!", Toast.LENGTH_SHORT).show();
            getNewWord();
        }else{
            Toast.makeText(getApplicationContext(), "SPRÓBUJ PONOWNIE!", Toast.LENGTH_SHORT).show();
        }
    }
}