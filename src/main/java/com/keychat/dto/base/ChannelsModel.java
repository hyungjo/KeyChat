package com.keychat.dto.base;

import java.io.Serializable;
import java.sql.Date;

public class ChannelsModel implements Serializable{
	private String name;
	private String leader;
	private int password;
	private int limit_capacity;
	private int limit_time;
	private int limit_anonym;
	private Date created_datetime;
	public ChannelsModel() {
		super();
	}
	public ChannelsModel(String name, String leader, int password, int limit_capacity, int limit_time, int limit_anonym,
			Date created_datetime) {
		super();
		this.name = name;
		this.leader = leader;
		this.password = password;
		this.limit_capacity = limit_capacity;
		this.limit_time = limit_time;
		this.limit_anonym = limit_anonym;
		this.created_datetime = created_datetime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
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
	public Date getCreated_datetime() {
		return created_datetime;
	}
	public void setCreated_datetime(Date created_datetime) {
		this.created_datetime = created_datetime;
	}
	@Override
	public String toString() {
		return "channels_dto [name=" + name + ", leader=" + leader + ", password=" + password + ", limit_capacity="
				+ limit_capacity + ", limit_time=" + limit_time + ", limit_anonym=" + limit_anonym
				+ ", created_datetime=" + created_datetime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created_datetime == null) ? 0 : created_datetime.hashCode());
		result = prime * result + ((leader == null) ? 0 : leader.hashCode());
		result = prime * result + limit_anonym;
		result = prime * result + limit_capacity;
		result = prime * result + limit_time;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + password;
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
		ChannelsModel other = (ChannelsModel) obj;
		if (created_datetime == null) {
			if (other.created_datetime != null)
				return false;
		} else if (!created_datetime.equals(other.created_datetime))
			return false;
		if (leader == null) {
			if (other.leader != null)
				return false;
		} else if (!leader.equals(other.leader))
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
		if (password != other.password)
			return false;
		return true;
	}
	
}