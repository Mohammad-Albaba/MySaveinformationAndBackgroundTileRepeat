package com.example.mysaveinformation;

import androidx.annotation.Size;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.awt.font.TextAttribute;

public class MainActivity extends AppCompatActivity {
EditText etxt;
TextView txtshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etxt=findViewById(R.id.etxt);
        txtshow=findViewById(R.id.txtshow);
    }
    public void btn_save(View view){
        SharedPreferences shrd=getSharedPreferences("savefile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=shrd.edit();

        editor.putString("name",etxt.getText().toString());
//        editor.putString("pass","123");
  //      editor.putString("fontcolor","#fff");
        editor.apply();
        String txt="تم حفظ المعلومات";
      Toast toast= Toast.makeText(this, txt, Toast.LENGTH_SHORT);
        View bg= toast.getView();
        bg.setBackgroundColor(Color.parseColor("#ffdd1696"));
        toast.setGravity(Gravity.CENTER,0,0);

        toast.show();

    }
    public void btn_load(View view){
        SharedPreferences shrd=getSharedPreferences("savefile",Context.MODE_PRIVATE);
        String name=shrd.getString("name","ON_DATA");
        txtshow.setText(name);
        String txt2="تم تحميل البيانات التي تم حفظها";
        Toast toast=Toast.makeText(this,txt2,Toast.LENGTH_SHORT);
                View bg=toast.getView();
                bg.setBackgroundColor(Color.parseColor("#ffdd1696"));
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
    }
}
