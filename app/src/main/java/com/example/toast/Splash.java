package com.example.toast.vgwrandomizer;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Splash extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        Thread background = new Thread() {
            public void run() {
                try{sleep(1500);}catch (Exception ignore){}
                Intent i = new Intent(Splash.this, MainActivity.class);
                Splash.this.startActivity(i);
            }
        };

        background.start();
    }
    protected void onDestroy() {

        super.onDestroy();

    }
}

