package com.dunca.charactergenerator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.MainActivity.R;

import java.sql.SQLException;

public class EditModeRealistic extends AppCompatActivity implements View.OnClickListener {
    private Button addTodoBtn;
    private EditText professionEditText;
    private EditText hairColourEditText;
    private EditText hobbyEditText;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add Record");
        setContentView(R.layout.activity_edit_mode_realistic);

        professionEditText = (EditText) findViewById(R.id.profession_edit_text);
        hairColourEditText = (EditText) findViewById(R.id.hair_colour_edit_text);
        hobbyEditText = (EditText) findViewById(R.id.hobby_edit_text);

        addTodoBtn =(Button) findViewById(R.id.add_record);

        dbManager = new DBManager(this);
        try {
            dbManager.open();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        addTodoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.add_record:

                final String profession= professionEditText.getText().toString();
                final String hairColour = hairColourEditText.getText().toString();
                final String hobby = hobbyEditText.getText().toString();

                dbManager.insert(profession, hairColour, hobby);

                Intent main = new Intent(EditModeRealistic.this, Library.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                break;
        }
    }
}