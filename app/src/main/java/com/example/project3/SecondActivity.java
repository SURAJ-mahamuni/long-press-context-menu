package com.example.project3;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView imageView;
    Button backB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        initViews();
        getDataInt();
        registerForContextMenu(imageView);
    }

    private void initViews() {
        imageView = findViewById(R.id.imageView);
        backB = findViewById(R.id.backB);
    backB.setOnClickListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contnt_menu, menu);
        menu.setHeaderTitle("Image Menu");
    }

    @Override
    public boolean onContextItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.save:
                makeToast1("Save Button Press");
                break;
            case R.id.saveAs:
                makeToast1("saveAs Button Press");
                break;
            case R.id.download:
                makeToast1("download Button Press");
                break;
            case R.id.copy:
                makeToast1("copy Button Press");
                break;
            case R.id.copyImageLink:
                makeToast1("copyImageLink Button Press");
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void makeToast1(String text) {
        Toast.makeText(SecondActivity.this,text,Toast.LENGTH_SHORT).show();
    }

    private void getDataInt() {
        Intent intent = getIntent();
        int data = intent.getIntExtra("data", 1);
        if(data == R.drawable.audio){
            backB.setBackgroundResource(R.drawable.bg_audio);
            makeToast1("audio");
        }
        if(data == R.drawable.image){
            backB.setBackgroundResource(R.drawable.bg_image);
            makeToast1("image");
        }
        if(data == R.drawable.video){
            backB.setBackgroundResource(R.drawable.bg_video);
            makeToast1("video");
        }
        imageView.setImageResource(data);
    }

    @Override
    public void onClick(View view) {
        if(view == backB){
            Intent intent = getIntent();
            setResult(1,intent);
            finish();
        }
    }
}