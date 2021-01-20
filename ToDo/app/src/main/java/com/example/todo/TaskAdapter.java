package com.example.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private ArrayList<Task> mtask ;//= new ArrayList<>();
    Context context;

    public TaskAdapter(ArrayList<Task> mtask) {
        this.mtask = mtask;
    }

    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list, parent, false);
        TaskAdapter.ViewHolder ev = new TaskAdapter.ViewHolder(v);
        return ev;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {
        final Task task= mtask.get(position);
        holder.nom.setText(task.getNom());
    }

    @Override
    public int getItemCount() {
        return mtask.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nom;

        public ViewHolder(View view) {
            super(view);
            nom = view.findViewById(R.id.nom);
        }
    }

}
