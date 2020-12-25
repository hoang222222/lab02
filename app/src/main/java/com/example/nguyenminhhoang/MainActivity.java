package com.example.nguyenminhhoang;

import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etnote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.clear:
                AlertDialog.Builder message = new AlertDialog.Builder(this);
                message.setTitle(R.string.message_cation);
                message.setMessage(R.string.message_content);
                message.setNeutralButton(R.string.close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText et = (EditText) findViewById(R.id.etnote);
                        et.setText("");
                    }
                }).show();
                break;
            case R.id.setting:
                Intent intent = new Intent(this,option_activity.class);
                final int result=1;
                startActivityForResult(intent, result);
                break;
            case R.id.exit:
                new AlertDialog.Builder(this)
                        .setTitle(R.string.exit_caption)
                        .setMessage(R.string.exit_content)
                        .setNegativeButton(R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }

                        })
                        .setPositiveButton(R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                return;
                            }
                        }).show();
                break;


        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle bundle = data.getExtras();
        int index1 = bundle.getInt("ForeColor");
        int index2 = bundle.getInt("BackColor");

        String colorArray[] = getResources().getStringArray(R.array.color_array);

        EditText et = (EditText) findViewById(R.id.etnote);

        et.setTextColor(Color.parseColor(colorArray[index1]));
        et.setBackgroundColor(Color.parseColor(colorArray[index2]));
    }
}