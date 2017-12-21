package com.example.it24.ujicoba;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by it24 on 12/21/17.
 */

public class ItemAdapter extends BaseAdapter {

    //ini adalah this
    private Context context;
    private List<Item> itemList = new ArrayList<>();

    public ItemAdapter(Context context, List<Item> body) {
        this.context = context; //kanan -> yang didalam kurung
        this.itemList = body;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        TextView textView1 = (TextView) view.findViewById(R.id.item_list1);
        textView1.setText((CharSequence) itemList.get(position).getActorId());
        TextView textView2 = (TextView) view.findViewById(R.id.item_list2);
        textView2.setText((CharSequence) itemList.get(position).getFirstName());
        TextView textView3 = (TextView) view.findViewById(R.id.item_list3);
        textView3.setText((CharSequence) itemList.get(position).getLastName());
        TextView textView4 = (TextView) view.findViewById(R.id.item_list4);
        textView4.setText((CharSequence) itemList.get(position).getLastUpdate());
        return view;
    }
}
