package com.keychat.dao.dummy;

import com.keychat.dao.base.ChannelsDao;
import com.keychat.dto.base.ChannelsModel;

import java.util.List;

public class ChannelsDummy implements ChannelsDao {
    @Override
    public boolean createChannel(ChannelsModel createChannelModel) {
        return false;
    }

    @Override
    public List<ChannelsModel> readChannels(ChannelsModel readChannelModel) {
        return null;
    }

    @Override
    public boolean updateChannel(ChannelsModel searchChannelModel, ChannelsModel updateChannelModel) {
        return false;
    }

    @Override
    public boolean deleteChannel(ChannelsModel deleteChannelModel) {
        return false;
    }
}
