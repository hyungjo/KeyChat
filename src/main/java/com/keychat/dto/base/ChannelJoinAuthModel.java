package com.keychat.dto.base;

import java.util.Objects;

public class ChannelJoinAuthModel {
    private String channelName;
    private String password;

    public ChannelJoinAuthModel(String channelName, String password) {
        this.channelName = channelName;
        this.password = password;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChannelJoinAuthModel that = (ChannelJoinAuthModel) o;
        return Objects.equals(channelName, that.channelName) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(channelName, password);
    }

    @Override
    public String toString() {
        return "ChannelJoinAuthModel{" +
                "channelName='" + channelName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
