package com.example.buror.samsungproject.fragments;



import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.example.buror.samsungproject.Books_lists.Book0Activity;
import com.example.buror.samsungproject.Books_lists.Books;
import com.example.buror.samsungproject.R;

//TODO: Добавить кликабельности на страницы
public class FragmentBook extends Fragment {
    public FragmentBook() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_book, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv);
        ListAdapter listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }



 class ListAdapter extends RecyclerView.Adapter{

     @Override
     public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
         return new ListViewHolder(view);
     }

     @Override
     public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         ((ListViewHolder) holder).bindView(position);
     }

     @Override
     public int getItemCount() {
         return Books.title.length;
     }
 }

 private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
     private TextView txvName;

     public ListViewHolder(View itemView){
         super(itemView);
         txvName = itemView.findViewById(R.id.txt_rv_name);
         itemView.setOnClickListener(this);

     }

     public void bindView(int position){ //установка данных на экран
         txvName.setText(Books.title[position]);
     }

     @Override
     public void onClick(View v) {
         switch(getPosition()){
             case 0:
                 Intent go0 = new Intent(getActivity(), Book0Activity.class);
                 startActivity(go0);
                 break;
             case 1:
                 Toast.makeText(getActivity(), String.valueOf(getPosition()), Toast.LENGTH_SHORT).show();
                 break;
             case 2:
                 Toast.makeText(getActivity(), String.valueOf(getPosition()), Toast.LENGTH_SHORT).show();
                 break;
         }
     }
 }
}