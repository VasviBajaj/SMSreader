package com.example.rajat.smsreading;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Rajat on 2/28/2018.
 */

public class SMSData {
    private String addr;
    private String body;
    private String rec_date;
    private String send_date;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRec_date() {
        return rec_date;
    }

    public void setRec_date(String rec_date) {
        this.rec_date = convert(rec_date);
    }

    public String getSend_date() {
        return send_date;
    }

    public void setSend_date(String send_date) {
        this.send_date = convert(send_date);
    }

    private String convert (String date)
    {
        long milliSeconds = Long.parseLong(date);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        String finalDateString = formatter.format(calendar.getTime());
        return finalDateString;
    }

}
