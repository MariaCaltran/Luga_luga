package com.example.paginalogin.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paginalogin.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FaleConoscoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FaleConoscoFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public FaleConoscoFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FaleConoscoFragment newInstance(String param1, String param2) {
        FaleConoscoFragment fragment = new FaleConoscoFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fale_conosco, container, false);
    }
}