package com.example.luxury.projectfinal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Vector;

public class VideoFragment extends Fragment {
    RecyclerView recyclerView;
    Vector<YoutubeVideo> youtubeVideo = new Vector<YoutubeVideo>();
    public static VideoFragment newInstance() {
        VideoFragment fragment = new VideoFragment();
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
        View v = inflater.inflate(R.layout.fragment_video, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.video_recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(getContext()));
        Intent intent = getActivity().getIntent();
        String category = intent.getStringExtra("category");
        List<YoutubeVideo> video = GetData.getDataVideoByCategory(category);
        VideoAdapter adapter = new VideoAdapter(video);
        recyclerView.setAdapter(adapter);

        return v;
    }
}
