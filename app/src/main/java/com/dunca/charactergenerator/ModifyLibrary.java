package com.dunca.charactergenerator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.MainActivity.R;

import java.sql.SQLException;

public class ModifyLibrary extends AppCompatActivity implements View.OnClickListener {
    private EditText professionEditText, hairColourEditText, hobbyEditText;
    private Button updateBtn, deleteBtn;

    private long _id;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Modify Record");

        setContentView(R.layout.activity_library_modify);

        dbManager = new DBManager(this);
        try {
            dbManager.open();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        professionEditText = (EditText) findViewById(R.id.profession_edit_text);
        hairColourEditText = (EditText) findViewById(R.id.hair_colour_edit_text);
        hobbyEditText = (EditText) findViewById(R.id.hobby_edit_text);

        updateBtn = (Button) findViewById(R.id.btn_update);
        deleteBtn = (Button) findViewById(R.id.btn_delete);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String profession = intent.getStringExtra("profession");
        String hairColour = intent.getStringExtra("hairColour");
        String hobby = intent.getStringExtra("hobby");

        _id = Long.parseLong(id);

        professionEditText.setText(profession);
        hairColourEditText.setText(hairColour);
        hobbyEditText.setText(hobby);

        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_update:
                String profession = professionEditText.getText().toString();
                String hairColour = hairColourEditText.getText().toString();
                String hobby = hobbyEditText.getText().toString();

                dbManager.update(_id, profession, hairColour, hobby);
                this.returnHome();
                break;
        }
    }

    public void returnHome(){
        Intent home_intent = new Intent(getApplicationContext(), Library.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }
}
