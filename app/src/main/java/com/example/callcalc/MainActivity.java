package com.example.callcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_start_calc).setOnClickListener(v -> {
            Intent intent = new Intent(getString(R.string.calc_name));

            ActivityInfo activityInfo =
                    intent.resolveActivityInfo(getPackageManager(),
                            intent.getFlags());
            if (activityInfo != null) {
                startActivity(intent);
            } else{
                Toast.makeText(getApplicationContext(),"Не удалось найти калькулятор "+getResources().getString(R.string.calc_name),Toast.LENGTH_SHORT).show();
            }
        });
    }
}