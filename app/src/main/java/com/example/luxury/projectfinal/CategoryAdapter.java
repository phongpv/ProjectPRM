package com.example.luxury.projectfinal;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    private MainActivity mainActivity;
    private List<Category> list;

    public CategoryAdapter(MainActivity mainActivity, List<Category> list) {
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
            final Category item = list.get(position);
            myHolder.btnCategory.setText(item.getName());
            myHolder.btnCategory.setBackgroundColor(Color.parseColor("#1AB8BE"));
            myHolder.btnCategory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mainActivity, TabbarActivity.class);
                    intent.putExtra("category", item.getName());
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
