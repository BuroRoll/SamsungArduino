package com.example.buror.samsungproject.Projects;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.buror.samsungproject.R;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {
    private List<Projects> list;
    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProjectViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pr, parent, false));
    }

    public ProjectAdapter(List<Projects> list) {
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        Projects project = list.get(position);
        holder.namePr.setText(project.namePro);
        holder.timePr.setText(project.timePro);
    }
    class ProjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener { //holder for Views
        TextView namePr, timePr;
        public ProjectViewHolder(View itemView) {
            super(itemView);
            namePr = itemView.findViewById(R.id.nameProjects);
            timePr = itemView.findViewById(R.id.timeProjects);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d("position", String.valueOf(getPosition()));
            switch (getPosition()) {
                case 0:
                    Intent sss0 = new Intent(itemView.getContext(), Internet.class);
                    sss0.putExtra("link", "https://vk.com/");
                    itemView.getContext().startActivity(sss0);
                    break;
                case 1:
                    Intent sss1 = new Intent(itemView.getContext(), Internet.class);
                    sss1.putExtra("link", "https://ya.ru");
                    itemView.getContext().startActivity(sss1);
                    break;
            }
        }
    }
}
