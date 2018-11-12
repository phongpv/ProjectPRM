package com.example.luxury.projectfinal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ImageFragment extends Fragment {
    ListView listImage;

    public ImageFragment() {
        // Required empty public constructor
    }

    public static ImageFragment newInstance() {
        ImageFragment fragment = new ImageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_image, container, false);
        listImage = (ListView) v.findViewById(R.id.listImage);
        Intent intent = getActivity().getIntent();
        String category = intent.getStringExtra("category");
        List<Image> images = GetData.getDataByCategory(category);
        ImageAdapter adapter = new ImageAdapter(this, images);
        listImage.setAdapter(adapter);
        listImage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ImageFragment.super.getContext(), "Item clicked", Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }
}
