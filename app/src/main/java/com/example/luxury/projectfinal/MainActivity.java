package com.example.luxury.projectfinal;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
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
    public static DatabaseCreator databaseCreator;

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

        // Use for test the app, when complete, we will use initData() instead.
        this.deleteDatabase("KidThoughDB");
        databaseCreator = new DatabaseCreator(this, "KidThoughDB", 1);
        DatabaseEditor.insertData(databaseCreator);
    }

    void initData() {
        if (databaseCreator == null) {
            databaseCreator = new DatabaseCreator(this, "KidThoughDB", 1);
        }
        SQLiteDatabase db = databaseCreator.getReadableDatabase();
        String sql = "SELECT count(*) FROM Image";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        if (count <= 0) {
            DatabaseEditor.insertData(databaseCreator);
        }
    }
}
