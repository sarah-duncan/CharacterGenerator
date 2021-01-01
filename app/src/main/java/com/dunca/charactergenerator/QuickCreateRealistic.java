package com.dunca.charactergenerator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.MainActivity.R;

public class QuickCreateRealistic extends AppCompatActivity {

    //Defined views
    private TextView textViewShowDescription;
    private Button randomiseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_create_realistic);

        randomiseButton = (Button) findViewById(R.id.randomise_button);
        textViewShowDescription = (TextView) findViewById(R.id.textView_show_description_fantasy);

        randomiseButton.setOnClickListener(new View.OnClickListener(){
                                                 @Override
                                                 public void onClick(View v){
                                                     Randomise random = new RandomiseRealistic();
                                                     textViewShowDescription.setText(random.randomCharacter());
                                                 }
                                             }
        );
    }
}