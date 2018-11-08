package com.example.luxury.projectfinal;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    private MainActivity mainActivity;
    private List<String> list;

    public CategoryAdapter(MainActivity mainActivity, List<String> list) {
        this.mainActivity = mainActivity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        MyHolder myHolder = null;
        if (view == null) {
            view = mainActivity.getLayoutInflater().inflate(R.layout.layout_category, null);
            myHolder = new MyHolder();
            myHolder.btnCategory = view.findViewById(R.id.btnCategory);
            final String item = list.get(position);
            myHolder.btnCategory.setText(item);
            myHolder.btnCategory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mainActivity, TabbarActivity.class);
                    mainActivity.startActivity(intent);
                }
            });
            view.setTag(myHolder);
        } else {
            myHolder = (MyHolder) view.getTag();
        }
        return view;
    }

    class MyHolder {
        public Button btnCategory;

    }
}
