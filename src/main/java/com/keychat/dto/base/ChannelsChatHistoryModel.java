package com.keychat.dto.base;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class ChannelsChatHistoryModel implements Serializable {
	private String email;
	private String channel_name;
	private String contents;
	private Timestamp sent_datetime;

	public ChannelsChatHistoryModel(String email, String channel_name, String contents, Timestamp sent_datetime) {
		this.email = email;
		this.channel_name = channel_name;
		this.contents = contents;
		this.sent_datetime = sent_datetime;
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

	public Timestamp getSent_datetime() {
		return sent_datetime;
	}

	public void setSent_datetime(Timestamp sent_datetime) {
		this.sent_datetime = sent_datetime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ChannelsChatHistoryModel that = (ChannelsChatHistoryModel) o;
		return Objects.equals(email, that.email) &&
				Objects.equals(channel_name, that.channel_name) &&
				Objects.equals(contents, that.contents) &&
				Objects.equals(sent_datetime, that.sent_datetime);
	}

	@Override
	public int hashCode() {

		return Objects.hash(email, channel_name, contents, sent_datetime);
	}

	@Override
	public String toString() {
		return "ChannelsChatHistoryModel{" +
				"email='" + email + '\'' +
				", channel_name='" + channel_name + '\'' +
				", contents='" + contents + '\'' +
				", sent_datetime=" + sent_datetime +
				'}';
	}
}