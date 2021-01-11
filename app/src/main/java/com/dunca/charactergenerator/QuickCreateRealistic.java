package com.dunca.charactergenerator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.MainActivity.R;

import java.sql.SQLException;

public class QuickCreateRealistic extends AppCompatActivity implements View.OnClickListener {

    //Defined views
    private TextView textViewShowDescription;
    private Button randomiseButton;
    private Button addTodoBtn;
    private EditText professionEditText;
    private EditText hairColourEditText;
    private EditText hobbyEditText;
    private String[] traits;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_create_realistic);

        randomiseButton = (Button) findViewById(R.id.randomise_button);
        textViewShowDescription = (TextView) findViewById(R.id.textViewRandomise);

        addTodoBtn =(Button) findViewById(R.id.save_button);

        dbManager = new DBManager(this);
        try {
            dbManager.open();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        addTodoBtn.setOnClickListener(this);

        randomiseButton.setOnClickListener(new View.OnClickListener(){
                                                 @Override
                                                 public void onClick(View v){
                                                     Randomise random = new RandomiseRealistic();
                                                     traits= random.randomCharacter();
                                                     textViewShowDescription.setText("A " + traits[0] + " with "+
                                                             traits[1]+ " hair, who enjoys "+ traits[2]+ "." );
                                                 }
                                             }
        );
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.save_button:

                dbManager.insert(traits[0], traits[1], traits[2]);

                Intent main = new Intent(QuickCreateRealistic.this, Library.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                break;
        }
    }
}