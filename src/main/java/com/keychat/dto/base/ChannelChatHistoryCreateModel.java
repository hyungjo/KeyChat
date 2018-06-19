package com.keychat.dto.base;

import java.io.Serializable;
import java.util.Objects;

public class ChannelChatHistoryCreateModel implements Serializable {
    private String email;
    private String channel_name;
    private String contents;

    public ChannelChatHistoryCreateModel(String email, String channel_name, String contents) {
        this.email = email;
        this.channel_name = channel_name;
        this.contents = contents;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChannelChatHistoryCreateModel that = (ChannelChatHistoryCreateModel) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(channel_name, that.channel_name) &&
                Objects.equals(contents, that.contents);
    }

    @Override
    public int hashCode() {

        return Objects.hash(email, channel_name, contents);
    }

    @Override
    public String toString() {
        return "ChannelChatHistoryCreateModel{" +
                "email='" + email + '\'' +
                ", channel_name='" + channel_name + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
