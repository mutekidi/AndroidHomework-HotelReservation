package com.example.student.hotelres;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;
//import android.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragment1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private int adults;
    private int children;
    private int rooms;


    private String checkOut;
    private String checkIn;

    private String tag = "fragment 1";

    private OnFragmentInteractionListener mListener;

    public fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment1 newInstance() {
        fragment1 fragment = new fragment1();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(tag,"onCreateView");

        final View view = inflater.inflate(R.layout.fragment_fragment1, container,false);
        //adultsToText = (TextView)view.findViewById(R.id.adultsToText);
        //addAdult = (Button)view.findViewById(R.id.addAdult);
        Button addAdult = (Button)view.findViewById(R.id.addAdult);
        addAdult.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               // mListener.onFragmentInteraction("test");

                ((Activity1)getActivity()).addAdults();
                //String returnedFromMain = ((Activity1)getActivity()).getShareInFragments();
                TextView adultsToText = (TextView)view.findViewById(R.id.adultsToText);
                adults++;
                adultsToText.setText(String.valueOf(adults));
                mListener.onFragmentInteraction("");
                TextView toStringText = (TextView)view.findViewById(R.id.textTest);
                String returnedFromMain = ((Activity1)getActivity()).getShareInFragments();
                toStringText.setText(returnedFromMain);
            }
        });

        Button addChild = (Button)view.findViewById(R.id.addChild);
        addChild.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ((Activity1)getActivity()).addChildren();
                TextView childrenToText = (TextView)view.findViewById(R.id.childrenToText);
                children++;
                childrenToText.setText(String.valueOf(children));
                mListener.onFragmentInteraction("");
                TextView toStringText = (TextView)view.findViewById(R.id.textTest);
                String returnedFromMain = ((Activity1)getActivity()).getShareInFragments();
                toStringText.setText(returnedFromMain);
            }
        });

        Button addRooms = (Button)view.findViewById(R.id.addRoom);
        addRooms.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                ((Activity1)getActivity()).addRoom();
                TextView roomsToText = (TextView)view.findViewById(R.id.roomsToText);
                rooms++;
                roomsToText.setText(String.valueOf(rooms));

                mListener.onFragmentInteraction("");
                TextView toStringText = (TextView)view.findViewById(R.id.textTest);
                String returnedFromMain = ((Activity1)getActivity()).getShareInFragments();
                toStringText.setText(returnedFromMain);
            }
        });


        Button submit = (Button)view.findViewById(R.id.submitDates);
        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText inEdit = (EditText)view.findViewById(R.id.textEditIn);
                EditText outEdit = (EditText)view.findViewById(R.id.textEditOut);

                ((Activity1)getActivity()).addCheckIn(inEdit.getText().toString());
                ((Activity1)getActivity()).addCheckOut(outEdit.getText().toString());

                mListener.onFragmentInteraction("");
                TextView toStringText = (TextView)view.findViewById(R.id.textTest);
                String returnedFromMain = ((Activity1)getActivity()).getShareInFragments();
                toStringText.setText(returnedFromMain);
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(View view) {
        if (mListener != null) {
            mListener.onFragmentInteraction("Did this get to the Activity?");
        }
    }

    @Override
    public void onAttach(Context context) {
        Log.i(tag,"onAttach");
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i(tag,"onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i(tag,"onPause");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.i(tag,"onStop");
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        Log.i(tag,"onDestroyView");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.i(tag,"onDestroy");
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String value);
    }




}
