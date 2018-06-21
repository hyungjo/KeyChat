package com.keychat.dto.base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;

public class ChannelInfoModel {
    private ChannelsModel channelsModel;
    private ArrayList<String> channelsHashtags;

    public ChannelInfoModel(ChannelsModel channelsModel, ArrayList<String> channelsHashtags) {
        this.channelsModel = channelsModel;
        this.channelsHashtags = channelsHashtags;
    }

    public ChannelsModel getChannelsModel() {
        return channelsModel;
    }

    public void setChannelsModel(ChannelsModel channelsModel) {
        this.channelsModel = channelsModel;
    }

    public ArrayList<String> getChannelsHashtags() {
        return channelsHashtags;
    }

    public void setChannelsHashtags(ArrayList<String> channelsHashtags) {
        this.channelsHashtags = channelsHashtags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ChannelInfoModel that = (ChannelInfoModel) o;

        return new EqualsBuilder()
                .append(channelsModel, that.channelsModel)
                .append(channelsHashtags, that.channelsHashtags)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(channelsModel)
                .append(channelsHashtags)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "ChannelInfoModel{" +
                "channelsModel=" + channelsModel +
                ", channelsHashtags=" + channelsHashtags +
                '}';
    }
}
