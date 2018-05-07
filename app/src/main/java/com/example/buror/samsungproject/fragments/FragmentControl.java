package com.example.buror.samsungproject.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.buror.samsungproject.R;

/**
 * Created by buror on 27.01.2018.
 */

public class FragmentControl extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.control_frag, container, false);
    }
}
