package Database;

import com.example.matthew.trekaid.Item;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {
    public int compare(Item left, Item right){
        return left.getItemName().compareToIgnoreCase(right.getItemName());
    }
}
