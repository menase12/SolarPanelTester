package com.example.nmerris.solarpaneltester;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class JsonDummyDataLoader {

    private static final int UPDATE_INTERVAL = 15;
    

    // we are assuming that each data point is 15 > than the previous data point, in real life I would assume
    // that the date/timestamp will just be generated by the server that is sending out the json data
    public static SolarPanelDataDaily generateDaily(int numDataPoints) {

        Date[] dates = new Date[numDataPoints];
        Long[] kwhUsed = new Long[numDataPoints];
        Long[] kwhGenerated = new Long[numDataPoints];
        Float[] cloudCoverPercent = new Float[numDataPoints];
        String[] weather = new String[numDataPoints];

        Calendar cal = Calendar.getInstance();
        Date now = new Date();


        SolarPanelDataDaily spdd = new SolarPanelDataDaily();
        for (int i = 0; i < numDataPoints; i++) {
            // subtract time from now in 15 minute chunks
            // so dates[0] will have the oldest data point
            // and dates[numDataPoints - 1] will have the newest data point
            cal.setTime(now);
            cal.add(Calendar.MINUTE, -UPDATE_INTERVAL * (numDataPoints - i));
            dates[i] = cal.getTime();


            weather[i] = "sunny";
            cloudCoverPercent[i] = ThreadLocalRandom.current().nextFloat();
            kwhGenerated[i] = ThreadLocalRandom.current().nextLong(100, 1000);
            kwhUsed[i] = ThreadLocalRandom.current().nextLong(1000, 5000);

        }




        spdd.setWeather(weather);
        spdd.setKwhUsed(kwhUsed);
        spdd.setKwhGenerated(kwhGenerated);
        spdd.setCloudCoverPercent(cloudCoverPercent);
        spdd.setDates(dates);
        return spdd;
    }
    
    
    
    
}
