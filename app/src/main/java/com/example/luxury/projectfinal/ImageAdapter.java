package com.example.luxury.projectfinal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ImageAdapter extends BaseAdapter {

    private MainActivity mainActivity;
    private List<Image> imageList;
    private TextToSpeech textToSpeech;
    private MyHolder myHolder;

    public ImageAdapter(MainActivity mainActivity, List<Image> imageList) {
        this.mainActivity = mainActivity;
        this.imageList = imageList;
        textToSpeech = new TextToSpeech(mainActivity, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public Object getItem(int position) {
        return imageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = mainActivity.getLayoutInflater().inflate(R.layout.layout_image_list_item, null);
            myHolder = new MyHolder();
            myHolder.imageView = view.findViewById(R.id.image_itemImage);
            myHolder.imageButtonVolume = view.findViewById(R.id.image_imageButtonVolume);
            myHolder.textViewItemName = view.findViewById(R.id.image_textViewItemName);
            myHolder.textViewDes = view.findViewById(R.id.image_textViewDescription);
            myHolder.progressBar = view.findViewById(R.id.image_progressBar);
            myHolder.progressBar.setEnabled(true);
            view.setTag(myHolder);
        } else {
            myHolder = (MyHolder) view.getTag();
        }

        Image image = imageList.get(position);
        myHolder.textViewItemName.setText(image.getImageName());
        myHolder.textViewDes.setText(image.getDescription());
        loadImage(myHolder, image.getImageUrl());
        myHolder.imageButtonVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String utteranceId = UUID.randomUUID().toString();
                textToSpeech.speak(myHolder.textViewItemName.getText().toString(),
                        TextToSpeech.QUEUE_FLUSH, null, utteranceId);
            }
        });

        return view;
    }

    void loadImage(final MyHolder myHolder, String url) {
        AsyncTask task = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                InputStream is = null;
                String url = objects[0].toString();
                try {
                    is = (InputStream) new URL(url).getContent();
                    Drawable d = Drawable.createFromStream(is, null);
                    return d;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(Object o) {
                Drawable drawable = (Drawable) o;
                myHolder.imageView.setImageDrawable(drawable);
                myHolder.progressBar.setEnabled(false);
            }
        };
        task.execute(url);
    }

    public class MyHolder {
        public ImageView imageView;
        public TextView textViewItemName;
        public TextView textViewDes;
        public ImageButton imageButtonVolume;
        public ProgressBar progressBar;
    }

    // Get list of image.
    public List<Image> getImageData(DatabaseCreator databaseCreator) {
        List<Image> imageList = new ArrayList<>();
        SQLiteDatabase db = databaseCreator.getReadableDatabase();
        String sql = "SELECT * FROM Image";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            int cateID = cursor.getInt(cursor.getColumnIndex("category_id"));
            String name = cursor.getString(cursor.getColumnIndex("image_name"));
            String image_url = cursor.getString(cursor.getColumnIndex("image_url"));
            String description = cursor.getString(cursor.getColumnIndex("description"));
            String audio_url = cursor.getString(cursor.getColumnIndex("audio_url"));
            Image image = new Image(id, cateID, image_url, audio_url, name, description);
            imageList.add(image);
        }
        return imageList;
    }
}
