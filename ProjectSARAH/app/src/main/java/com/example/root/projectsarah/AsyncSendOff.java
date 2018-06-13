package com.example.root.projectsarah;

import android.os.AsyncTask;

/**
 * Created by root on 13/06/18.
 */

public class AsyncSendOff extends AsyncTask<communication,Void,String> {

    @Override
    protected String doInBackground(communication... params) {
        params[0].Write("off");

        return null;
    }
}
