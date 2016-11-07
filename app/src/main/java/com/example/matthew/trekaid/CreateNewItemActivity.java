package com.example.matthew.trekaid;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.lang.reflect.Field;

import HelperClasses.Item;

public class CreateNewItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_item);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.defaultImagesImageButton:
                Field[] drawables = R.drawable.class.getFields();
                for(Field f: drawables){
                    try{
                        System.out.println("R.drawable." + f.getName());
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                }

                break;

            case R.id.customImagesImageButton:
                break;

            case R.id.createItemButton:
                EditText editText = (EditText)findViewById(R.id.itemNamePromptEditText);
                ImageView imageView = (ImageView)findViewById(R.id.selectedImageImageView);
                Bitmap bm = ((BitmapDrawable)imageView.getDrawable()).getBitmap();

                Item newItem = new Item(editText.getText().toString(), bm);

                break;

            case R.id.mainMenuReturnButton:
                finish();
                break;
        }

    }
}
