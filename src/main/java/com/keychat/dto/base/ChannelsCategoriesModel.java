package com.keychat.dto.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class ChannelsCategoriesModel implements Serializable{
	private int channels_categories_id;
	private String categories;
	private String channel_name;
	private Timestamp created_datetime;
	
	public ChannelsCategoriesModel(int channels_categories_id, String categories, String channel_name,
			Timestamp created_datetime) {
		super();
		this.channels_categories_id = channels_categories_id;
		this.categories = categories;
		this.channel_name = channel_name;
		this.created_datetime = created_datetime;
	}

	public ChannelsCategoriesModel() {
		super();
	}

	public int getChannels_categories_id() {
		return channels_categories_id;
	}

	public void setChannels_categories_id(int channels_categories_id) {
		this.channels_categories_id = channels_categories_id;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getChannel_name() {
		return channel_name;
	}

	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}

	public Timestamp getCreated_datetime() {
		return created_datetime;
	}

	public void setCreated_datetime(Timestamp created_datetime) {
		this.created_datetime = created_datetime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((channel_name == null) ? 0 : channel_name.hashCode());
		result = prime * result + channels_categories_id;
		result = prime * result + ((created_datetime == null) ? 0 : created_datetime.hashCode());
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
		ChannelsCategoriesModel other = (ChannelsCategoriesModel) obj;
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		if (channel_name == null) {
			if (other.channel_name != null)
				return false;
		} else if (!channel_name.equals(other.channel_name))
			return false;
		if (channels_categories_id != other.channels_categories_id)
			return false;
		if (created_datetime == null) {
			if (other.created_datetime != null)
				return false;
		} else if (!created_datetime.equals(other.created_datetime))
			return false;
		return true;
	}
}
