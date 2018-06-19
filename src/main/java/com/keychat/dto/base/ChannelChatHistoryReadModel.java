package com.keychat.dto.base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

public class ChannelChatHistoryReadModel implements Serializable {
    private String channelName;
    private int count;

    public ChannelChatHistoryReadModel(String channelName, int count) {
        this.channelName = channelName;
        this.count = count;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ChannelChatHistoryReadModel that = (ChannelChatHistoryReadModel) o;

        return new EqualsBuilder()
                .append(count, that.count)
                .append(channelName, that.channelName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelName)
                .append(count)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "ChannelChatHistoryReadModel{" +
                "channelName='" + channelName + '\'' +
                ", count=" + count +
                '}';
    }
}
