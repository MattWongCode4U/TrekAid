package com.example.matthew.trekaid;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;

import Database.DatabaseHandler;
import HelperClasses.Item;

public class CreateNewItemActivity extends AppCompatActivity {

    ImageView iv;
    DatabaseHandler db;
    final String[] perms = {"android.permission.READ_EXTERNAL_STORAGE"};
    final int PHOTO_ACCESS_CODE = 111;
    final int DEFAULT_PIC_CODE = 222;
    final int permcode = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_item);

        db = new DatabaseHandler(this);
        iv = (ImageView)findViewById(R.id.selectedImageImageView);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.defaultImagesImageButton:
                Intent diIntent = new Intent(this, DefaultItemImageActivity.class);
                startActivityForResult(diIntent, DEFAULT_PIC_CODE);
                break;

            case R.id.customImagesImageButton:
                //Open dialog to choose which image to use from phone's storage
                //Scale picture appropriately
                //set imageview's picture to the chosen picture
                System.out.println("Custom Image Button Pressed");
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                if(checkSelfPermission(perms[0]) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(perms, permcode);
                }

                if(checkSelfPermission(perms[0]) == PackageManager.PERMISSION_GRANTED) {
                    startActivityForResult(intent, PHOTO_ACCESS_CODE);
                }
                break;

            case R.id.createItemButton:
                EditText editText = (EditText)findViewById(R.id.itemNamePromptEditText);
                if(!editText.getText().toString().equals("") && iv.getDrawable() != null) {
                    Bitmap bm = ((BitmapDrawable)iv.getDrawable()).getBitmap();
                    Item newItem = new Item(editText.getText().toString(), bm);
                    newItem.printItem();
                    db.addItem(newItem);
                    System.out.println("Item count in DB: " + db.getItemsCount());
                    Toast toast = Toast.makeText(this, "Item " + newItem.getItemName() + " was created.", Toast.LENGTH_SHORT);
                    toast.show();
                    finish();
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PHOTO_ACCESS_CODE && resultCode == RESULT_OK && data != null){
            Uri targetUri = data.getData();
            Bitmap bitmap;
            try{
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                Bitmap resized = ThumbnailUtils.extractThumbnail(bitmap, 100, 100);
                iv.setImageBitmap(resized);
            } catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }
        if(requestCode == DEFAULT_PIC_CODE && resultCode == RESULT_OK){
            byte[] byteArray = data.getByteArrayExtra("defaultPicture");
            Bitmap bitmap;
            bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            Bitmap resized = ThumbnailUtils.extractThumbnail(bitmap, 100, 100);
            iv.setImageBitmap(resized);
        }
    }
}
