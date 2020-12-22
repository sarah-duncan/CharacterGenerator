package com.dunca.charactergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mainactivity.R;

public class FantasyVRealistic extends AppCompatActivity {
    private Button fantasyButton;
    private Button realisticButton;
    private boolean where_to;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fantasy_v_realistic);
        where_to = getIntent().getBooleanExtra("IS_THIS_QUICK_CREATE",true);
        fantasyButton = (Button) findViewById(R.id.fantasy_button);
        fantasyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(where_to = true){
                    Intent intent = new Intent(FantasyVRealistic.this,QuickCreateFantasy.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(FantasyVRealistic.this,EditModeFantasy.class);
                    //TODO Put in a blank character sheet here
                    startActivity(intent);
                }
            }
        });
        realisticButton = (Button) findViewById(R.id.realistic_button);
        realisticButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(where_to = true){
                    Intent intent = new Intent(FantasyVRealistic.this,QuickCreateRealistic.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(FantasyVRealistic.this,EditModeRealistic.class);
                    //TODO Put in a blank character sheet here
                    startActivity(intent);
                }
            }
        });
    }
}