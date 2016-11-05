package com.example.matthew.trekaid;


import java.util.ArrayList;

public class TemplateItemList {
    private ArrayList<Item> itemList = new ArrayList<Item>();

    public void addItem(Item item){
        itemList.add(item);
    }

    public void removeItem(Item item){
        itemList.remove(item);
    }

    public void printList(){
        for(int i = 0; i < itemList.size(); i++){
            itemList.get(i).printItem();
        }
    }
}