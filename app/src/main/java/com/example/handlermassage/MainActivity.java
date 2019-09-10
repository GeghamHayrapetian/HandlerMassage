package com.example.handlermassage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button click;
    private Handler handler;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler=new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                if (msg.what==1)
                Toast.makeText(MainActivity.this, "Above button was clicked",
                        Toast.LENGTH_SHORT).show();

            }
        };
        click=findViewById(R.id.b_click);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(1);
                    }
                });
                thread.start();

            }
        });
    }
}
