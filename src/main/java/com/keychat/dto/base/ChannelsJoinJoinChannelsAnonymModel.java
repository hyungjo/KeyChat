package com.keychat.dto.base;

import java.io.Serializable;

public class ChannelsJoinJoinChannelsAnonymModel implements Serializable {
	private String channel_name;
	private String anonym_name;
	public ChannelsJoinJoinChannelsAnonymModel() {
		super();
	}
	public ChannelsJoinJoinChannelsAnonymModel(String channel_name, String anonym_name) {
		super();
		this.channel_name = channel_name;
		this.anonym_name = anonym_name;
	}
	public String getChannel_name() {
		return channel_name;
	}
	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}
	public String getAnonym_name() {
		return anonym_name;
	}
	public void setAnonym_name(String anonym_name) {
		this.anonym_name = anonym_name;
	}
	@Override
	public String toString() {
		return "ChannelsJoinJoinChannelsAnonymDto [channel_name=" + channel_name + ", anonym_name=" + anonym_name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anonym_name == null) ? 0 : anonym_name.hashCode());
		result = prime * result + ((channel_name == null) ? 0 : channel_name.hashCode());
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
		ChannelsJoinJoinChannelsAnonymModel other = (ChannelsJoinJoinChannelsAnonymModel) obj;
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
		return true;
	}
	
}
