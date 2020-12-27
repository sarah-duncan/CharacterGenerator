package com.dunca.charactergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.MainActivity.R;

public class QuickCreateFantasy extends AppCompatActivity {

    private EditText editTextShowDescription;
    private Button randomiseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_create_realistic);

        randomiseButton = (Button) findViewById(R.id.randomise_button);
        editTextShowDescription = (EditText) findViewById(R.id.editText_show_description);

        randomiseButton.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   Randomise random = new RandomiseFantasy();
                                                   editTextShowDescription.setText(random.randomCharacter());
                                               }
                                           }
        );
    }
}