package com.dunca.charactergenerator;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.MainActivity.R;

import java.sql.SQLException;

public class Library extends AppCompatActivity {

    private DBManager dbManager;

    private ListView listView;

    private CursorAdapter adapter;

    final  String[] from = new String[]{DatabaseHelper._ID, DatabaseHelper.PROFESSION, DatabaseHelper.HAIRCOLOUR, DatabaseHelper.HOBBY};

    final int[] to = new int[]{R.id.id, R.id.profession, R.id.hairColour, R.id.hobby};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        dbManager = new DBManager(this);
        try {
            dbManager.open();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Cursor cursor = dbManager.fetch();
        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        //For use on actual page
        adapter = new RealisticTitleCardAdapter(this,cursor);

        listView.setAdapter(adapter);



        //OnClickListener For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView professionTextView = (TextView) view.findViewById(R.id.profession);
                TextView hairColourTextView = (TextView) view.findViewById(R.id.hairColour);
                TextView hobbyTextView = (TextView) view.findViewById(R.id.hobby);

                String id = idTextView.getText().toString();
                String profession = professionTextView.getText().toString();
                String hairColour = hairColourTextView.getText().toString();
                String hobby = hobbyTextView.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), ModifyLibrary.class);
                modify_intent.putExtra("id", id);
                modify_intent.putExtra("profession", profession);
                modify_intent.putExtra("hairColour", hairColour);
                modify_intent.putExtra("hobby", hobby);

                startActivity(modify_intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.add_record){
        Intent add_mem = new Intent(this, Library.class);
        startActivity(add_mem);
    }
        return  super.onOptionsItemSelected(item);
    }
}