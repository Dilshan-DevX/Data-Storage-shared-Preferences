package com.example.datastorage.activity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.datastorage.R;
import com.example.datastorage.helper.SQLiteHelper;

public class SQLite extends AppCompatActivity {

    private Button insertBtn,updateBtn,deleteBtn,searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        this.insertBtn = findViewById(R.id.insertBtn);
        this.updateBtn = findViewById(R.id.updateBtn);
        this.deleteBtn = findViewById(R.id.deleteBtn);
        this.searchBtn = findViewById(R.id.searchBtn);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateData();
            }
        });

          }
          private void insertData(){
              SQLiteHelper sqLiteHelper = SQLiteHelper.getInstance(this);
              SQLiteDatabase writeDb =   sqLiteHelper.getWritableDatabase();
              ContentValues values = new ContentValues();
              values.put("name","tharindu");
              values.put("age",21);
              writeDb.insert("student",null,values);

          }

          private void UpdateData(){
              SQLiteHelper sqLiteHelper = SQLiteHelper.getInstance(this);
              SQLiteDatabase writeDb =   sqLiteHelper.getWritableDatabase();
              ContentValues values = new ContentValues();
              values.put("age",52);
              writeDb.update("student",values,"id = ?",new String[]{String.valueOf(1)});
          }

}