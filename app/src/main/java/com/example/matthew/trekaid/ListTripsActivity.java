package com.example.matthew.trekaid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ListTripsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_trips);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mainMenuReturnButton:
                finish();
                break;
        }

    }
}
