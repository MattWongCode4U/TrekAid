package com.example.matthew.trekaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import Database.DatabaseHandler;
import Database.ItemComparator;
import Database.ItemDB;
import HelperClasses.Item;
import HelperClasses.ItemCheckboxArrayAdapter;
import HelperClasses.TemplateItemList;

public class CreateTemplateActivity extends AppCompatActivity {

    private boolean[] checkStates;
    ArrayList<Item> list;
    ItemCheckboxArrayAdapter adapter;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_template);

        db = new DatabaseHandler(this);

        list = db.getAllItems();
        //ItemDB itemdb = new ItemDB();
        //list = itemdb.generateTestItems(this);
        Collections.sort(list, new ItemComparator());

        checkStates = new boolean[list.size()];

        adapter = new ItemCheckboxArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        ListView listView = (ListView)findViewById(R.id.createTemplateListView);
        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
//                /*CheckBox cb = (CheckBox) view.findViewById(R.id.checkBox);
//                boolean value = cb.isChecked();
//                cb.setChecked(!value);
//                checkStates[position] = !value;*/
//
//                /*CheckBox cb;
//                View rowView;
//                if(rowView == null){
//                    rowView = view;
//                }*/
//                /*CheckBox cb = (CheckBox) view.findViewById(R.id.checkBox);
//                boolean value = cb.isChecked();
//                checkStates[position] = !value;
//
//                Item test = (Item) parent.getItemAtPosition(position);
//                System.out.println("edit item clicked:" + test.getItemName());*/
//            }
//        });
    }

    private class ViewHolder{
        public CheckBox checkBox;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.createTemplateButton:
                System.out.println("CreateTemplateButton Pressed");
                EditText et = (EditText) findViewById(R.id.createTemplateEditText);
                if(!et.getText().toString().equals("")) {
                    String name = et.getText().toString();
                    TemplateItemList newTIL = new TemplateItemList(name);
                    for (int i = 0; i < adapter.getCheckBoxValues().length; i++) {
                        if (adapter.getCheckBoxValues()[i]) {
                            newTIL.addItem(list.get(i).getItemName());
                        }
                    }

                    newTIL.printList();
                    if(newTIL.getSize() != 0){
                        Toast toast = Toast.makeText(this, "Template List " + newTIL.getName() + " was created.", Toast.LENGTH_SHORT);
                        toast.show();
                        db.addTIL(newTIL);
                        finish();
                    } else {
                        Toast toast = Toast.makeText(this, "Template List cannot be empty.", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }else{
                    Toast toast = Toast.makeText(this, "Please enter missing information.", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;

            case R.id.mainMenuReturnButton:
                finish();
                break;
        }

    }
}
