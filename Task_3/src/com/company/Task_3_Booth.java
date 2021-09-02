package com.company;

public class Task_3_Booth extends Task_3_Patient {

    private String customerName;
    /*private String fname;
    private String sName;
    private String age;
    private String city;
    private String nic;
    private int vacType;*/

    public Task_3_Booth(String fname , String sName , String age , String city , String nic , int vacType) {
        super(fname,sName,age,city,nic,vacType);
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}