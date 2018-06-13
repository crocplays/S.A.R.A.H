package com.example.root.projectsarah;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class controlMenuActivity extends AppCompatActivity {

    private communication com;
    //private TextInputLayout timerValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_menu);
        com = communication.getInstance();
        new RetrieveFeedTask().execute(com);

        //TextInputLayout timerValue = (TextInputLayout) findViewById(R.id.timerValue);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Control Panel");
        setSupportActionBar(toolbar);

        //------------------------------------------------------------------------------------------
        //Device DropDown menu
        Spinner deviceList = (Spinner) findViewById(R.id.DeviceList);
        deviceList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        break;
                    case 1:
                        Snackbar alert2 = Snackbar.make(view, "device in port number 2 not connected", 1000);
                        alert2.show();
                        break;
                    case 2:
                        Snackbar alert3 = Snackbar.make(view, "device in port number 3 not connected", 1000);
                        alert3.show();
                        break;
                    case 3:
                        Snackbar alert4 = Snackbar.make(view, "device in port number 4 not connected", 1000);
                        alert4.show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });        //select listener
        String[] devices = new String[]{"Device 1", "Device 2", "Device 3" , "Device 4"}; // list of devices
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, devices);
        deviceList.setAdapter(adapter);
        //------------------------------------------------------------------------------------------

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainMenu.class));
            }
        });
    }

    public void onOnClick(View v){
        new AsyncSendOn().execute(com);
    }

    public void onOffClick(View v){
        new AsyncSendOff().execute(com);
    }

    public void onTimerClick(View v){
       //new AsyncSendTimedOn().execute(com,"Timer " + timerValue.getEditText().getText().toString()); // add textbox with seconds to activate , put the value in the str()
    }



}
