package HelperClasses;


import java.util.ArrayList;

import HelperClasses.Item;

public class TemplateItemList {
    private ArrayList<Item> itemList = new ArrayList<Item>();
    private String name;

    public TemplateItemList(String s){
        name = s;
    }

    public TemplateItemList(String s, ArrayList<Item> initList){
        name = s;
        itemList = initList;
    }

    public void addItem(Item item){
        itemList.add(item);
    }

    public void removeItem(Item item){
        itemList.remove(item);
    }

    public void setName(String s){
        name = s;
    }

    public String getName(){
        return name;
    }

    public int getSize(){
        return itemList.size();
    }

    public void printList(){
        for(int i = 0; i < itemList.size(); i++){
            itemList.get(i).printItem();
        }
    }
}
