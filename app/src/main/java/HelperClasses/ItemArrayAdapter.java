package HelperClasses;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matthew.trekaid.R;

import java.util.ArrayList;

public class ItemArrayAdapter extends ArrayAdapter<Item>{

    private final Activity context;
    private final ArrayList<Item> objects;

    public ItemArrayAdapter(Activity context, int resource, ArrayList<Item> objects){
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_row_layout, null, true);
        TextView textView = (TextView)rowView.findViewById(R.id.itemTextView);
        ImageView imageview = (ImageView)rowView.findViewById(R.id.itemIcon);

        textView.setText(objects.get(position).getItemName());
        try{
            imageview.setImageBitmap((objects.get(position).getItemPic()));
        } catch (Exception e){
            e.printStackTrace();
        }

        return rowView;
    }

    public Item getItemAtPosition(int position){
        return objects.get(position);
    }
}
