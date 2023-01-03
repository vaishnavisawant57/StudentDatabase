package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.studentdatabase.DatabaseHandler;
import com.example.studentdatabase.Student;

import java.util.ArrayList;
import java.util.List;

public class ViewAll extends AppCompatActivity {
    private DatabaseHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        dbHandler= DatabaseHandler.getInstance(this);
        List<Student> students = dbHandler.getAllStudents();
        CustomListAdaptor adapter = new CustomListAdaptor(this, students);
        ListView listView = (ListView) findViewById(R.id.student_list);
        listView.setAdapter(adapter);
    }

}