package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void whattodo(View view){
        switch (view.getId()){
            case R.id.insert:
                Intent insertintent=new Intent(this, Insert.class);
                startActivity(insertintent);
                break;
            case R.id.delete:
                Intent deleteintent=new Intent(this, Delete.class);
                startActivity(deleteintent);
                break;
            case R.id.update:
                Intent updateintent=new Intent(this, Update.class);
                startActivity(updateintent);
                break;
            case R.id.search:
                Intent searchintent=new Intent(this, Search.class);
                startActivity(searchintent);
                break;
            case R.id.viewall:
                Intent viewallintent=new Intent(this, ViewAll.class);
                startActivity(viewallintent);
                break;
        }
    }
}