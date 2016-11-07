package Database;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.matthew.trekaid.R;

import java.util.ArrayList;

import HelperClasses.Item;

public class ItemDB {

    public ArrayList<Item> generateTestItems(Context context){
        ArrayList<Item> list = new ArrayList<Item>();

        /*int[] colours = new int[400];
        for(int i = 0; i < colours.length; i++){
            colours[i] = 50 + i;
        }

        Bitmap b = Bitmap.createBitmap(colours, 3, 3, Bitmap.Config.ARGB_8888);*/
        Bitmap b = BitmapFactory.decodeResource(context.getResources(), R.drawable.bar);

        Item i1 = new Item("bbbb 1", b);
        Item i2 = new Item("gggg 2", b);
        Item i3 = new Item("aaaa 3", b);
        Item i4 = new Item("xxxx 4", b);
        Item i5 = new Item("cccc 5", b);

        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        list.add(i5);

        /*for(int i = 0; i < 20; i++){
            Item item = new Item("Item " + i, b);
            list.add(item);
        }*/

        return list;
    }
}
