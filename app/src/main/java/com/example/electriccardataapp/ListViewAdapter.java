package com.example.electriccardataapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    // ArrayList to save data added to Adapter
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    // ListViewAdapter's constructor
    public ListViewAdapter() {

    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // Get convertView reference by inflate "listview_item" Layout
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        // Get a reference to the widget from the View to be displayed on the screen
        TextView titleTextView = (TextView) convertView.findViewById(R.id.tv_title);
        TextView descTextView = (TextView) convertView.findViewById(R.id.tv_playtime);

        // Get data reference located at position in Data Set(listViewItemList)
        ListViewItem listViewItem = listViewItemList.get(position);

        // Data is reflected in each widget in the item
        titleTextView.setText(listViewItem.getTitle());
        descTextView.setText(listViewItem.getDesc());

        return convertView;
    }

    public void addItem(String title, String desc) {
        ListViewItem item = new ListViewItem();
        item.setTitle(title);
        item.setDesc(desc);

        listViewItemList.add(item);
    }
}
