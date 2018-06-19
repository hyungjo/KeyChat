package com.keychat.dto.base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

		return new EqualsBuilder()
				.append(limitCapacity, that.limitCapacity)
				.append(limitTime, that.limitTime)
				.append(name, that.name)
				.append(leader, that.leader)
				.append(password, that.password)
				.append(limitAnonym, that.limitAnonym)
				.append(createdDatetime, that.createdDatetime)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(name)
				.append(leader)
				.append(password)
				.append(limitCapacity)
				.append(limitTime)
				.append(limitAnonym)
				.append(createdDatetime)
				.toHashCode();
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