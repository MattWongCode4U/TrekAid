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
            case R.id.listTripsButton:
                Intent ltIntent = new Intent(this, ListTripsActivity.class);
                startActivity(ltIntent);
                break;

            case R.id.selectTemplateButton:
                Intent stIntent = new Intent(this, SelectTemplateActivity.class);
                startActivity(stIntent);
                break;

            case R.id.createTemplateButton:
                Intent ctIntent = new Intent(this, CreateTemplateActivity.class);
                startActivity(ctIntent);
                break;

            case R.id.createNewItemButton:
                Intent cniIntent = new Intent(this, CreateNewItemActivity.class);
                startActivity(cniIntent);
                break;

            case R.id.editItemButton:
                Intent eiIntent = new Intent(this, EditItemActivity.class);
                startActivity(eiIntent);
                break;
        }

    }
}
