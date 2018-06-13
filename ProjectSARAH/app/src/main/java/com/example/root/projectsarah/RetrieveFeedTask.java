package com.example.root.projectsarah;

import android.os.AsyncTask;

/**
 * Created by root on 13/06/18.
 */

public class RetrieveFeedTask extends AsyncTask<communication,Void,String> {
    @Override
    protected String doInBackground(communication... params) {
        params[0].Bind("10.0.0.50",4320);

        return null;
    }
}
