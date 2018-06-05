package com.keychat.dto.base;

import java.io.Serializable;
import java.util.Date;

public class ChannelsKeywordRecomModel implements Serializable{
	private int channels_keyword_recom_id;
	private String keyword;
	private String channel_name;
	private Date created_datetime;

	public ChannelsKeywordRecomModel() {
		super();
	}

	public ChannelsKeywordRecomModel(int channels_keyword_recom_id, String keyword, String channel_name,
			Date created_datetime) {
		super();
		this.channels_keyword_recom_id = channels_keyword_recom_id;
		this.keyword = keyword;
		this.channel_name = channel_name;
		this.created_datetime = created_datetime;
	}

	public int getChannels_keyword_recom_id() {
		return channels_keyword_recom_id;
	}

	public void setChannels_keyword_recom_id(int channels_keyword_recom_id) {
		this.channels_keyword_recom_id = channels_keyword_recom_id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getChannel_name() {
		return channel_name;
	}

	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}

	public Date getCreated_datetime() {
		return created_datetime;
	}

	public void setCreated_datetime(Date created_datetime) {
		this.created_datetime = created_datetime;
	}

	@Override
	public String toString() {
		return "channels_keyword_recom_dto [channels_keyword_recom_id=" + channels_keyword_recom_id + ", keyword="
				+ keyword + ", channel_name=" + channel_name + ", created_datetime=" + created_datetime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channel_name == null) ? 0 : channel_name.hashCode());
		result = prime * result + channels_keyword_recom_id;
		result = prime * result + ((created_datetime == null) ? 0 : created_datetime.hashCode());
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
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
		ChannelsKeywordRecomModel other = (ChannelsKeywordRecomModel) obj;
		if (channel_name == null) {
			if (other.channel_name != null)
				return false;
		} else if (!channel_name.equals(other.channel_name))
			return false;
		if (channels_keyword_recom_id != other.channels_keyword_recom_id)
			return false;
		if (created_datetime == null) {
			if (other.created_datetime != null)
				return false;
		} else if (!created_datetime.equals(other.created_datetime))
			return false;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		return true;
	}
}
