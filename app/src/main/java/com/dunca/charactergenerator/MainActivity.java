package com.dunca.charactergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                Intent intent = new Intent(MainActivity.this, QuickCreateActivity.class);
                startActivity(intent);
            }
                                             }
        );
    }
}