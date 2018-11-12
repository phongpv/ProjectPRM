package com.example.luxury.projectfinal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TestFragment extends Fragment {
    ListView listTest;

    public TestFragment() {

    }

    // TODO: Rename and change types and number of parameters
    public static TestFragment newInstance() {
        TestFragment fragment = new TestFragment();
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
        View v = inflater.inflate(R.layout.fragment_test, container, false);
        listTest = (ListView) v.findViewById(R.id.listTest);
        final List<Image> images = new ArrayList<>();
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
        TestAdapter adapter = new TestAdapter(this, images);
        listTest.setAdapter(adapter);
        listTest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(TestFragment.super.getContext(), "Item clicked "+ images.get(position).getImageName(), Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }
}
