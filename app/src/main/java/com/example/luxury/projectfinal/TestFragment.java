package com.example.luxury.projectfinal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TestFragment extends Fragment {
    ImageView imgView;
    ImageButton btnBack, btnNext, btnSound;
    ProgressBar image_progressBar;
    TextView txtName;
    private static final int VOICE_RECOGNITION_REQUEST_CODE = 1001;
    int index = 1;
    ArrayList<Image> images = new ArrayList<>();
    public TestFragment() {

    }

    // TODO: Rename and change types and number of parameters
    public static TestFragment newInstance() {
        TestFragment fragment = new TestFragment();
        return fragment;
    }

    void loadImage(String url, final int position) {
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
                imgView.setImageDrawable(drawable);
                image_progressBar.setVisibility(View.INVISIBLE);
                images.get(position).setDrawable(drawable);
            }
        };
        task.execute(url);
    }

    // go next
    void testImageNext () {
        if (index < images.size()-1) {
            index++;
            loadImage(images.get(index).getImageUrl(), index);
        }
    }

    // go previous
    void testImageBack () {
        if (index > 0) {
            index--;
            loadImage(images.get(index).getImageUrl(), index);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_test, container, false);
        imgView = (ImageView) v.findViewById(R.id.imgView);
        btnBack = (ImageButton) v.findViewById(R.id.btnBack);
        btnNext = (ImageButton) v.findViewById(R.id.btnNext);
        btnSound = (ImageButton) v.findViewById(R.id.btnSound);
        txtName = (TextView) v.findViewById(R.id.txtName);
        image_progressBar = (ProgressBar) v.findViewById(R.id.image_progressBar);

        checkSound();

        images.add(new Image(
                1,
                3,
                "https://i.imgur.com/HqVuEn4.jpg",
                "",
                "Con chó",
                "Đây là con vật biết trông nhà, và rất trung thành với con người."));
        images.add(new Image(
                1,
                3,
                "https://i.imgur.com/ig7FgKi.jpg",
                "",
                "Con hổ",
                "22 Hổ sống trong rừng rậm. Thường ở một mình, săn mồi vào ban đêm"));
        images.add(new Image(
                1,
                3,
                "https://i.imgur.com/AWibkhv.jpg",
                "",
                "Con thỏ",
                "Con vật rất giống loài chuột nhưng to hơn. Có 1 cái tai rất dài và vểnh lên trên. Món ăn khoái khẩu là cà rốt."));
        images.add(new Image(
                1,
                3,
                "https://i.imgur.com/gQqzWH6.jpg",
                "",
                "Con lợn",
                "Con vật này chỉ biết ăn và ngủ. To, chậm chạp."));
        images.add(new Image(
                1,
                3,
                "https://images.pexels.com/photos/145939/pexels-photo-145939.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
                "",
                "Con hổ",
                "Hổ sống trong rừng rậm.ssss s Thường ở một mình, săn mồi vào ban đêm"));

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testImageNext();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testImageBack();
            }
        });
        btnSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
        loadImage(images.get(index).getImageUrl(), index);
        return v;
    }

    public void checkSound() {
        PackageManager packageManager = getActivity().getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(
                new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        if(activities.size() == 0) {
            btnSound.setEnabled(false);
            Toast.makeText(getContext(),"Voice not recognize", Toast.LENGTH_LONG).show();
        }
    }

    // Gui tap tin am thanh
    public void speak() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    //nhan ket qua tra ve

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE)

            // Truong hop co gia tri tra ve
            if(resultCode == getActivity().RESULT_OK) {
                ArrayList<String> textMatchList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                txtName.setText(textMatchList.get(0));
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
        super.onActivityResult(requestCode, resultCode, data);
    }

    void showToastMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
