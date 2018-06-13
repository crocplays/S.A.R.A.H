package com.example.root.projectsarah;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by root on 13/06/18.
 */

public class StatisticsTimeManager {
    private static final StatisticsTimeManager ourInstance = new StatisticsTimeManager();

    private List<Integer> sessionTimesMinutes = new ArrayList<Integer>() ;
    private Date start ;
    private Date stop  ;
    private int diff =0;
    SimpleDateFormat format = new SimpleDateFormat();



    public static StatisticsTimeManager getInstance() {
        return ourInstance;
    }

    private StatisticsTimeManager() {

    }

    public void startSession(){
    start = new Date();

    }




}
