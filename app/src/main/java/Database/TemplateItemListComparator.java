package Database;

import HelperClasses.TemplateItemList;

import java.util.Comparator;

public class TemplateItemListComparator implements Comparator<TemplateItemList>{
    public int compare(TemplateItemList left, TemplateItemList right){
        return left.getName().compareToIgnoreCase(right.getName());
    }
}
