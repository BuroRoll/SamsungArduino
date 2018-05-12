package com.example.buror.samsungproject.Projects;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.buror.samsungproject.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.victor.loading.book.BookLoading;
import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {
    public Fragment1() {
    }

    private RecyclerView recyclerView;
    private List<Projects> result;
    private ProjectAdapter adapter;
    BookLoading loading;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        loading = view.findViewById(R.id.bookloading);
        loading.start();
        result = new ArrayList<>();
        recyclerView = view.findViewById(R.id.rvProjects);
        recyclerView.setHasFixedSize(true);
        database = FirebaseDatabase.getInstance();//получение экземпляра БД
        reference = database.getReference("projects"); //ссылка на ветку проектов
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        adapter = new ProjectAdapter(result);
        recyclerView.setAdapter(adapter);
        updateList();
        return view;
    }

    private FirebaseDatabase database;
    private DatabaseReference reference;

    private void updateList(){ //достаём данные из firebase
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                result.add(dataSnapshot.getValue(Projects.class));
                adapter.notifyDataSetChanged();
                loading.stop();
                if(!loading.isStart()){
                    loading.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Projects projects = dataSnapshot.getValue(Projects.class);
                int index = getItemIndex(projects);
                result.set(index, projects);
                adapter.notifyItemChanged(index);
                loading.stop();
                if(!loading.isStart()){
                    loading.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Projects projects = dataSnapshot.getValue(Projects.class);
                int index = getItemIndex(projects);
                result.remove(index);
                adapter.notifyItemRemoved(index);
                loading.stop();
                if(!loading.isStart()){
                    loading.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onCancelled(DatabaseError databaseError) {}

        });
    }
    private int getItemIndex(Projects projects){
        int index = -1;
        for (int i = 0; i < result.size(); i++) {
            if(result.get(i).key.equals(projects.key)){
                index = i;
                break;
            }
        }
        return index;
    }
}