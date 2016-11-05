package com.example.matthew.trekaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.selectTemplateButton:
                System.out.println("SelectTemplateButton");
                Intent stIntent = new Intent(this, SelectTemplateActivity.class);
                startActivity(stIntent);
                break;

            case R.id.createTemplateButton:
                System.out.println("CreateTemplateButton");
                Intent ctIntent = new Intent(this, CreateTemplateActivity.class);
                startActivity(ctIntent);
                break;

            case R.id.createNewItemButton:
                System.out.println("CreateNewItemButton");
                Intent cniIntent = new Intent(this, CreateNewItemActivity.class);
                startActivity(cniIntent);
                break;

            case R.id.editItemButton:
                System.out.println("EditItemButton");
                Intent eiIntent = new Intent(this, EditItemActivity.class);
                startActivity(eiIntent);
                break;
        }

    }
}
