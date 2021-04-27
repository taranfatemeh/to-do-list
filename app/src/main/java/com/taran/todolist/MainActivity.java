package com.taran.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private TaskAdapter adapter;
    private RecyclerView recyclerViewTasks;
    private EditText editTextNewTask;
    private ImageView imgAddNewTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new TaskAdapter();
        editTextNewTask = findViewById(R.id.editTextTextNewTask);
        imgAddNewTask = findViewById(R.id.imgAddNewTask);
        recyclerViewTasks = findViewById(R.id.recyclerViewTasks);
        recyclerViewTasks.setLayoutManager(new LinearLayoutManager(this , RecyclerView.VERTICAL , false));
        recyclerViewTasks.setAdapter(adapter);

        imgAddNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextNewTask.getText().length() > 0){
                    adapter.addNewTask(editTextNewTask.getText().toString());
                    recyclerViewTasks.smoothScrollToPosition(0);
                    editTextNewTask.setText(null);
                }else {
                    editTextNewTask.setError("please write new task");

                }
            }
        });
    }
}