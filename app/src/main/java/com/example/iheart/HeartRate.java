package com.example.iheart;

import java.text.SimpleDateFormat;

/**
 * Created by 21403766 on 15/11/2015.
 */
public class HeartRate {

    public long _id;
    public int rate;


    public HeartRate() {
    }

    public HeartRate(long _id, int rate) {
        this._id = _id;
        this.rate = rate;
    }

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
        String time = df.format(_id);
        return "Date:" + time + " " + "HeartRate:" + rate;
    }
}

