package com.keychat.dto.base;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class ChannelsJoinModel implements Serializable{
	private int channels_join_id;
	private String channel_name;
	private String email;
	private Timestamp joined_datetime;

	public ChannelsJoinModel() {
		super();
	}

	public ChannelsJoinModel(int channels_join_id, String channel_name, String email, Timestamp joined_datetime) {
		super();
		this.channels_join_id = channels_join_id;
		this.channel_name = channel_name;
		this.email = email;
		this.joined_datetime = joined_datetime;
	}

	public int getChannels_join_id() {
		return channels_join_id;
	}

	public void setChannels_join_id(int channels_join_id) {
		this.channels_join_id = channels_join_id;
	}

	public String getChannel_name() {
		return channel_name;
	}

	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getJoined_datetime() {
		return joined_datetime;
	}

	public void setJoined_datetime(Timestamp joined_datetime) {
		this.joined_datetime = joined_datetime;
	}

	@Override
	public String toString() {
		return "channels_join_dto [channels_join_id=" + channels_join_id + ", channel_name=" + channel_name + ", email="
				+ email + ", joined_datetime=" + joined_datetime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channel_name == null) ? 0 : channel_name.hashCode());
		result = prime * result + channels_join_id;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((joined_datetime == null) ? 0 : joined_datetime.hashCode());
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
		ChannelsJoinModel other = (ChannelsJoinModel) obj;
		if (channel_name == null) {
			if (other.channel_name != null)
				return false;
		} else if (!channel_name.equals(other.channel_name))
			return false;
		if (channels_join_id != other.channels_join_id)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (joined_datetime == null) {
			if (other.joined_datetime != null)
				return false;
		} else if (!joined_datetime.equals(other.joined_datetime))
			return false;
		return true;
	}

}