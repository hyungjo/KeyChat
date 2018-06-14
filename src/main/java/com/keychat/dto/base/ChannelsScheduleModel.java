package com.keychat.dto.base;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class ChannelsScheduleModel  implements Serializable {
	private int channels_schedule_id;
	private String schedule_name;
	private String channel_name;
	private String email;
	private Timestamp start_datetime;
	private Timestamp end_datetime;

	public ChannelsScheduleModel() {
		super();
	}

	public ChannelsScheduleModel(int channels_schedule_id, String schedule_name, String channel_name, String email,
			Timestamp start_datetime, Timestamp end_datetime) {
		super();
		this.channels_schedule_id = channels_schedule_id;
		this.schedule_name = schedule_name;
		this.channel_name = channel_name;
		this.email = email;
		this.start_datetime = start_datetime;
		this.end_datetime = end_datetime;
	}

	public int getChannels_schedule_id() {
		return channels_schedule_id;
	}

	public void setChannels_schedule_id(int channels_schedule_id) {
		this.channels_schedule_id = channels_schedule_id;
	}

	public String getSchedule_name() {
		return schedule_name;
	}

	public void setSchedule_name(String schedule_name) {
		this.schedule_name = schedule_name;
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

	public Timestamp getStart_datetime() {
		return start_datetime;
	}

	public void setStart_datetime(Timestamp start_datetime) {
		this.start_datetime = start_datetime;
	}

	public Timestamp getEnd_datetime() {
		return end_datetime;
	}

	public void setEnd_datetime(Timestamp end_datetime) {
		this.end_datetime = end_datetime;
	}

	@Override
	public String toString() {
		return "ChannelsScheduleModel [channels_schedule_id=" + channels_schedule_id + ", schedule_name="
				+ schedule_name + ", channel_name=" + channel_name + ", email=" + email + ", start_datetime="
				+ start_datetime + ", end_datetime=" + end_datetime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channel_name == null) ? 0 : channel_name.hashCode());
		result = prime * result + channels_schedule_id;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((end_datetime == null) ? 0 : end_datetime.hashCode());
		result = prime * result + ((schedule_name == null) ? 0 : schedule_name.hashCode());
		result = prime * result + ((start_datetime == null) ? 0 : start_datetime.hashCode());
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
		ChannelsScheduleModel other = (ChannelsScheduleModel) obj;
		if (channel_name == null) {
			if (other.channel_name != null)
				return false;
		} else if (!channel_name.equals(other.channel_name))
			return false;
		if (channels_schedule_id != other.channels_schedule_id)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (end_datetime == null) {
			if (other.end_datetime != null)
				return false;
		} else if (!end_datetime.equals(other.end_datetime))
			return false;
		if (schedule_name == null) {
			if (other.schedule_name != null)
				return false;
		} else if (!schedule_name.equals(other.schedule_name))
			return false;
		if (start_datetime == null) {
			if (other.start_datetime != null)
				return false;
		} else if (!start_datetime.equals(other.start_datetime))
			return false;
		return true;
	}
}
