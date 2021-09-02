package com.company;

public class Task_3_Patient {

    private String fname;
    private String sName;
    private String age;
    private String city;
    private String nic;
    private int vacType;

    public Task_3_Patient(String fname , String sName , String age , String city , String nic , int vacType) {
        this.fname = fname;
        this.sName = sName;
        this.age = age;
        this.city = city;
        this.nic = nic;
        this.vacType = vacType;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
}