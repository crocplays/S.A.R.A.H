package com.example.root.projectsarah;

import android.os.AsyncTask;

/**
 * Created by root on 13/06/18.
 */

public class AsyncSendTimedOn extends AsyncTask<Object,Void,String> {
    @Override
    protected String doInBackground(Object... objects) {
        ((communication)objects[0]).Write(((String)objects[1]));
        return null;
    }
}
