package com.dunca.charactergenerator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.MainActivity.R;


public class MainActivity extends AppCompatActivity {
    //Defined views
    private TextView titleCard;
    private Button quickCreateButton;
    private Button customCreateButton;
    private Button libraryButton;
    private Button settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quickCreateButton = (Button) findViewById(R.id.quick_create_button);
        quickCreateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, FantasyVRealistic.class);
                // IS_THIS_QUICK_CREATE determines where the buttons in FantasyVRealistic point to
                // true= Quick Create
                // false= Custom Create
                intent.putExtra("IS_THIS_QUICK_CREATE", true);
                startActivity(intent);
            }
        }
        );
        customCreateButton =(Button) findViewById(R.id.custom_create_button);
        customCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FantasyVRealistic.class);
                intent.putExtra("IS_THIS_QUICK_CREATE", false);
            startActivity(intent);
        }
        });
    }
}