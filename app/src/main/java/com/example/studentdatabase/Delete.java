package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {
    private EditText cnumEdt;
    private Button deleteStuButton;
    private DatabaseHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        dbHandler= DatabaseHandler.getInstance(this);
        cnumEdt = findViewById(R.id.cnumdelete);
        deleteStuButton = findViewById(R.id.deletebutton);
        deleteStuButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // below line is to get data from all edit text fields.
                String cnum = cnumEdt.getText().toString();
                int num = Integer.parseInt(cnum);
                // validating if the text fields are empty or not.
                if (cnum.isEmpty()) {
                    Toast.makeText(Delete.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.deleteStudent(num);

                // after deleting the data we are displaying a toast message.
                Toast.makeText(Delete.this, "Student has been deleted.", Toast.LENGTH_SHORT).show();
                cnumEdt.setText("");
            }
        });
    }
}