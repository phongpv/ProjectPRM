package com.example.luxury.projectfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseCreator extends SQLiteOpenHelper {

    public DatabaseCreator(Context context, String dbName, int version) {
        super(context, dbName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Category(" +
                        "id integer NOT NULL primary key autoincrement," +
                        "category_name nvarchar(50) not null," +
                        "category_icon text not null" +
                        ")";
        db.execSQL(sql);

        sql = "CREATE TABLE Image(" +
                "id integer NOT NULL primary key autoincrement," +
                "category_id INT NOT NULL," +
                "image_url TEXT NOT NULL," +
                "audio_url TEXT," +
                "image_name nvarchar(100) NOT NULL," +
                "english_name varchar(100) NOT NULL," +
                "description TEXT NOT NULL," +
                "FOREIGN KEY (category_id) REFERENCES Category (id)" +
                ");";
        db.execSQL(sql);

        sql = "CREATE TABLE Video (" +
                "id integer NOT NULL primary key autoincrement," +
                "video_url TEXT NOT NULL," +
                "category_id INT NOT NULL," +
                "FOREIGN KEY (category_id) REFERENCES Category (id)" +
                ");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
