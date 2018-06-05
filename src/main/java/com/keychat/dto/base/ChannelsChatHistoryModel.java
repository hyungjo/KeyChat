package com.keychat.dto.base;

import java.io.Serializable;
import java.sql.Date;

public class ChannelsChatHistoryModel implements Serializable {
	private int channels_chat_history_id;
	private String email;
	private String channel_name;
	private String contents;
	private Date sent_datetime;

	public ChannelsChatHistoryModel() {
		super();
	}

	public ChannelsChatHistoryModel(int channels_chat_history_id, String email, String channel_name, String contents,
			Date sent_datetime) {
		super();
		this.channels_chat_history_id = channels_chat_history_id;
		this.email = email;
		this.channel_name = channel_name;
		this.contents = contents;
		this.sent_datetime = sent_datetime;
	}

	public int getChannels_chat_history_id() {
		return channels_chat_history_id;
	}

	public void setChannels_chat_history_id(int channels_chat_history_id) {
		this.channels_chat_history_id = channels_chat_history_id;
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

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getSent_datetime() {
		return sent_datetime;
	}

	public void setSent_datetime(Date sent_datetime) {
		this.sent_datetime = sent_datetime;
	}

	@Override
	public String toString() {
		return "channels_chat_history_dto [channels_chat_history_id=" + channels_chat_history_id + ", email=" + email
				+ ", channel_name=" + channel_name + ", contents=" + contents + ", sent_datetime=" + sent_datetime
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channel_name == null) ? 0 : channel_name.hashCode());
		result = prime * result + channels_chat_history_id;
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((sent_datetime == null) ? 0 : sent_datetime.hashCode());
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
		ChannelsChatHistoryModel other = (ChannelsChatHistoryModel) obj;
		if (channel_name == null) {
			if (other.channel_name != null)
				return false;
		} else if (!channel_name.equals(other.channel_name))
			return false;
		if (channels_chat_history_id != other.channels_chat_history_id)
			return false;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (sent_datetime == null) {
			if (other.sent_datetime != null)
				return false;
		} else if (!sent_datetime.equals(other.sent_datetime))
			return false;
		return true;
	}
}