package HelperClasses;


import java.util.ArrayList;

import HelperClasses.Item;

public class TemplateItemList {
    private String name;
    private ArrayList<String> itemList = new ArrayList<String>();

    public TemplateItemList(String s){
        name = s;
    }

    public TemplateItemList(String s, ArrayList<String> initList){
        name = s;
        itemList = initList;
    }

    public void addItem(String item){
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

    public ArrayList<String> getItemList(){
        return itemList;
    }

    public int getSize(){
        return itemList.size();
    }

    public void printList(){
        System.out.println("List name: " + getName());
        for(int i = 0; i < itemList.size(); i++){
            System.out.println("Item name: " + itemList.get(i));
        }
    }
}
