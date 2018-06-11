package com.keychat.dto.base;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class ChannelsModel implements Serializable{
	private String name;
	private String leader;
	private String password;
	private int limitCapacity;
	private int limitTime;
	private String limitAnonym;
	private Timestamp createdDatetime;

	public ChannelsModel(String name, String leader, String password, int limitCapacity, int limitTime, String limitAnonym, Timestamp createdDatetime) {
		this.name = name;
		this.leader = leader;
		this.password = password;
		this.limitCapacity = limitCapacity;
		this.limitTime = limitTime;
		this.limitAnonym = limitAnonym;
		this.createdDatetime = createdDatetime;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLimitCapacity() {
		return limitCapacity;
	}

	public void setLimitCapacity(int limitCapacity) {
		this.limitCapacity = limitCapacity;
	}

	public int getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(int limitTime) {
		this.limitTime = limitTime;
	}

	public String getLimitAnonym() {
		return limitAnonym;
	}

	public void setLimitAnonym(String limitAnonym) {
		this.limitAnonym = limitAnonym;
	}

	public Timestamp getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Timestamp createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ChannelsModel that = (ChannelsModel) o;
		return password == that.password &&
				limitCapacity == that.limitCapacity &&
				limitTime == that.limitTime &&
				Objects.equals(name, that.name) &&
				Objects.equals(leader, that.leader) &&
				Objects.equals(limitAnonym, that.limitAnonym) &&
				Objects.equals(createdDatetime, that.createdDatetime);
	}

	@Override
	public int hashCode() {

		return Objects.hash(name, leader, password, limitCapacity, limitTime, limitAnonym, createdDatetime);
	}

	@Override
	public String toString() {
		return "ChannelsModel{" +
				"name='" + name + '\'' +
				", leader='" + leader + '\'' +
				", password=" + password +
				", limitCapacity=" + limitCapacity +
				", limitTime=" + limitTime +
				", limitAnonym='" + limitAnonym + '\'' +
				", createdDatetime=" + createdDatetime +
				'}';
	}
}