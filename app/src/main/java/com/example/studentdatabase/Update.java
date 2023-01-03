package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    private EditText cnumEdt;
    private EditText newnameEdt;
    private Button updateStuBtn;
    private DatabaseHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        dbHandler = DatabaseHandler.getInstance(this);
        cnumEdt = findViewById(R.id.cnumupdate);
        newnameEdt = findViewById(R.id.newnameupdate);
        updateStuBtn = findViewById(R.id.updatebutton);
        updateStuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // below line is to get data from all edit text fields.
                String cnum = cnumEdt.getText().toString();
                String newname = newnameEdt.getText().toString();
                int num = Integer.parseInt(cnum);
                // validating if the text fields are empty or not.
                if (cnum.isEmpty()) {
                    Toast.makeText(Update.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.updateStudent(num, newname);

                // after deleting the data we are displaying a toast message.
                Toast.makeText(Update.this, "Student has been updated.", Toast.LENGTH_SHORT).show();
                cnumEdt.setText("");
                newnameEdt.setText("");
            }
        });
    }
}