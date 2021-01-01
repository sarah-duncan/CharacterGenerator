package com.dunca.charactergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.MainActivity.R;

public class QuickCreateFantasy extends AppCompatActivity {

    private TextView textViewShowDescription;
    private Button randomiseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_create_realistic);

        randomiseButton = (Button) findViewById(R.id.randomise_button);
        textViewShowDescription = (TextView) findViewById(R.id.textView_show_description_realistic);

        randomiseButton.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   Randomise random = new RandomiseFantasy();
                                                   textViewShowDescription.setText(random.randomCharacter());
                                               }
                                           }
        );
    }
}