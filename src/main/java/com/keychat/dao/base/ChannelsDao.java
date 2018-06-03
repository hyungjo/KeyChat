package com.keychat.dao.base;

import com.keychat.dto.base.ChannelsModel;

import java.util.List;

/**
 * The interface Channels dao.
 */
public interface ChannelsDao {
    /**
     * Create channel boolean.
     *
     * @param createChannelModel the create channel model
     * @return the boolean
     */
    public boolean createChannel(ChannelsModel createChannelModel);

    /**
     * Read channels list.
     *
     * @param readChannelModel the read channel model
     * @return the list
     */
    public List<ChannelsModel> readChannels(ChannelsModel readChannelModel);

    /**
     * Update channel boolean.
     *
     * @param searchChannelModel the search channel model
     * @param updateChannelModel the update channel model
     * @return the boolean
     */
    public boolean updateChannel(ChannelsModel searchChannelModel, ChannelsModel updateChannelModel);

    /**
     * Delete channel boolean.
     *
     * @param deleteChannelModel the delete channel model
     * @return the boolean
     */
    public boolean deleteChannel(ChannelsModel deleteChannelModel);
}
