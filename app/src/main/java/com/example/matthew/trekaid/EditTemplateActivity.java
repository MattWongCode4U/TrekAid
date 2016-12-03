package com.example.matthew.trekaid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

import Database.DatabaseHandler;
import Database.TemplateItemListComparator;
import Database.TemplateItemListDB;
import HelperClasses.Item;
import HelperClasses.TemplateItemArrayAdapter;
import HelperClasses.TemplateItemList;

public class EditTemplateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_template);

        DatabaseHandler db = new DatabaseHandler(this);

        ArrayList<TemplateItemList> list = db.getAllTIL();
        Collections.sort(list, new TemplateItemListComparator());

        TemplateItemArrayAdapter adapter = new TemplateItemArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        ListView listView = (ListView)findViewById(R.id.editTemplateListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TemplateItemList test = (TemplateItemList) parent.getItemAtPosition(position);
                test.printList();
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
