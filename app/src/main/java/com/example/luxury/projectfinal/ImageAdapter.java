package com.example.luxury.projectfinal;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.UUID;

public class ImageAdapter extends BaseAdapter {

    private Fragment fragment;
    private List<Image> imageList;
    private TextToSpeech textToSpeech;

    public ImageAdapter(Fragment fragment, List<Image> imageList) {
        this.fragment = fragment;
        this.imageList = imageList;
        textToSpeech = new TextToSpeech(fragment.getContext(), new TextToSpeech.OnInitListener() {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        MyHolder myHolder;
        if (view == null) {
            view = fragment.getLayoutInflater().inflate(R.layout.layout_image_list_item, null);
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
        myHolder.textViewDes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnItemClick(position);
            }
        });

        // If it's possible, get the loaded image instead of load every time the list item is changing
        Drawable imageDrawable = imageList.get(position).getDrawable();
        if (imageDrawable == null) {
            loadImage(myHolder, image.getImageUrl(), position);
        } else {
            myHolder.imageView.setImageDrawable(imageDrawable);
        }
        myHolder.imageButtonVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String utteranceId = UUID.randomUUID().toString();
                textToSpeech.speak(imageList.get(position).getImageName(),
                        TextToSpeech.QUEUE_FLUSH, null, utteranceId);
            }
        });
        return view;
    }

    void loadImage(final MyHolder myHolder, String url, final int position) {
        myHolder.progressBar.setVisibility(View.VISIBLE);
        myHolder.imageView.setImageDrawable(null);
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
                myHolder.progressBar.setVisibility(View.INVISIBLE);
                imageList.get(position).setDrawable(drawable);
                myHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        OnItemClick(position);
                    }
                });
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

    void OnItemClick(int position) {
        final Dialog dialog = new Dialog(fragment.getContext());
        Image i = imageList.get(position);
        dialog.setContentView(R.layout.image_dialog);
        ImageView imageView = dialog.findViewById(R.id.image_dialog_imageView);
        imageView.setImageDrawable(i.getDrawable());
        TextView textView = dialog.findViewById(R.id.image_dialog_textView);
        textView.setText(i.getDescription());
        textView.setMovementMethod(new ScrollingMovementMethod());
        Button button = dialog.findViewById(R.id.image_dialog_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
