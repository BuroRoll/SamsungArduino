package com.example.buror.samsungproject.fragments;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.example.buror.samsungproject.Chat.ChatActivity;
import com.example.buror.samsungproject.Chat.Just;

/**
 * Created by buror on 26.01.2018.
 */

public class FragmentChat extends ListFragment {
    String data[] = new String[] { " " };

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, data);
        setListAdapter(adapter);
        Intent myyIntent = new Intent(FragmentChat.this.getActivity(), ChatActivity.class);
        startActivity(myyIntent);
    }

//    public void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
//        Toast.makeText(getActivity(), "position = " + position, Toast.LENGTH_SHORT).show();
//        if(position == 0) {
//            Intent myyIntent = new Intent(FragmentChat.this.getActivity(), ChatActivity.class);
//            startActivity(myyIntent);
//        }
//    }
}
