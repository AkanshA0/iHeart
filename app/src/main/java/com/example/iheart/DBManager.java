package com.example.iheart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 21403766 on 15/11/2015.
 */
public class DBManager {
    private DBHelper helper;
    private SQLiteDatabase db;

    public DBManager(Context context) {
        helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    public void add(HeartRate heartRate) {
        db.beginTransaction();
        try {
            db.execSQL("INSERT INTO heartrate VALUES(?, ?)", new Object[]{heartRate._id, heartRate.rate});
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    public List<HeartRate> query() {
        ArrayList<HeartRate> rates = new ArrayList<HeartRate>();
        Cursor c = queryTheCursor();
        while (c.moveToNext()) {
            HeartRate rate = new HeartRate();
            rate._id = c.getLong(c.getColumnIndex("_id"));
            rate.rate = c.getInt(c.getColumnIndex("rate"));
            rates.add(rate);
        }
        c.close();
        return rates;
    }

    public Cursor queryTheCursor() {
        Cursor c = db.rawQuery("SELECT * FROM heartrate", null);
        return c;
    }

    public void closeDB() {
        db.close();
    }
}
