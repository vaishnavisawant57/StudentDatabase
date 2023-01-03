package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Search extends AppCompatActivity {
    private EditText cnumEdt;
    private Button searchbtn;
    private DatabaseHandler dbHandler;
    private TextView name;
    private TextView cnum1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        dbHandler= DatabaseHandler.getInstance(this);
        cnumEdt = findViewById(R.id.cnumsearch);
        searchbtn = findViewById(R.id.searchbutton);
        name=findViewById(R.id.searchname);
        cnum1=findViewById(R.id.searcchcnum);
        searchbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // below line is to get data from all edit text fields.
                String cnum = cnumEdt.getText().toString();
                int num = Integer.parseInt(cnum);
                // validating if the text fields are empty or not.
                if (cnum.isEmpty()) {
                    Toast.makeText(Search.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                Student stu=dbHandler.getStudent(num);

                if(stu!=null){
                    name.setText(stu.getName());
                    cnum1.setText(String.valueOf(stu.getID()));
                }
            }
        });
    }
}