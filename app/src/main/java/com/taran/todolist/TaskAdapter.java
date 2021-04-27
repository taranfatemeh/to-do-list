package com.taran.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private ArrayList<String> tasks = new ArrayList<>();

    public TaskAdapter(){
        tasks.add("انجام پروژه to do") ;
        tasks.add("انجام پروژه sql");
        tasks.add("خواندن زبان");
        tasks.add("خواندن پایاه داده");
        tasks.add("خواندن ریاضی");
        tasks.add("خواندن احتمال");
        tasks.add("دیدن ویدیو");
        tasks.add("دانشگاه");
        tasks.add("اشپزی");
        tasks.add("ارسال رزومه");
        tasks.add("دیزاین پروژه");
        tasks.add("ادیت عکس");
    }
    public void addNewTask(String task){
        tasks.add(0,task);
        notifyItemInserted(0);
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task , parent , false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.bindTask(tasks.get(position));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageViewClose;
        private TextView textViewTask;
        private CheckBox checkBoxFinishTask;
        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTask = itemView.findViewById(R.id.textViewTask);
            checkBoxFinishTask = itemView.findViewById(R.id.checkBoxFinishTask);
            imageViewClose = itemView.findViewById(R.id.imageViewClose);
        }
        public  void bindTask(String task){
            textViewTask.setText(task);
            imageViewClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tasks.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                }
            });
        }
    }

}
