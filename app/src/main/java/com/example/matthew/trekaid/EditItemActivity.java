package com.example.matthew.trekaid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import Database.ItemDB;
import HelperClasses.Item;
import HelperClasses.ItemArrayAdapter;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        ItemDB itemdb = new ItemDB();
        ArrayList<Item> list = itemdb.generateTestItems();

        ItemArrayAdapter adapter = new ItemArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        ListView listView = (ListView)findViewById(R.id.editItemListView);
        listView.setAdapter(adapter);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mainMenuReturnButton:
                finish();
                break;
        }

    }
}
