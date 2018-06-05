package com.keychat.dto.base;

import java.io.Serializable;

public class ChannelsAnonymModel implements Serializable{
	private int channels_anonym_id;
	private String anonym_name;
	private String email;
	private String channel_name;

	public ChannelsAnonymModel() {
		super();
	}

	public ChannelsAnonymModel(int channels_anonym_id, String anonym_name, String email, String channel_name) {
		super();
		this.channels_anonym_id = channels_anonym_id;
		this.anonym_name = anonym_name;
		this.email = email;
		this.channel_name = channel_name;
	}

	public int getChannels_anonym_id() {
		return channels_anonym_id;
	}

	public void setChannels_anonym_id(int channels_anonym_id) {
		this.channels_anonym_id = channels_anonym_id;
	}

	public String getAnonym_name() {
		return anonym_name;
	}

	public void setAnonym_name(String anonym_name) {
		this.anonym_name = anonym_name;
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

	@Override
	public String toString() {
		return "channels_anonym_dto [channels_anonym_id=" + channels_anonym_id + ", anonym_name=" + anonym_name
				+ ", email=" + email + ", channel_name=" + channel_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anonym_name == null) ? 0 : anonym_name.hashCode());
		result = prime * result + ((channel_name == null) ? 0 : channel_name.hashCode());
		result = prime * result + channels_anonym_id;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		ChannelsAnonymModel other = (ChannelsAnonymModel) obj;
		if (anonym_name == null) {
			if (other.anonym_name != null)
				return false;
		} else if (!anonym_name.equals(other.anonym_name))
			return false;
		if (channel_name == null) {
			if (other.channel_name != null)
				return false;
		} else if (!channel_name.equals(other.channel_name))
			return false;
		if (channels_anonym_id != other.channels_anonym_id)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
}