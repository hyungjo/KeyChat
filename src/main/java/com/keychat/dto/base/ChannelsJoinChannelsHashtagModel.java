package com.keychat.dto.base;

import java.io.Serializable;

public class ChannelsJoinChannelsHashtagModel implements Serializable{
	private String name;
	private int limit_capacity;
	private int limit_time;
	private int limit_anonym;
	private String hashtag;

	public ChannelsJoinChannelsHashtagModel() {
		super();
	}

	public ChannelsJoinChannelsHashtagModel(String name, int limit_capacity, int limit_time, int limit_anonym,
			String hashtag) {
		super();
		this.name = name;
		this.limit_capacity = limit_capacity;
		this.limit_time = limit_time;
		this.limit_anonym = limit_anonym;
		this.hashtag = hashtag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLimit_capacity() {
		return limit_capacity;
	}

	public void setLimit_capacity(int limit_capacity) {
		this.limit_capacity = limit_capacity;
	}

	public int getLimit_time() {
		return limit_time;
	}

	public void setLimit_time(int limit_time) {
		this.limit_time = limit_time;
	}

	public int getLimit_anonym() {
		return limit_anonym;
	}

	public void setLimit_anonym(int limit_anonym) {
		this.limit_anonym = limit_anonym;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	@Override
	public String toString() {
		return "ChannelsJoinChannelsHashtagDto [name=" + name + ", limit_capacity=" + limit_capacity + ", limit_time="
				+ limit_time + ", limit_anonym=" + limit_anonym + ", hashtag=" + hashtag + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hashtag == null) ? 0 : hashtag.hashCode());
		result = prime * result + limit_anonym;
		result = prime * result + limit_capacity;
		result = prime * result + limit_time;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ChannelsJoinChannelsHashtagModel other = (ChannelsJoinChannelsHashtagModel) obj;
		if (hashtag == null) {
			if (other.hashtag != null)
				return false;
		} else if (!hashtag.equals(other.hashtag))
			return false;
		if (limit_anonym != other.limit_anonym)
			return false;
		if (limit_capacity != other.limit_capacity)
			return false;
		if (limit_time != other.limit_time)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}