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



import com.example.buror.samsungproject.Books_lists.Book0Activity;
import com.example.buror.samsungproject.Books_lists.Books;
import com.example.buror.samsungproject.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class FragmentBook extends Fragment {
    public FragmentBook() {}
    private AdView mAdView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_book, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv);
        ListAdapter listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
//        MobileAds.initialize(getActivity(),
//                "ca-app-pub-2406878860777073/2323998984");
//
//        mAdView = view.findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
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
                 Intent intent = new Intent(getActivity(), Book0Activity.class);
                 intent.putExtra("key","zero");
                 startActivity(intent);
                 break;
             case 1:
                 Intent intent1 = new Intent(getActivity(), Book0Activity.class);
                 intent1.putExtra("key","one");
                 startActivity(intent1);
                 break;
             case 2:
                 Intent intent2 = new Intent(getActivity(), Book0Activity.class);
                 intent2.putExtra("key","two");
                 startActivity(intent2);
                 break;
             case 3:
                 Intent intent3 = new Intent(getActivity(), Book0Activity.class);
                 intent3.putExtra("key","three");
                 startActivity(intent3);
                 break;
             case 4:
                 Intent intent4 = new Intent(getActivity(), Book0Activity.class);
                 intent4.putExtra("key","four");
                 startActivity(intent4);
                 break;
             case 5:
                 Intent intent5 = new Intent(getActivity(), Book0Activity.class);
                 intent5.putExtra("key", "five");
                 startActivity(intent5);
                 break;
             case 6:
                 Intent intent6 = new Intent(getActivity(), Book0Activity.class);
                 intent6.putExtra("key", "six");
                 startActivity(intent6);
                 break;
             case 7:
                 Intent intent7 = new Intent(getActivity(), Book0Activity.class);
                 intent7.putExtra("key", "seven");
                 startActivity(intent7);
                 break;
             case 8:
                 Intent intent8 = new Intent(getActivity(), Book0Activity.class);
                 intent8.putExtra("key", "eight");
                 startActivity(intent8);
                 break;
             case 9:
                 Intent intent9 = new Intent(getActivity(), Book0Activity.class);
                 intent9.putExtra("key", "nine");
                 startActivity(intent9);
                 break;
             case 10:
                 Intent intent10 = new Intent(getActivity(), Book0Activity.class);
                 intent10.putExtra("key", "ten");
                 startActivity(intent10);
                 break;
         }
     }
 }
}