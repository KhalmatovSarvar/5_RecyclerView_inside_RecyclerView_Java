package com.example.a5_recyclerview_inside_recyclerview_java.model;

public class SubMember {
    private String status = "Offline";

    public SubMember(String status) {
        this.status = status;
    }
    public SubMember() { }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
