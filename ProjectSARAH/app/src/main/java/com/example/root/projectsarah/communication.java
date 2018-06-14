package com.example.root.projectsarah;
import android.os.AsyncTask;

import java.io.*;
import java.net.*;
/**
 * Created by root on 12/06/18.
 */

public class communication {

    private static communication ourInstance;

    public static communication getInstance(String ip,int port) {
         if (ourInstance == null){ourInstance = new communication( ip, port);}
         return ourInstance;
    }
    private  DataInputStream iIn;
    private DataOutputStream dout;

    private communication(String ip,int port) {
        try{
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            Socket sock = new Socket(ip, port);
            dout = new DataOutputStream(sock.getOutputStream());
            iIn = new DataInputStream(sock.getInputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(sock.getInputStream()));


        }catch(Exception e){

            e.printStackTrace();
        }

    }



    public void Bind(String ip , int port){
        try{
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            Socket sock = new Socket(ip, port);
             dout = new DataOutputStream(sock.getOutputStream());
             iIn = new DataInputStream(sock.getInputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(sock.getInputStream()));


        }catch(Exception e){

            e.printStackTrace();
        }

    }

    public void Write(String data){
        try{dout.writeUTF(data);}
        catch(Exception e){e.printStackTrace();}
    }

    public String Read(){
        try{return iIn.readUTF();}
        catch(Exception e){
            e.printStackTrace();
            return "Error";}

    }


}
