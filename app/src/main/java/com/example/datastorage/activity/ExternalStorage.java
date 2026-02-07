package com.example.datastorage.activity;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.datastorage.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ExternalStorage extends AppCompatActivity {

    private Button exWriteBtn, exReadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_external_storage);

        this.exWriteBtn = findViewById(R.id.button);
        this.exReadBtn = findViewById(R.id.button2);

        exWriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeFile();
                writeFileInDownload();
            }
        });

        exReadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadFile();
                readFileInDownload();
            }
        });

    }

    private static final String FILE_NAME = "data.txt";
    private void writeFile(){
        try{
            File dir = getExternalFilesDir(null);
            File file = new File(dir,FILE_NAME);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            String text = "My name is Tharindu";
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private void ReadFile(){
        try {
            File dir = getExternalFilesDir(null);
            File file = new File(dir,FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }

            bufferedReader.close();
            Toast.makeText(this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeFileInDownload(){
        try {
            ContentValues values =  new ContentValues();
            values.put(MediaStore.Downloads.DISPLAY_NAME,FILE_NAME);
            values.put(MediaStore.Downloads.MIME_TYPE,"text/plain");

            Uri uri = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                uri = getContentResolver().insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI,values);
            }
            OutputStream outputStream = getContentResolver().openOutputStream(uri);
            String text = "this is sample text";
            outputStream.write(text.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    private void readFileInDownload(){

    }
}