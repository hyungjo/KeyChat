package com.keychat.dto.base;

import java.io.Serializable;

public class ChannelsHashtagModel implements Serializable {
	private int channels_hashtag_id;
	private String channel_name;
	private String hashtag;

	public ChannelsHashtagModel() {
		super();
	}

	public ChannelsHashtagModel(int channels_hashtag_id, String channel_name, String hashtag) {
		super();
		this.channels_hashtag_id = channels_hashtag_id;
		this.channel_name = channel_name;
		this.hashtag = hashtag;
	}

	public int getChannels_hashtag_id() {
		return channels_hashtag_id;
	}

	public void setChannels_hashtag_id(int channels_hashtag_id) {
		this.channels_hashtag_id = channels_hashtag_id;
	}

	public String getChannel_name() {
		return channel_name;
	}

	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	@Override
	public String toString() {
		return "channels_hashtag_dto [channels_hashtag_id=" + channels_hashtag_id + ", channel_name=" + channel_name
				+ ", hashtag=" + hashtag + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channel_name == null) ? 0 : channel_name.hashCode());
		result = prime * result + channels_hashtag_id;
		result = prime * result + ((hashtag == null) ? 0 : hashtag.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChannelsHashtagModel other = (ChannelsHashtagModel) obj;
		if (channel_name == null) {
			if (other.channel_name != null)
				return false;
		} else if (!channel_name.equals(other.channel_name))
			return false;
		if (channels_hashtag_id != other.channels_hashtag_id)
			return false;
		if (hashtag == null) {
			if (other.hashtag != null)
				return false;
		} else if (!hashtag.equals(other.hashtag))
			return false;
		return true;
	}
}