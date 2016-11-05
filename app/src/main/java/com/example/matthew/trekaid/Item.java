package com.example.matthew.trekaid;

import android.media.Image;

public class Item {
    private String itemName;
    private Image itemPic;

    public Item(String name, Image img){
        itemName = name;
        itemPic = img;
    }

    public void setItemName(String name){
        itemName = name;
    }

    public String getItemName(){
        return itemName;
    }

    public void setItemPic(Image img){
        itemPic = img;
    }

    public Image getItemPic() {
        return itemPic;
    }

    public void editItem(String newName, Image newImage){
        setItemName(newName);
        setItemPic(newImage);
    }

    public void editItem(String newName){
        setItemName(newName);
    }

    public void editItem(Image newImage){
        setItemPic(newImage);
    }

    public void printItem(){
        System.out.println("Item Name:" + getItemName());
    }
}
