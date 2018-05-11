package com.example.buror.samsungproject.IDE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.buror.samsungproject.R;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CodeViewHolder> {
    private ArrayList<Code> code1;
    private Context context;
    private int position;
    int key2 = 2;

    public RVAdapter(ArrayList<Code> code, Context context) {
        this.code1 = code;
        this.context = context;
    }

    public CodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_ide, parent, false);
        return new CodeViewHolder(view);
    }

    public void onBindViewHolder(CodeViewHolder holder, int position) {
        this.position = position;
        final Code code = code1.get(position);


        holder.setRecord(code);
        holder.textName.setText(code.getName());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Info.class);
                intent.putExtra("codeSend",code);
                Log.d("Отправил", String.valueOf(code));
                ((Activity) context).startActivityForResult(intent, key2);
            }
        });
    }


    @Override
    public int getItemCount() {
        return code1.size();
    }

    class CodeViewHolder extends RecyclerView.ViewHolder {
        TextView textName;
        CardView cv;
        Code code;

        public CodeViewHolder(View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.card_name_ide);
            cv = itemView.findViewById(R.id.card_view_ide);
        }
        public void setRecord(Code code) {
            this.code = code;
        }
    }
}