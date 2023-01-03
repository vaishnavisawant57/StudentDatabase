package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Insert extends AppCompatActivity {
    private EditText cnumEdt, nameEdt;
    private Button addstudentBtn;
    private DatabaseHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        dbHandler= DatabaseHandler.getInstance(this);
        cnumEdt = findViewById(R.id.cnuminsert);
        nameEdt = findViewById(R.id.nameinsert);
        addstudentBtn = findViewById(R.id.insertbutton);
        addstudentBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // below line is to get data from all edit text fields.
                String cnum = cnumEdt.getText().toString();
                String name = nameEdt.getText().toString();
                int num = Integer.parseInt(cnum);
                // validating if the text fields are empty or not.
                if (cnum.isEmpty() && name.isEmpty()) {
                    Toast.makeText(Insert.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addStudent(new Student(num,name));

                // after adding the data we are displaying a toast message.
                Toast.makeText(Insert.this, "Student has been added.", Toast.LENGTH_SHORT).show();
                cnumEdt.setText("");
                nameEdt.setText("");
            }
        });
    }
}