package com.example.root.projectsarah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    private Button settingsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        settingsButton = (Button)findViewById(R.id.settings);

        settingsButton.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            //Start your second activity
            Intent intent = new Intent(MainMenu.this, settingsMenuActivity.class);
            startActivity(intent);
        }
    });


}
}
