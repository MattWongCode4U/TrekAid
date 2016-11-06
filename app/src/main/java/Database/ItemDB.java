package Database;

import android.graphics.Bitmap;

import java.util.ArrayList;

import HelperClasses.Item;

public class ItemDB {

    public ArrayList<Item> generateTestItems(){
        ArrayList<Item> list = new ArrayList<Item>();

        int[] colours = new int[400];
        for(int i = 0; i < colours.length; i++){
            colours[i] = 50 + i;
        }

        Bitmap b = Bitmap.createBitmap(colours, 3, 3, Bitmap.Config.ARGB_8888);

        for(int i = 0; i < 20; i++){
            Item item = new Item("Item " + i, b);
            list.add(item);
        }

        return list;
    }
}
