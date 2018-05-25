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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.buror.samsungproject.Books_lists.Book0Activity;
import com.example.buror.samsungproject.Items_list.Item0Activity;
import com.example.buror.samsungproject.Items_list.Items;
import com.example.buror.samsungproject.Projects.Internet;
import com.example.buror.samsungproject.R;

//TODO: Добавить модули

public class FragmentModuls extends Fragment {
    public FragmentModuls(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_moduls, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv1);
        ListAdapter listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    class ListAdapter extends RecyclerView.Adapter{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_items, parent, false);
            return new ListViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((ListViewHolder) holder).bindView(position);
        }

        @Override
        public int getItemCount() {
            return Items.ItemsTitle.length;
        }
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txvName, price;
        private ImageView picture;

        public ListViewHolder(View itemView){
            super(itemView);
            txvName = itemView.findViewById(R.id.txt_rv_name);
            price = itemView.findViewById(R.id.txt_rv_price);
            picture = itemView.findViewById(R.id.img_picture);
            itemView.setOnClickListener(this);

        }

        public void bindView(int position){
            txvName.setText(Items.ItemsTitle[position]);
            price.setText(Items.price[position]);
            picture.setImageResource(Items.pictures[position]);
        }

        @Override
        public void onClick(View v) {
            switch(getPosition()){
                case 0:
                    Intent intent0 = new Intent(getActivity(), Item0Activity.class);
                    intent0.putExtra("key","zero");
                    startActivity(intent0);
                    break;
                case 1:
                    Intent intent1 = new Intent(getActivity(), Item0Activity.class);
                    intent1.putExtra("key", "first");
                    startActivity(intent1);
                    break;
                case 2:
                    Intent intent2 = new Intent(getActivity(), Item0Activity.class);
                    intent2.putExtra("key", "second");
                    startActivity(intent2);
                    break;
                case 3:
                    Intent intent3 = new Intent(getActivity(), Item0Activity.class);
                    intent3.putExtra("key", "three");
                    startActivity(intent3);
                    break;
                case 4:
                     Intent intent4 = new Intent(getActivity(), Item0Activity.class);
                     intent4.putExtra("key", "four");
                     startActivity(intent4);
                     break;
                case 5:
                    Intent intent5 = new Intent(getActivity(), Item0Activity.class);
                    intent5.putExtra("key", "five");
                    startActivity(intent5);
                    break;
                case 6:
                    Intent intent6 = new Intent(getActivity(), Item0Activity.class);
                    intent6.putExtra("key", "six");
                    startActivity(intent6);
                    break;
            }
        }
    }

}