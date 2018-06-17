package com.keychat.dto.base;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;

public class ChannelCreateModel implements Serializable{
    private String name;
    private String password;
    private int limitCapacity;
    private int limitTime;
    private String limitAnonym;
    private ArrayList<String> hashtags;

    public ChannelCreateModel(String name, String password, int limitCapacity, int limitTime, String limitAnonym, ArrayList<String> hashtags) {
        this.name = name;
        this.password = password;
        this.limitCapacity = limitCapacity;
        this.limitTime = limitTime;
        this.limitAnonym = limitAnonym;
        this.hashtags = hashtags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLimitCapacity() {
        return limitCapacity;
    }

    public void setLimitCapacity(int limitCapacity) {
        this.limitCapacity = limitCapacity;
    }

    public int getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(int limitTime) {
        this.limitTime = limitTime;
    }

    public String getLimitAnonym() {
        return limitAnonym;
    }

    public void setLimitAnonym(String limitAnonym) {
        this.limitAnonym = limitAnonym;
    }

    public ArrayList<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(ArrayList<String> hashtags) {
        this.hashtags = hashtags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChannelCreateModel that = (ChannelCreateModel) o;
        return limitCapacity == that.limitCapacity &&
                limitTime == that.limitTime &&
                Objects.equals(name, that.name) &&
                Objects.equals(password, that.password) &&
                Objects.equals(limitAnonym, that.limitAnonym) &&
                Objects.equals(hashtags, that.hashtags);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, password, limitCapacity, limitTime, limitAnonym, hashtags);
    }

    @Override
    public String toString() {
        return "ChannelCreateModel{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", limitCapacity=" + limitCapacity +
                ", limitTime=" + limitTime +
                ", limitAnonym='" + limitAnonym + '\'' +
                ", hashtags=" + hashtags +
                '}';
    }
}
