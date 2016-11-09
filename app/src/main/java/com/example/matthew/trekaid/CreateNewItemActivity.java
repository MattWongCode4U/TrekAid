package com.example.matthew.trekaid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Field;

import HelperClasses.Item;

public class CreateNewItemActivity extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_item);

        iv = (ImageView)findViewById(R.id.selectedImageImageView);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.defaultImagesImageButton:
                //Everything in the drawable folder
                Field[] drawables = R.drawable.class.getFields();
                /*for(Field f: drawables){
                    try{
                        System.out.println("R.drawable." + f.getName());
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                }*/
                //Open dialog to choose which image to use
                //Name of the chosen file
                String str = drawables[150].getName();
                int idres = getResources().getIdentifier(str,"drawable",getPackageName());
                try {
                    iv.setImageBitmap(BitmapFactory.decodeResource(getResources(), idres));
                } catch(Exception e){
                    e.printStackTrace();
                }
                break;

            case R.id.customImagesImageButton:
                //Open dialog to choose which image to use from phone's storage
                //Scale picture appropriately
                //set imageview's picture to the chosen picture
                break;

            case R.id.createItemButton:
                EditText editText = (EditText)findViewById(R.id.itemNamePromptEditText);
                if(!editText.getText().equals("") && iv.getDrawable() != null) {
                    Bitmap bm = ((BitmapDrawable)iv.getDrawable()).getBitmap();
                    Item newItem = new Item(editText.getText().toString(), bm);
                    newItem.printItem();
                    Toast toast = Toast.makeText(this, "Item " + newItem.getItemName() + " was created.", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
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
