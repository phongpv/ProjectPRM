package com.example.luxury.projectfinal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TestAdapter extends BaseAdapter {
    private Fragment fragment;
    private List<Image> imageList;
    MyHolder myHolder;
    private static final int VOICE_RECOGNITION_REQUEST_CODE = 1001;

    public TestAdapter(Fragment fragment, List<Image> imageList) {
        this.fragment = fragment;
        this.imageList = imageList;
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
        if (view == null) {
            view = fragment.getLayoutInflater().inflate(R.layout.activity_voice_check, null);
            myHolder = new MyHolder();
            myHolder.imageView = view.findViewById(R.id.imgView);
            myHolder.btnSound = view.findViewById(R.id.btnSound);
            myHolder.txtName = view.findViewById(R.id.txtName);
            myHolder.txtUserSpeak = view.findViewById(R.id.txtUserSpeak);
            myHolder.progressBar = view.findViewById(R.id.image_progressBar);
            myHolder.progressBar.setEnabled(true);
            view.setTag(myHolder);
        } else {
            myHolder = (MyHolder) view.getTag();
        }

        PackageManager packageManager = fragment.getActivity().getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(
                new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        if(activities.size() == 0) {
            myHolder.btnSound.setEnabled(false);
            Toast.makeText(fragment.getContext(),"Voice not recognize", Toast.LENGTH_LONG).show();
        }

        Image image = imageList.get(position);
        myHolder.txtName.setText(image.getImageName());

        loadImage(myHolder, image.getImageUrl(), position);
        myHolder.btnSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakSound();
            }
        });

        return view;
    }

    void loadImage(final TestAdapter.MyHolder myHolder, String url, final int position) {
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

                    }
                });
            }
        };
        task.execute(url);
    }

    public class MyHolder {
        public ImageView imageView;
        public TextView txtName;
        public TextView txtUserSpeak;
        public ImageButton btnSound;
        public ProgressBar progressBar;
    }

    // Gui tap tin am thanh
    public void speakSound() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                fragment.getContext().getString(R.string.speech_prompt));
        try {
            fragment.getActivity().startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(fragment.getContext(),
                    fragment.getContext().getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE)

            // Truong hop co gia tri tra ve
            if(resultCode == fragment.getActivity().RESULT_OK) {
                ArrayList<String> textMatchList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                myHolder.txtUserSpeak.setText(textMatchList.get(0));
                Log.e("ee",  textMatchList.get(0));
                Toast.makeText(fragment.getContext(), textMatchList.get(0), Toast.LENGTH_LONG).show();
                // Cac truong hop loi
            } else if (resultCode == RecognizerIntent.RESULT_AUDIO_ERROR){
                showToastMessage("Audio Error");
            } else if (resultCode == RecognizerIntent.RESULT_CLIENT_ERROR){
                showToastMessage("Client Error");
            } else if (resultCode == RecognizerIntent.RESULT_NETWORK_ERROR){
                showToastMessage("Network Error");
            } else if (resultCode == RecognizerIntent.RESULT_NO_MATCH){
                showToastMessage("No Match");
            } else if (resultCode == RecognizerIntent.RESULT_SERVER_ERROR){
                showToastMessage("Server Error");
            }
        fragment.onActivityResult(requestCode, resultCode, data);
    }

    void showToastMessage(String message) {
        Toast.makeText(fragment.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
