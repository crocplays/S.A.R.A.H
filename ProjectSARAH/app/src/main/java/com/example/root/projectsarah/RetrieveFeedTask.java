package com.example.root.projectsarah;

import android.os.AsyncTask;

/**
 * Created by root on 13/06/18.
 */

public class RetrieveFeedTask extends AsyncTask<communication,Void,communication> {
    @Override
    protected communication doInBackground(communication... params) {
        params[0] = communication.getInstance("192.168.2.102",4320);

        return params[0];
    }
}
