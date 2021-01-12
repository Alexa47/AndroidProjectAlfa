package com.example.projekt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.subang1:
                Intent intencja1=new Intent(this, Angielski.class);
                startActivity(intencja1);
                return true;
            case R.id.subang2:
                Intent intencja2=new Intent(this, Angielski2.class);
                startActivity(intencja2);
                return true;
            case R.id.subniem1:
                Intent intencja3=new Intent(this, Niemiecki.class);
                startActivity(intencja3);
                return true;
            case R.id.subniem2:
                Intent intencja4=new Intent(this, Niemiecki2.class);
                startActivity(intencja4);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

   /* @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opcja_1:
                //Toast.makeText(this, "Opcja 1", Toast.LENGTH_SHORT).show();
                Intent intencja1=new Intent(this, Angielski.class);
                startActivity(intencja1);
                return true;
            case R.id.opcja_2:
                Toast.makeText(this, "Opcja 2", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);

        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Wybierz język");
        getMenuInflater().inflate(R.menu.example_menu, menu);
    }*/
}