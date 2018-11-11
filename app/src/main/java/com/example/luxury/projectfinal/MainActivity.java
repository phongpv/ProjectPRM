package com.example.luxury.projectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ListView listCategoty;
    List<Category> category = new ArrayList<Category>();
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCategoty = (ListView) findViewById(R.id.listCategory);
        category.add(new Category("Động vật", "#F26202"));
        category.add(new Category("Hoa quả", "#3D698E"));
        category.add(new Category("Phương tiện giao thông", "#35A2F4"));
        category.add(new Category("Đồ dùng hàng ngày", "#975B33"));
        CategoryAdapter adapter = new CategoryAdapter(this, category);
        listCategoty.setAdapter(adapter);
    }

//    void callLearnActivity (View v) {
//        intent = new Intent(this, activity_learn.class);
//        startActivity(intent);
//        finish();
//    }
}
