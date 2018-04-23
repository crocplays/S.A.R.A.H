package com.example.root.projectsarah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class MainMenu extends AppCompatActivity {

    private Button settingsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Main Menu");
        setSupportActionBar(toolbar);

    }




        public void onSettingsClick(View v) {
            //Start your second activity
            Intent intent = new Intent(MainMenu.this, settingsMenuActivity.class);
            startActivity(intent);
        }

        public void onStatisticsClick(View v){
            Intent intent = new Intent(MainMenu.this,statisticsMenuActivity.class);
            startActivity(intent);
        }

        public void onControlClick(View v){
            Intent intent = new Intent(MainMenu.this,controlMenuActivity.class);
            startActivity(intent);
        }



}
