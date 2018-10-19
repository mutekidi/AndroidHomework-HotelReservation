package com.example.student.hotelres;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragment2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String tag = "fragment 2";

    TextView text;

    private OnFragmentInteractionListener mListener;

    public fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment2 newInstance(String param1, String param2) {
        fragment2 fragment = new fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        text = (TextView)view.findViewById(R.id.textTest);
        Button submit = (Button)view.findViewById(R.id.buttonSubmit);
        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String roomSelection = "";

                CheckBox firstRoom = (CheckBox)view.findViewById(R.id.room1KingBed);
                if (firstRoom.isChecked()){
                    roomSelection += "One King Bed. ";
                }
                CheckBox secondRoom = (CheckBox)view.findViewById(R.id.room2QueenBed);
                if (secondRoom.isChecked()){
                    roomSelection += "Two Queen Bed. ";
                }
                CheckBox thirdRoom = (CheckBox)view.findViewById(R.id.roomDeluxeSuite);
                if (thirdRoom.isChecked()){
                    roomSelection += "Deluxe Suite. ";
                }
                CheckBox fourthRoom = (CheckBox)view.findViewById(R.id.roomCondo);
                if(fourthRoom.isChecked()){
                    roomSelection += "One Condo. ";
                }

                ((Activity1)getActivity()).addRoomSelection(roomSelection);

                mListener.onFragmentInteraction("");
                TextView toStringText = (TextView)view.findViewById(R.id.textTest);
                String returnedFromMain = ((Activity1)getActivity()).getShareInFragments();
                toStringText.setText(returnedFromMain);
            }
        });



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction("");
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
    public interface OnFragmentInteractionListener{
        // TODO: Update argument type and name
        void onFragmentInteraction(String value);
    }
}
