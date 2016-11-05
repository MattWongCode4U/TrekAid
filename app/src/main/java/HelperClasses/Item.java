package HelperClasses;

import android.graphics.Bitmap;
import android.media.Image;

public class Item {
    private String itemName;
    private Bitmap itemPic;

    public Item(String name, Bitmap img){
        itemName = name;
        itemPic = img;
    }

    public void setItemName(String name){
        itemName = name;
    }

    public String getItemName(){
        return itemName;
    }

    public void setItemPic(Bitmap img){
        itemPic = img;
    }

    public Bitmap getItemPic() {
        return itemPic;
    }

    public void editItem(String newName, Bitmap newImage){
        setItemName(newName);
        setItemPic(newImage);
    }

    public void editItem(String newName){
        setItemName(newName);
    }

    public void editItem(Bitmap newImage){
        setItemPic(newImage);
    }

    public void printItem(){
        System.out.println("Item Name:" + getItemName());
    }
}
