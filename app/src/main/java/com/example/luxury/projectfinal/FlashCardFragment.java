package com.example.luxury.projectfinal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *
 * to handle interaction events.
 * Use the {@link FlashCardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FlashCardFragment extends Fragment {
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

//    private OnFragmentInteractionListener mListener;

    TextView textView;
    boolean isFlipped = true;
    CardView cardFront, cardBack;
    ImageView imageViewFront;
    TextView cardTextAnswer, textDescription;
    ArrayList<Learn> data = new ArrayList<>();
    ImageButton goNext, goPrevious;
    int index = 1;

    public FlashCardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
     * @return A new instance of fragment FlashCardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FlashCardFragment newInstance() {
        FlashCardFragment fragment = new FlashCardFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }
    // set data
    void setData(Learn learn) {
        if (!learn.getUrl().equals("")) {
            imageViewFront.setImageResource(R.drawable.blackdog);
            if (!learn.getName().equals("")) {
                cardTextAnswer.setText(learn.getName().toString());
            }
            if (!learn.getDescription().equals("")) {
                textDescription.setText(learn.getDescription().toString());
            }
        }
    }


    // go next
    void learnGoNext () {
        if (index < data.size()-1) {

            if (!isFlipped) {
                cardBack.setVisibility(View.GONE);
                cardFront.setVisibility(View.VISIBLE);
            }
            isFlipped = true;
            index++;
            setData(data.get(index));
        }
    }

    // go previous
    void learnGoPrevious () {
        if (index > 0) {
            if (!isFlipped) {
                cardBack.setVisibility(View.GONE);
                cardFront.setVisibility(View.VISIBLE);
            }
            isFlipped = true;
            index--;
            setData(data.get(index));
        }
    }


    // flip card view
    void flipCard() {
        if (isFlipped) {
            cardFront.animate().withLayer()
            .rotationY(90)
            .setDuration(400)
            .withEndAction(new Runnable() {
                @Override public void run() {
                    cardFront.setRotationY(0);
                    cardFront.setVisibility(View.GONE);
                    cardBack.setVisibility(View.VISIBLE);
                }}).start();
        } else {
            cardBack.animate().withLayer()
                .rotationY(90)
                .setDuration(400)
                .withEndAction(new Runnable() {
                    @Override public void run() {
                        cardBack.setRotationY(0);
                        cardBack.setVisibility(View.GONE);
                        cardFront.setVisibility(View.VISIBLE);
                }}).start();
        }
        isFlipped = !isFlipped;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_flash_card, container, false);

        data.add(new Learn("@drawable/blackdog", "Con cho", "Con vật mà rất trung thành với chủ nhân 1.", 1));
        data.add(new Learn("@drawable/blackdog", "Con cho1", "Con vật mà rất trung thành với chủ nhân 2.", 1));
        data.add(new Learn("@drawable/blackdog", "Con cho2", "Con vật mà rất trung thành với chủ nhân 3.", 1));
        data.add(new Learn("@drawable/blackdog", "Con cho3", "Con vật mà rất trung thành với chủ nhân 4.", 1));

        imageViewFront = v.findViewById(R.id.imageViewFront);
        cardTextAnswer = v.findViewById(R.id.cardTextAnswer);
        textDescription = v.findViewById(R.id.textDescription);

        cardFront = v.findViewById(R.id.cardFrontImageLearn);
        cardBack = v.findViewById(R.id.cardBackImageLearn);

        goNext = v.findViewById(R.id.imageButtonLeft);
        goPrevious = v.findViewById(R.id.imageButton);

        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                learnGoNext();
            }
        });
        goPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                learnGoPrevious();
            }
        });

        cardBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard();
            }
        });

        cardFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard();
            }
        });
//        // init data for first time
        setData(data.get(index));
        return v;
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
