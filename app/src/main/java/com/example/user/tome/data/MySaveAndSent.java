package com.example.user.tome.data;

import android.provider.ContactsContract;
import android.provider.Telephony;

/**
 * Created by user on 11/29/2016.
 */
public class MySaveAndSent
{
    private int sms;
    private String send;

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    @Override
    public String toString() {
        return "MySaveAndSent{" +
                "sms=" + sms +
                ", send='" + send + '\'' +
                '}';
    }
}
