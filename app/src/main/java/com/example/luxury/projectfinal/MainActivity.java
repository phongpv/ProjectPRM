package com.example.luxury.projectfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listCategoty;
    List<String> category = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCategoty = (ListView) findViewById(R.id.listCategory);
        category.add("Animal");
        category.add("Fruit");
        category.add("Car");
        category.add("Belongings");
        CategoryAdapter adapter = new CategoryAdapter(this, category);
        listCategoty.setAdapter(adapter);
    }

    public class MyHolder {

    }
}
