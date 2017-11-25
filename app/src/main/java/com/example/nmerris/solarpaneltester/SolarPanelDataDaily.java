package com.example.nmerris.solarpaneltester;

import java.util.Date;

// represents a days worth of solar panel system data, which I assume means the last 24 hours of data
public class SolarPanelDataDaily {
    private Date[] dates;
    private Long[] kwhUsed; // need to use Long instead of long here because AndroidPlot wants a Number as input
    private Long[] kwhGenerated;
    private Float[] cloudCoverPercent;
    private String[] weather;

    // no arg constructor used per Google's GSON documentation on gitHub
    public SolarPanelDataDaily() {
    }


    public Date[] getDates() {
        return dates;
    }

    public void setDates(Date[] dates) {
        this.dates = dates;
    }

    public Long[] getKwhUsed() {
        return kwhUsed;
    }

    public void setKwhUsed(Long[] kwhUsed) {
        this.kwhUsed = kwhUsed;
    }

    public Long[] getKwhGenerated() {
        return kwhGenerated;
    }

    public void setKwhGenerated(Long[] kwhGenerated) {
        this.kwhGenerated = kwhGenerated;
    }

    public Float[] getCloudCoverPercent() {
        return cloudCoverPercent;
    }

    public void setCloudCoverPercent(Float[] cloudCoverPercent) {
        this.cloudCoverPercent = cloudCoverPercent;
    }

    public String[] getWeather() {
        return weather;
    }

    public void setWeather(String[] weather) {
        this.weather = weather;
    }
}
