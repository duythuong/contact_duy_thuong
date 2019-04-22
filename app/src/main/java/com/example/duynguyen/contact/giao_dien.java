package com.example.duynguyen.contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class giao_dien extends AppCompatActivity {
    EditText editText1,editText2,editText3;
    database database;
    doituong doituong;
    Button button;
    Intent intent;
    int str1 = 0;
    boolean kt;
    ArrayList<doituong> doituongs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giao_dien);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);

        intent = getIntent();
        String str = intent.getStringExtra("id");
        kt = intent.getBooleanExtra("boolean",false);
        System.out.println(kt);


        database = new database(this);

        if(kt){
            doituongs = database.getThongTin(str);
            str1 = doituongs.get(0).getId();
            editText1.setText(doituongs.get(0).getFilsname());
            editText2.setText(doituongs.get(0).getMobile());
            editText3.setText(doituongs.get(0).getEmail());
        }

        button = findViewById(R.id.click);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kt == true){
                    try{
                        doituong = new doituong(str1,editText1.getText().toString(),editText2.getText().toString(),editText3.getText().toString());
                        database.update(doituong);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }else {
                    try{
                        doituong = new doituong(editText1.getText().toString(),editText2.getText().toString(),editText3.getText().toString());
                        database.addStudent(doituong);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                intent = new Intent(giao_dien.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
