package com.example.nguyenminhhoang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class option_activity extends AppCompatActivity {
    int index1;
    int index2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_activity);
        Spinner sp1 = (Spinner)findViewById(R.id.sp01);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                index1 = arg2;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
        Spinner sp2 = (Spinner)findViewById(R.id.sp02);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                index2 = arg2;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }
    public void onOK(View view){
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("ForeColor", index1);
        bundle.putInt("BackColor", index2);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
}