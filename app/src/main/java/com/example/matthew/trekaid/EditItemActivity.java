package com.example.matthew.trekaid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

import Database.ItemComparator;
import Database.ItemDB;
import HelperClasses.Item;
import HelperClasses.ItemArrayAdapter;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        ItemDB itemdb = new ItemDB();
        ArrayList<Item> list = itemdb.generateTestItems(this);
        //Collections.sort(list, new ItemComparator());

        ItemArrayAdapter adapter = new ItemArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        ListView listView = (ListView)findViewById(R.id.editItemListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item test = (Item)parent.getItemAtPosition(position);
                System.out.println("edit item clicked:" + test.getItemName());
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mainMenuReturnButton:
                finish();
                break;
        }

    }
}
