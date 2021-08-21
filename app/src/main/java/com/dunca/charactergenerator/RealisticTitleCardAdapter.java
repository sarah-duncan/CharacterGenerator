package com.dunca.charactergenerator;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.MainActivity.R;

public class RealisticTitleCardAdapter extends CursorAdapter {
    public RealisticTitleCardAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_layout, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView tvBody = (TextView) view.findViewById(R.id.description);
        TextView tvPriority = (TextView) view.findViewById(R.id.number);
        // Extract properties from cursor
        String description = new String("A " + cursor.getString(cursor.getColumnIndex(DatabaseHelper.PROFESSION)) + " with "+
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.HAIRCOLOUR))+ " hair, who enjoys "+ cursor.getString(cursor.getColumnIndex(DatabaseHelper.HOBBY)) + ".");

        // Populate fields with extracted properties
        tvBody.setText(description);
    }
}
