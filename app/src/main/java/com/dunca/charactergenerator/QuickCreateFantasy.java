package com.dunca.charactergenerator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.MainActivity.R;

public class QuickCreateFantasy extends AppCompatActivity {

    private TextView textViewShowDescription;
    private Button randomiseButton;
    private String[] traits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_create_fantasy);

        randomiseButton = (Button) findViewById(R.id.randomise_button);
        textViewShowDescription = (TextView) findViewById(R.id.textView_randomise_fantasy);

        randomiseButton.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   Randomise random = new RandomiseFantasy();
                                                   traits= random.randomCharacter();
                                                   textViewShowDescription.setText("A " + traits[0] + " " + traits[1]+
                                                           " with "+ traits[2]+ " eyes and "+ traits[3] +" hair, who enjoys "+ traits[4]+ ".");
                                               }
                                           }
        );
    }
}