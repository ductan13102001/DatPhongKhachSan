package com.example.datphongkhachsan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MenuAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ItemMenu> list;
    // Constructor
    public MenuAdapter(Context context, int layout, List<ItemMenu> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder{
        TextView txtView;
        ImageView imgView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup pareant) {
        ViewHolder viewHolder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            // Ánh xạ
            viewHolder.txtView = (TextView) convertView.findViewById(R.id.txtView);
            viewHolder.imgView = (ImageView) convertView.findViewById(R.id.imgView);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Gán giá trị
        viewHolder.txtView.setText(list.get(position).home_nameItem);
        viewHolder.imgView.setImageResource(list.get(position).home_icon);

        return convertView;
    }
}
