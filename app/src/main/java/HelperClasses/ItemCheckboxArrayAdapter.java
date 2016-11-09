package HelperClasses;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matthew.trekaid.R;

import java.util.ArrayList;

public class ItemCheckboxArrayAdapter extends ArrayAdapter<Item> {
    private final Activity context;
    private final ArrayList<Item> objects;
    private boolean[] checkholders;
    ViewHolder viewHolder;

    public ItemCheckboxArrayAdapter(Activity context, int resource, ArrayList<Item> objects){
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
        checkholders = new boolean[objects.size()];
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        TextView textView;
        ImageView imageview;
        CheckBox cb;

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.item_checkbox_row_layout, null, true);
            textView = (TextView) convertView.findViewById(R.id.itemTextView);
            imageview = (ImageView) convertView.findViewById(R.id.itemIcon);
            cb = (CheckBox) convertView.findViewById(R.id.checkBox);
            viewHolder = new ViewHolder(convertView, textView, imageview, cb);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.t.setText(objects.get(position).getItemName());
        try{
            viewHolder.i.setImageBitmap((objects.get(position).getItemPic()));
        } catch (Exception e){
            e.printStackTrace();
        }

        viewHolder.c.setChecked(checkholders[position]);

        viewHolder.c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /*System.out.println("Before:");
                for (int j = 0; j < checkholders.length; j++) {
                    System.out.println("checkholders[" + j + "]: " + checkholders[j]);
                }
                System.out.println("Position: " + position);
                System.out.println("isChecked(): " + ((CheckBox)v).isChecked());*/
                if (((CheckBox) v).isChecked()) {
                    checkholders[position] = true;
                } else {
                    checkholders[position] = false;
                }

                /*for (int j = 0; j < checkholders.length; j++) {
                    System.out.println("checkholders[" + j + "]: " + checkholders[j]);
                }*/
            }
        });

        return convertView;
    }

    public boolean[] getCheckBoxValues(){
        return checkholders;
    }

    private class ViewHolder{
        public View v;
        public TextView t;
        public ImageView i;
        public CheckBox c;

        public ViewHolder(View v, TextView tv, ImageView iv, CheckBox cb){
            this.v = v;
            t = tv;
            i = iv;
            c = cb;
        }
    }
}
