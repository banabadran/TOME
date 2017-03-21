package com.example.user.tome.data;

/**
 * Created by user on 11/29/2016.
 */
public class MyContant {
    private String name;
    private String phone;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "MyContant{" +

                ", name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }
}
